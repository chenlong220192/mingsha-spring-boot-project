package site.mingsha.boot.example.aop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * UserService AOP切面测试
 */
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetUserInfo() {
        String username = "zhangsan";
        String info = userService.getUserInfo(username);
        assertEquals("用户信息: zhangsan", info);
    }

    @Test
    public void testAddUser() {
        assertDoesNotThrow(() -> userService.addUser("lisi"));
    }

    @Test
    public void testDeleteUser() {
        assertDoesNotThrow(() -> userService.deleteUser("wangwu"));
    }
} 