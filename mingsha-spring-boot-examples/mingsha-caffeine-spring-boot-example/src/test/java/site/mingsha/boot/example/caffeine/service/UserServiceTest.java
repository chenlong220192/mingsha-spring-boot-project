package site.mingsha.boot.example.caffeine.service;

import com.github.benmanes.caffeine.cache.Cache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import site.mingsha.boot.example.caffeine.entity.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private Cache<String, User> userCache;

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
        // 通过反射注入 mock 的 Cache
        try {
            var field = UserService.class.getDeclaredField("userCache");
            field.setAccessible(true);
            field.set(userService, userCache);
        } catch (Exception e) {
            fail("Failed to inject mock cache: " + e.getMessage());
        }
    }

    @Test
    void testCreateAndGetUser() {
        // 准备测试数据
        User testUser = new User();
        testUser.setUsername("testuser");
        testUser.setEmail("test@example.com");

        // 执行测试
        User created = userService.createUser(testUser);
        assertNotNull(created.getId());

        // 验证 createUser 调用了 invalidate
        verify(userCache, atLeastOnce()).invalidate(any());
    }

    @Test
    void testCacheHit() {
        // 准备测试数据
        Long userId = 1L;
        User cachedUser = new User();
        cachedUser.setId(userId);
        cachedUser.setUsername("cacheduser");
        cachedUser.setEmail("cached@example.com");

        // Mock cache 行为：getIfPresent 返回缓存的用户
        when(userCache.getIfPresent("user:" + userId)).thenReturn(cachedUser);

        // 执行测试
        User found = userService.getUserById(userId);

        // 验证结果
        assertNotNull(found);
        assertEquals("cacheduser", found.getUsername());
        verify(userCache).getIfPresent("user:" + userId);
    }

    @Test
    void testClearCache() {
        // 执行清除缓存
        userService.clearCache();

        // 验证 invalidateAll 被调用
        verify(userCache).invalidateAll();
    }

    @Test
    void testGetAllUsers() {
        // 执行测试
        var users = userService.getAllUsers();

        // 验证返回用户列表（初始化时应该有 3 个用户）
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }
}
