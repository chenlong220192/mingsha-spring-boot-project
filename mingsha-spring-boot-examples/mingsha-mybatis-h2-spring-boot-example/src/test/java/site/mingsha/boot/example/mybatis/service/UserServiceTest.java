package site.mingsha.boot.example.mybatis.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import site.mingsha.boot.example.mybatis.entity.User;
import site.mingsha.boot.example.mybatis.mapper.UserMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * 用户服务测试类 - 单元测试
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserServiceTest {

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User("testuser", "test@example.com", "13800138000", 25, "北京市朝阳区");
        testUser.setId(1L);
    }

    @Test
    public void testCreateUser() {
        // Given
        when(userMapper.insert(any(User.class))).thenReturn(1);

        // When
        User createdUser = userService.createUser(testUser);

        // Then
        assertNotNull(createdUser);
        assertEquals("testuser", createdUser.getUsername());
        assertEquals("test@example.com", createdUser.getEmail());
    }

    @Test
    public void testGetUserById() {
        // Given
        when(userMapper.selectById(1L)).thenReturn(testUser);

        // When
        User foundUser = userService.getUserById(1L);

        // Then
        assertNotNull(foundUser);
        assertEquals(1L, foundUser.getId());
        assertEquals("testuser", foundUser.getUsername());
    }

    @Test
    public void testGetUserByUsername() {
        // Given
        when(userMapper.selectByUsername("testuser")).thenReturn(testUser);

        // When
        User foundUser = userService.getUserByUsername("testuser");

        // Then
        assertNotNull(foundUser);
        assertEquals("testuser", foundUser.getUsername());
        assertEquals("test@example.com", foundUser.getEmail());
    }

    @Test
    public void testUpdateUser() {
        // Given
        when(userMapper.update(any(User.class))).thenReturn(1);

        // When
        boolean updated = userService.updateUser(testUser);

        // Then
        assertTrue(updated);
    }

    @Test
    public void testUpdateUserNotFound() {
        // Given
        when(userMapper.update(any(User.class))).thenReturn(0);

        // When
        boolean updated = userService.updateUser(testUser);

        // Then
        assertFalse(updated);
    }

    @Test
    public void testDeleteUser() {
        // Given
        when(userMapper.deleteById(1L)).thenReturn(1);

        // When
        boolean deleted = userService.deleteUser(1L);

        // Then
        assertTrue(deleted);
    }

    @Test
    public void testDeleteUserNotFound() {
        // Given
        when(userMapper.deleteById(999L)).thenReturn(0);

        // When
        boolean deleted = userService.deleteUser(999L);

        // Then
        assertFalse(deleted);
    }

    @Test
    public void testGetAllUsers() {
        // Given
        List<User> users = Arrays.asList(testUser);
        when(userMapper.selectAll()).thenReturn(users);

        // When
        List<User> result = userService.getAllUsers();

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testGetUserCount() {
        // Given
        when(userMapper.count()).thenReturn(10);

        // When
        int count = userService.getUserCount();

        // Then
        assertEquals(10, count);
    }
}
