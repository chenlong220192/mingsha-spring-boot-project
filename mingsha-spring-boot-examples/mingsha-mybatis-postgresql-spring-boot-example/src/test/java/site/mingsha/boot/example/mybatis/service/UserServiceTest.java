package site.mingsha.boot.example.mybatis.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import site.mingsha.boot.example.mybatis.entity.User;
import site.mingsha.boot.example.mybatis.mapper.UserMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * 用户服务测试类 - 单元测试
 *
 * @author mingsha
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
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
        verify(userMapper, times(1)).insert(any(User.class));
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
        verify(userMapper, times(1)).selectById(1L);
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
        verify(userMapper, times(1)).selectByUsername("testuser");
    }

    @Test
    public void testUpdateUser() {
        // Given
        when(userMapper.update(any(User.class))).thenReturn(1);

        // When
        boolean updated = userService.updateUser(testUser);

        // Then
        assertTrue(updated);
        verify(userMapper, times(1)).update(any(User.class));
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
        verify(userMapper, times(1)).deleteById(1L);
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
    public void testGetUsersByAgeRange() {
        // Given
        List<User> users = Arrays.asList(
            createUser(2L, "user1", 25),
            createUser(3L, "user2", 28)
        );
        when(userMapper.selectByAgeRange(25, 30)).thenReturn(users);

        // When
        List<User> result = userService.getUsersByAgeRange(25, 30);

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(userMapper, times(1)).selectByAgeRange(25, 30);
    }

    @Test
    public void testGetUsersByAddressLike() {
        // Given
        List<User> users = Arrays.asList(
            createUser(1L, "北京", 20),
            createUser(2L, "北京", 25)
        );
        when(userMapper.selectByAddressLike("北京")).thenReturn(users);

        // When
        List<User> result = userService.getUsersByAddressLike("北京");

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(userMapper, times(1)).selectByAddressLike("北京");
    }

    @Test
    public void testGetUserCount() {
        // Given
        when(userMapper.count()).thenReturn(10);

        // When
        int count = userService.getUserCount();

        // Then
        assertEquals(10, count);
        verify(userMapper, times(1)).count();
    }

    private User createUser(Long id, String address, Integer age) {
        User user = new User();
        user.setId(id);
        user.setUsername("user" + id);
        user.setEmail("user" + id + "@example.com");
        user.setAddress(address);
        user.setAge(age);
        return user;
    }
}
