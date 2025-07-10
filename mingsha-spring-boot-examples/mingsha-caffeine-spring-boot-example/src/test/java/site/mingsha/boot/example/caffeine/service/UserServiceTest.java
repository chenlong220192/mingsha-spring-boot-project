package site.mingsha.boot.example.caffeine.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.mingsha.boot.example.caffeine.entity.User;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void testCreateAndGetUser() {
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        
        User created = userService.createUser(user);
        assertNotNull(created.getId());
        
        User found = userService.getUserById(created.getId());
        assertEquals("testuser", found.getUsername());
    }

    @Test
    void testCachePerformance() {
        User user = new User();
        user.setUsername("cacheuser");
        user.setEmail("cache@example.com");
        User created = userService.createUser(user);
        
        // 第一次查询（缓存未命中）
        long start1 = System.currentTimeMillis();
        userService.getUserById(created.getId());
        long time1 = System.currentTimeMillis() - start1;
        
        // 第二次查询（缓存命中）
        long start2 = System.currentTimeMillis();
        userService.getUserById(created.getId());
        long time2 = System.currentTimeMillis() - start2;
        
        // 缓存命中应该更快
        assertTrue(time2 <= time1);
    }

    @Test
    void testClearCache() {
        User user = new User();
        user.setUsername("clearcache");
        user.setEmail("clear@example.com");
        User created = userService.createUser(user);
        
        // 先查询一次，确保缓存
        userService.getUserById(created.getId());
        
        // 清除缓存
        userService.clearCache();
        
        // 再次查询应该仍然正常
        User found = userService.getUserById(created.getId());
        assertEquals("clearcache", found.getUsername());
    }
} 