package site.mingsha.boot.example.redis.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import site.mingsha.boot.example.redis.entity.User;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * 用户服务测试 - 单元测试
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class UserServiceTest {

    @Mock
    private RedisTemplate<String, Object> redisTemplate;

    @Mock
    private ValueOperations<String, Object> valueOperations;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        lenient().when(redisTemplate.opsForValue()).thenReturn(valueOperations);
    }

    @Test
    void testGetString() {
        // Given
        when(valueOperations.get("test:key")).thenReturn("test:value");

        // When
        String value = userService.getString("test:key");

        // Then
        assertEquals("test:value", value);
    }

    @Test
    void testGetStringNotFound() {
        // Given
        when(valueOperations.get("nonexistent")).thenReturn(null);

        // When
        String value = userService.getString("nonexistent");

        // Then
        assertNull(value);
    }

    @Test
    void testDeleteKey() {
        // Given
        when(redisTemplate.delete("test:delete")).thenReturn(true);

        // When
        boolean deleted = userService.deleteKey("test:delete");

        // Then
        assertTrue(deleted);
    }

    @Test
    void testHasKey() {
        // Given
        when(redisTemplate.hasKey("test:key")).thenReturn(true);
        when(redisTemplate.hasKey("nonexistent")).thenReturn(false);

        // Then
        assertTrue(userService.hasKey("test:key"));
        assertFalse(userService.hasKey("nonexistent"));
    }

    @Test
    void testGetUserById_CacheHit() {
        // Given
        User cachedUser = new User(1L, "cachedUser", "cached@example.com", "password");
        when(valueOperations.get("user:1")).thenReturn(cachedUser);

        // When
        User result = userService.getUserById(1L);

        // Then
        assertNotNull(result);
        assertEquals("cachedUser", result.getUsername());
    }

    @Test
    void testGetUserById_CacheMiss() {
        // Given - 用户不在缓存中
        when(valueOperations.get("user:999")).thenReturn(null);

        // When
        User result = userService.getUserById(999L);

        // Then
        // 由于没有数据库，返回 null
        assertNull(result);
    }
}
