package site.mingsha.boot.example.mongodb.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import site.mingsha.boot.example.mongodb.entity.User;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * 用户服务测试 - 单元测试
 */
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User("testuser", "test@example.com", "password123");
        testUser.setId("user-1");
        testUser.setCreateTime(LocalDateTime.now());
        testUser.setUpdateTime(LocalDateTime.now());
    }

    @Test
    void testCreateUser() {
        // Given
        when(mongoTemplate.save(any(User.class))).thenReturn(testUser);

        // When
        User result = userService.createUser(testUser);

        // Then
        assertNotNull(result);
        assertEquals("testuser", result.getUsername());
        assertNotNull(result.getCreateTime());
        assertNotNull(result.getUpdateTime());
        verify(mongoTemplate, times(1)).save(any(User.class));
    }

    @Test
    void testGetUser() {
        // Given
        when(mongoTemplate.findById(anyString(), eq(User.class))).thenReturn(testUser);

        // When
        User result = userService.getUser("user-1");

        // Then
        assertNotNull(result);
        assertEquals("user-1", result.getId());
        assertEquals("testuser", result.getUsername());
        verify(mongoTemplate, times(1)).findById("user-1", User.class);
    }

    @Test
    void testGetUserNotFound() {
        // Given
        when(mongoTemplate.findById(anyString(), eq(User.class))).thenReturn(null);

        // When
        User result = userService.getUser("nonexistent");

        // Then
        assertNull(result);
    }

    @Test
    void testGetAllUsers() {
        // Given
        User user1 = new User("user1", "user1@example.com", "password1");
        User user2 = new User("user2", "user2@example.com", "password2");
        when(mongoTemplate.findAll(eq(User.class))).thenReturn(Arrays.asList(user1, user2));

        // When
        List<User> result = userService.getAllUsers();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(mongoTemplate, times(1)).findAll(User.class);
    }

    @Test
    void testGetUserByUsername() {
        // Given
        when(mongoTemplate.findOne(any(Query.class), eq(User.class))).thenReturn(testUser);

        // When
        User result = userService.getUserByUsername("testuser");

        // Then
        assertNotNull(result);
        assertEquals("testuser", result.getUsername());
        verify(mongoTemplate, times(1)).findOne(any(Query.class), eq(User.class));
    }

    @Test
    void testUpdateUser() {
        // Given
        when(mongoTemplate.findById(anyString(), eq(User.class))).thenReturn(testUser);
        when(mongoTemplate.save(any(User.class))).thenReturn(testUser);

        testUser.setEmail("updated@example.com");

        // When
        User result = userService.updateUser(testUser);

        // Then
        assertNotNull(result);
        verify(mongoTemplate, times(1)).findById(anyString(), eq(User.class));
        verify(mongoTemplate, times(1)).save(any(User.class));
    }

    @Test
    void testUpdateUserNotFound() {
        // Given
        when(mongoTemplate.findById(anyString(), eq(User.class))).thenReturn(null);

        // When
        User result = userService.updateUser(testUser);

        // Then
        assertNull(result);
        verify(mongoTemplate, never()).save(any(User.class));
    }

    @Test
    void testDeleteUser() {
        // Given
        when(mongoTemplate.findById(anyString(), eq(User.class))).thenReturn(testUser);
        // remove 方法返回 DeleteResult，我们不关心返回值，只需要 mock 不抛出异常
        when(mongoTemplate.remove(any(User.class))).thenReturn(null);

        // When
        boolean result = userService.deleteUser("user-1");

        // Then
        assertTrue(result);
        verify(mongoTemplate, times(1)).remove(testUser);
    }

    @Test
    void testDeleteUserNotFound() {
        // Given
        when(mongoTemplate.findById(anyString(), eq(User.class))).thenReturn(null);

        // When
        boolean result = userService.deleteUser("nonexistent");

        // Then
        assertFalse(result);
        verify(mongoTemplate, never()).remove(any(User.class));
    }
}
