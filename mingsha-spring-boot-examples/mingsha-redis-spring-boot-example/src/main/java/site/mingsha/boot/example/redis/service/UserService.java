package site.mingsha.boot.example.redis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import site.mingsha.boot.example.redis.entity.User;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 用户服务类 - 演示 Redis 使用
 *
 * @author mingsha
 * @date 2025-01-10
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 模拟数据库数据
    private final List<User> userDatabase = new ArrayList<>();

    public UserService() {
        // 初始化一些测试数据
        userDatabase.add(new User(1L, "admin", "admin@example.com", "password123"));
        userDatabase.add(new User(2L, "user1", "user1@example.com", "password123"));
        userDatabase.add(new User(3L, "user2", "user2@example.com", "password123"));
    }

    /**
     * 根据ID获取用户（带Redis缓存）
     */
    public User getUserById(Long id) {
        String cacheKey = "user:" + id;
        
        // 先从Redis获取
        User cachedUser = (User) redisTemplate.opsForValue().get(cacheKey);
        if (cachedUser != null) {
            logger.info("从Redis缓存获取用户: {}", cachedUser);
            return cachedUser;
        }

        // 缓存未命中，从数据库获取
        logger.info("Redis缓存未命中，从数据库获取用户ID: {}", id);
        User user = findUserFromDatabase(id);
        
        if (user != null) {
            // 放入Redis缓存，设置过期时间为1小时
            redisTemplate.opsForValue().set(cacheKey, user, Duration.ofHours(1));
            logger.info("用户已放入Redis缓存: {}", user);
        }
        
        return user;
    }

    /**
     * 根据用户名获取用户（带Redis缓存）
     */
    public User getUserByUsername(String username) {
        String cacheKey = "user:username:" + username;
        
        // 先从Redis获取
        User cachedUser = (User) redisTemplate.opsForValue().get(cacheKey);
        if (cachedUser != null) {
            logger.info("从Redis缓存获取用户: {}", cachedUser);
            return cachedUser;
        }

        // 缓存未命中，从数据库获取
        logger.info("Redis缓存未命中，从数据库获取用户名: {}", username);
        User user = findUserByUsernameFromDatabase(username);
        
        if (user != null) {
            // 放入Redis缓存，设置过期时间为1小时
            redisTemplate.opsForValue().set(cacheKey, user, Duration.ofHours(1));
            logger.info("用户已放入Redis缓存: {}", user);
        }
        
        return user;
    }

    /**
     * 创建用户
     */
    public User createUser(User user) {
        // 模拟数据库操作
        user.setId(System.currentTimeMillis());
        userDatabase.add(user);
        
        // 清除相关缓存
        redisTemplate.delete("user:" + user.getId());
        redisTemplate.delete("user:username:" + user.getUsername());
        
        logger.info("创建用户成功: {}", user);
        return user;
    }

    /**
     * 更新用户
     */
    public User updateUser(Long id, User user) {
        User existingUser = findUserFromDatabase(id);
        if (existingUser == null) {
            return null;
        }

        // 更新用户信息
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setUpdatedTime(java.time.LocalDateTime.now());

        // 清除相关缓存
        redisTemplate.delete("user:" + id);
        redisTemplate.delete("user:username:" + existingUser.getUsername());
        
        logger.info("更新用户成功: {}", existingUser);
        return existingUser;
    }

    /**
     * 删除用户
     */
    public boolean deleteUser(Long id) {
        User user = findUserFromDatabase(id);
        if (user == null) {
            return false;
        }

        // 从数据库删除
        userDatabase.removeIf(u -> u.getId().equals(id));
        
        // 清除相关缓存
        redisTemplate.delete("user:" + id);
        redisTemplate.delete("user:username:" + user.getUsername());
        
        logger.info("删除用户成功: {}", user);
        return true;
    }

    /**
     * 获取所有用户
     */
    public List<User> getAllUsers() {
        return new ArrayList<>(userDatabase);
    }

    /**
     * 设置字符串值
     */
    public void setString(String key, String value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
        logger.info("设置字符串值: {} = {}", key, value);
    }

    /**
     * 获取字符串值
     */
    public String getString(String key) {
        Object value = redisTemplate.opsForValue().get(key);
        logger.info("获取字符串值: {} = {}", key, value);
        return value != null ? value.toString() : null;
    }

    /**
     * 设置哈希值
     */
    public void setHash(String key, String hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
        logger.info("设置哈希值: {} -> {} = {}", key, hashKey, value);
    }

    /**
     * 获取哈希值
     */
    public Object getHash(String key, String hashKey) {
        Object value = redisTemplate.opsForHash().get(key, hashKey);
        logger.info("获取哈希值: {} -> {} = {}", key, hashKey, value);
        return value;
    }

    /**
     * 添加到列表
     */
    public void addToList(String key, Object value) {
        redisTemplate.opsForList().rightPush(key, value);
        logger.info("添加到列表: {} -> {}", key, value);
    }

    /**
     * 获取列表
     */
    public List<Object> getList(String key) {
        List<Object> list = redisTemplate.opsForList().range(key, 0, -1);
        logger.info("获取列表: {} = {}", key, list);
        return list;
    }

    /**
     * 添加到集合
     */
    public void addToSet(String key, Object value) {
        redisTemplate.opsForSet().add(key, value);
        logger.info("添加到集合: {} -> {}", key, value);
    }

    /**
     * 获取集合
     */
    public java.util.Set<Object> getSet(String key) {
        java.util.Set<Object> set = redisTemplate.opsForSet().members(key);
        logger.info("获取集合: {} = {}", key, set);
        return set;
    }

    /**
     * 设置有序集合
     */
    public void addToZSet(String key, Object value, double score) {
        redisTemplate.opsForZSet().add(key, value, score);
        logger.info("添加到有序集合: {} -> {} (score: {})", key, value, score);
    }

    /**
     * 获取有序集合
     */
    public java.util.Set<Object> getZSet(String key) {
        java.util.Set<Object> zset = redisTemplate.opsForZSet().range(key, 0, -1);
        logger.info("获取有序集合: {} = {}", key, zset);
        return zset;
    }

    /**
     * 删除键
     */
    public boolean deleteKey(String key) {
        Boolean result = redisTemplate.delete(key);
        logger.info("删除键: {} = {}", key, result);
        return result != null && result;
    }

    /**
     * 检查键是否存在
     */
    public boolean hasKey(String key) {
        Boolean result = redisTemplate.hasKey(key);
        logger.info("检查键是否存在: {} = {}", key, result);
        return result != null && result;
    }

    /**
     * 设置过期时间
     */
    public boolean expire(String key, long timeout, TimeUnit unit) {
        Boolean result = redisTemplate.expire(key, timeout, unit);
        logger.info("设置过期时间: {} = {} {}", key, timeout, unit);
        return result != null && result;
    }

    /**
     * 获取过期时间
     */
    public long getExpire(String key, TimeUnit unit) {
        Long expire = redisTemplate.getExpire(key, unit);
        logger.info("获取过期时间: {} = {} {}", key, expire, unit);
        return expire != null ? expire : -1;
    }

    /**
     * 清除所有缓存
     */
    public void clearCache() {
        redisTemplate.getConnectionFactory().getConnection().flushDb();
        logger.info("所有Redis缓存已清除");
    }

    /**
     * 从数据库查找用户（模拟）
     */
    private User findUserFromDatabase(Long id) {
        // 模拟数据库查询延迟
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        return userDatabase.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * 根据用户名从数据库查找用户（模拟）
     */
    private User findUserByUsernameFromDatabase(String username) {
        // 模拟数据库查询延迟
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        return userDatabase.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
} 