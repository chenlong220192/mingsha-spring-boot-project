package site.mingsha.boot.example.caffeine.service;

import com.github.benmanes.caffeine.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.mingsha.boot.example.caffeine.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 用户服务类 - 演示 Caffeine 缓存使用
 *
 * @author mingsha
 * @date 2025-01-10
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private Cache<String, User> userCache;

    // 模拟数据库数据
    private final List<User> userDatabase = new ArrayList<>();

    public UserService() {
        // 初始化一些测试数据
        userDatabase.add(new User(1L, "admin", "admin@example.com", "password123"));
        userDatabase.add(new User(2L, "user1", "user1@example.com", "password123"));
        userDatabase.add(new User(3L, "user2", "user2@example.com", "password123"));
    }

    /**
     * 根据ID获取用户（带缓存）
     */
    public User getUserById(Long id) {
        String cacheKey = "user:" + id;
        
        // 先从缓存获取
        User cachedUser = userCache.getIfPresent(cacheKey);
        if (cachedUser != null) {
            logger.info("从缓存获取用户: {}", cachedUser);
            return cachedUser;
        }

        // 缓存未命中，从数据库获取
        logger.info("缓存未命中，从数据库获取用户ID: {}", id);
        User user = findUserFromDatabase(id);
        
        if (user != null) {
            // 放入缓存
            userCache.put(cacheKey, user);
            logger.info("用户已放入缓存: {}", user);
        }
        
        return user;
    }

    /**
     * 根据用户名获取用户（带缓存）
     */
    public User getUserByUsername(String username) {
        String cacheKey = "user:username:" + username;
        
        // 先从缓存获取
        User cachedUser = userCache.getIfPresent(cacheKey);
        if (cachedUser != null) {
            logger.info("从缓存获取用户: {}", cachedUser);
            return cachedUser;
        }

        // 缓存未命中，从数据库获取
        logger.info("缓存未命中，从数据库获取用户名: {}", username);
        User user = findUserByUsernameFromDatabase(username);
        
        if (user != null) {
            // 放入缓存
            userCache.put(cacheKey, user);
            logger.info("用户已放入缓存: {}", user);
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
        userCache.invalidate("user:" + user.getId());
        userCache.invalidate("user:username:" + user.getUsername());
        
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
        userCache.invalidate("user:" + id);
        userCache.invalidate("user:username:" + existingUser.getUsername());
        
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
        userCache.invalidate("user:" + id);
        userCache.invalidate("user:username:" + user.getUsername());
        
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
     * 清除所有缓存
     */
    public void clearCache() {
        userCache.invalidateAll();
        logger.info("所有缓存已清除");
    }

    /**
     * 获取缓存统计信息
     */
    public String getCacheStats() {
        return userCache.stats().toString();
    }

    /**
     * 从数据库查找用户（模拟）
     */
    private User findUserFromDatabase(Long id) {
        // 模拟数据库查询延迟
        try {
            TimeUnit.MILLISECONDS.sleep(100);
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
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        return userDatabase.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
} 