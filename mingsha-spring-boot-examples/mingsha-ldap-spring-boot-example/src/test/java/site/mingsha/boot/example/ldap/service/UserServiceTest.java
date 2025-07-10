package site.mingsha.boot.example.ldap.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.mingsha.boot.example.ldap.entity.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void testCreateAndGetUser() {
        User user = new User("testuser", "测试用户", "test@example.com");
        User created = userService.createUser(user);
        
        assertNotNull(created);
        assertNotNull(created.getId());
        assertEquals("testuser", created.getUsername());
        
        User found = userService.getUser(created.getUsername());
        assertNotNull(found);
        assertEquals(created.getUsername(), found.getUsername());
    }

    @Test
    void testGetAllUsers() {
        User user1 = new User("user1", "用户1", "user1@example.com");
        User user2 = new User("user2", "用户2", "user2@example.com");
        
        userService.createUser(user1);
        userService.createUser(user2);
        
        List<User> users = userService.getAllUsers();
        assertNotNull(users);
        assertTrue(users.size() >= 2);
    }

    @Test
    void testGetUserByEmail() {
        User user = new User("uniqueuser", "唯一用户", "unique@example.com");
        userService.createUser(user);
        
        User found = userService.getUserByEmail("unique@example.com");
        assertNotNull(found);
        assertEquals("unique@example.com", found.getEmail());
    }

    @Test
    void testUpdateUser() {
        User user = new User("updateuser", "更新用户", "update@example.com");
        User created = userService.createUser(user);
        
        // 更新用户
        created.setEmail("updated@example.com");
        created.setPhone("13800138000");
        User updated = userService.updateUser(created);
        
        assertNotNull(updated);
        assertEquals("updated@example.com", updated.getEmail());
        assertEquals("13800138000", updated.getPhone());
    }

    @Test
    void testDeleteUser() {
        User user = new User("deleteuser", "删除用户", "delete@example.com");
        User created = userService.createUser(user);
        
        // 删除用户
        boolean deleted = userService.deleteUser(created.getUsername());
        assertTrue(deleted);
        
        // 验证用户已被删除
        User found = userService.getUser(created.getUsername());
        assertNull(found);
    }
} 