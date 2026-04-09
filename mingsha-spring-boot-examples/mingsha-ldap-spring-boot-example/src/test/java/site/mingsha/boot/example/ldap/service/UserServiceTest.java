package site.mingsha.boot.example.ldap.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import site.mingsha.boot.example.ldap.entity.User;

import javax.naming.Name;
import javax.naming.ldap.LdapName;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;/**
 * 用户服务测试 - 单元测试
 */
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private LdapTemplate ldapTemplate;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User("testuser", "测试用户", "test@example.com");
        try {
            testUser.setId(new LdapName(""));
        } catch (Exception e) {
            // ignore
        }
        testUser.setCreateTime(LocalDateTime.now());
        testUser.setUpdateTime(LocalDateTime.now());
    }

    @Test
    void testCreateUser() {
        // Given
        doNothing().when(ldapTemplate).create(any(User.class));

        // When
        User result = userService.createUser(testUser);

        // Then
        assertNotNull(result);
        assertEquals("testuser", result.getUsername());
        assertNotNull(result.getCreateTime());
        assertNotNull(result.getUpdateTime());
        verify(ldapTemplate, times(1)).create(any(User.class));
    }

    @Test
    void testGetUser() {
        // Given
        when(ldapTemplate.find(any(LdapQuery.class), eq(User.class))).thenReturn(Arrays.asList(testUser));

        // When
        User result = userService.getUser("testuser");

        // Then
        assertNotNull(result);
        assertEquals("testuser", result.getUsername());
        verify(ldapTemplate, times(1)).find(any(LdapQuery.class), eq(User.class));
    }

    @Test
    void testGetUserNotFound() {
        // Given
        when(ldapTemplate.find(any(LdapQuery.class), eq(User.class))).thenReturn(Arrays.asList());

        // When
        User result = userService.getUser("nonexistent");

        // Then
        assertNull(result);
    }

    @Test
    void testGetAllUsers() {
        // Given
        User user1 = new User("user1", "用户1", "user1@example.com");
        User user2 = new User("user2", "用户2", "user2@example.com");
        when(ldapTemplate.find(any(LdapQuery.class), eq(User.class))).thenReturn(Arrays.asList(user1, user2));

        // When
        List<User> result = userService.getAllUsers();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(ldapTemplate, times(1)).find(any(LdapQuery.class), eq(User.class));
    }

    @Test
    void testGetUserByEmail() {
        // Given
        when(ldapTemplate.find(any(LdapQuery.class), eq(User.class))).thenReturn(Arrays.asList(testUser));

        // When
        User result = userService.getUserByEmail("test@example.com");

        // Then
        assertNotNull(result);
        assertEquals("test@example.com", result.getEmail());
        verify(ldapTemplate, times(1)).find(any(LdapQuery.class), eq(User.class));
    }

    @Test
    void testUpdateUser() {
        // Given
        when(ldapTemplate.find(any(LdapQuery.class), eq(User.class))).thenReturn(Arrays.asList(testUser));
        doNothing().when(ldapTemplate).update(any(User.class));

        testUser.setEmail("updated@example.com");

        // When
        User result = userService.updateUser(testUser);

        // Then
        assertNotNull(result);
        verify(ldapTemplate, times(1)).update(any(User.class));
    }

    @Test
    void testUpdateUserNotFound() {
        // Given
        when(ldapTemplate.find(any(LdapQuery.class), eq(User.class))).thenReturn(Arrays.asList());

        // When
        User result = userService.updateUser(testUser);

        // Then
        assertNull(result);
        verify(ldapTemplate, never()).update(any(User.class));
    }

    @Test
    void testDeleteUser() {
        // Given
        when(ldapTemplate.find(any(LdapQuery.class), eq(User.class))).thenReturn(Arrays.asList(testUser));
        // delete 方法返回 void，使用 doNothing mock
        doNothing().when(ldapTemplate).delete(any(User.class));

        // When
        boolean result = userService.deleteUser("testuser");

        // Then
        assertTrue(result);
        verify(ldapTemplate, times(1)).delete(any(User.class));
    }

    @Test
    void testDeleteUserNotFound() {
        // Given
        when(ldapTemplate.find(any(LdapQuery.class), eq(User.class))).thenReturn(Arrays.asList());

        // When
        boolean result = userService.deleteUser("nonexistent");

        // Then
        assertFalse(result);
        verify(ldapTemplate, never()).delete(any(User.class));
    }
}
