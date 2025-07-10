package site.mingsha.boot.example.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.mingsha.boot.example.mybatis.entity.User;
import site.mingsha.boot.example.mybatis.mapper.UserMapper;

import java.util.List;

/**
 * 用户服务类
 *
 * @author mingsha
 * @since 1.0.0
 */
@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    /**
     * 创建用户
     */
    public User createUser(User user) {
        userMapper.insert(user);
        return user;
    }
    
    /**
     * 根据ID查询用户
     */
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }
    
    /**
     * 根据用户名查询用户
     */
    public User getUserByUsername(String username) {
        return userMapper.selectByUsername(username);
    }
    
    /**
     * 查询所有用户
     */
    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }
    
    /**
     * 根据年龄范围查询用户
     */
    public List<User> getUsersByAgeRange(Integer minAge, Integer maxAge) {
        return userMapper.selectByAgeRange(minAge, maxAge);
    }
    
    /**
     * 更新用户信息
     */
    public boolean updateUser(User user) {
        return userMapper.update(user) > 0;
    }
    
    /**
     * 删除用户
     */
    public boolean deleteUser(Long id) {
        return userMapper.deleteById(id) > 0;
    }
    
    /**
     * 获取用户总数
     */
    public int getUserCount() {
        return userMapper.count();
    }
    
    /**
     * 根据地址模糊查询用户
     */
    public List<User> getUsersByAddressLike(String address) {
        return userMapper.selectByAddressLike(address);
    }
    
    /**
     * 批量创建用户
     */
    public void batchCreateUsers(List<User> users) {
        for (User user : users) {
            userMapper.insert(user);
        }
    }
} 