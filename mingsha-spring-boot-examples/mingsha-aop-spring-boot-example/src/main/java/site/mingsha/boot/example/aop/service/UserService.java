package site.mingsha.boot.example.aop.service;

import org.springframework.stereotype.Service;

/**
 * 用户服务 - 演示AOP切面
 *
 * @author mingsha
 */
@Service
public class UserService {

    public String getUserInfo(String username) {
        // 模拟查询
        return "用户信息: " + username;
    }

    public void addUser(String username) {
        // 模拟添加
    }

    public void deleteUser(String username) {
        // 模拟删除
    }
} 