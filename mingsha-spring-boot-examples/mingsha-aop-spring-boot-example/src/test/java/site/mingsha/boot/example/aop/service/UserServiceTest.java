package site.mingsha.boot.example.aop.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 用户服务测试 - 单元测试
 * 注意：UserService 是纯 Java 类，不依赖外部服务，无需 mock
 */
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        // 初始化操作（如果需要）
    }

    @Test
    void testGetUserInfo() {
        // Given
        String username = "zhangsan";

        // When
        String result = userService.getUserInfo(username);

        // Then
        assertEquals("用户信息: zhangsan", result);
    }

    @Test
    void testGetUserInfo_DifferentUsername() {
        // Given
        String username = "lisi";

        // When
        String result = userService.getUserInfo(username);

        // Then
        assertEquals("用户信息: lisi", result);
    }

    @Test
    void testAddUser() {
        // Given
        String username = "newuser";

        // When & Then
        assertDoesNotThrow(() -> {
            userService.addUser(username);
        });
    }

    @Test
    void testDeleteUser() {
        // Given
        String username = "deleteuser";

        // When & Then
        assertDoesNotThrow(() -> {
            userService.deleteUser(username);
        });
    }

    @Test
    void testAddAndDeleteUser() {
        // Given
        String username = "testuser";

        // When & Then
        assertDoesNotThrow(() -> {
            userService.addUser(username);
            userService.deleteUser(username);
        });
    }
}
