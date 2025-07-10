package site.mingsha.boot.example.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import site.mingsha.boot.example.mongodb.entity.User;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户服务 - 演示 MongoDB 操作
 */
@Service
public class UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建用户
     */
    public User createUser(User user) {
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        return mongoTemplate.save(user);
    }

    /**
     * 根据ID查询用户
     */
    public User getUser(String id) {
        return mongoTemplate.findById(id, User.class);
    }

    /**
     * 查询所有用户
     */
    public List<User> getAllUsers() {
        return mongoTemplate.findAll(User.class);
    }

    /**
     * 根据用户名查询用户
     */
    public User getUserByUsername(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        return mongoTemplate.findOne(query, User.class);
    }

    /**
     * 更新用户
     */
    public User updateUser(User user) {
        User existing = getUser(user.getId());
        if (existing != null) {
            user.setCreateTime(existing.getCreateTime());
            user.setUpdateTime(LocalDateTime.now());
            return mongoTemplate.save(user);
        }
        return null;
    }

    /**
     * 删除用户
     */
    public boolean deleteUser(String id) {
        User user = getUser(id);
        if (user != null) {
            mongoTemplate.remove(user);
            return true;
        }
        return false;
    }
} 