package site.mingsha.boot.example.mongodb.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.mingsha.boot.example.mongodb.entity.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void testCreateAndGetUser() {
        User user = new User("testuser", "test@example.com", "password123");
        User created = userService.createUser(user);
        
        assertNotNull(created);
        assertNotNull(created.getId());
        assertEquals("testuser", created.getUsername());
        
        User found = userService.getUser(created.getId());
        assertNotNull(found);
        assertEquals(created.getId(), found.getId());
    }

    @Test
    void testGetAllUsers() {
        User user1 = new User("user1", "user1@example.com", "password1");
        User user2 = new User("user2", "user2@example.com", "password2");
        
        userService.createUser(user1);
        userService.createUser(user2);
        
        List<User> users = userService.getAllUsers();
        assertNotNull(users);
        assertTrue(users.size() >= 2);
    }

    @Test
    void testGetUserByUsername() {
        User user = new User("uniqueuser", "unique@example.com", "password");
        userService.createUser(user);
        
        User found = userService.getUserByUsername("uniqueuser");
        assertNotNull(found);
        assertEquals("uniqueuser", found.getUsername());
    }

    @Test
    void testUpdateUser() {
        User user = new User("updateuser", "update@example.com", "password");
        User created = userService.createUser(user);
        
        // 更新用户
        created.setEmail("updated@example.com");
        User updated = userService.updateUser(created);
        
        assertNotNull(updated);
        assertEquals("updated@example.com", updated.getEmail());
    }

    @Test
    void testDeleteUser() {
        User user = new User("deleteuser", "delete@example.com", "password");
        User created = userService.createUser(user);
        
        // 删除用户
        boolean deleted = userService.deleteUser(created.getId());
        assertTrue(deleted);
        
        // 验证用户已被删除
        User found = userService.getUser(created.getId());
        assertNull(found);
    }
} 