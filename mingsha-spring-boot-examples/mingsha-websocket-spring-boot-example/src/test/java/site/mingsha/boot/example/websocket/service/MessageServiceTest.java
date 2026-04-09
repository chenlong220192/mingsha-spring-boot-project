package site.mingsha.boot.example.websocket.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * 消息服务测试 - 单元测试
 */
@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    @Mock
    private SimpMessagingTemplate messagingTemplate;

    @InjectMocks
    private MessageService messageService;

    private MessageService freshService;

    @BeforeEach
    void setUp() {
        // 创建新的服务实例来隔离测试
        freshService = new MessageService();
    }

    @Test
    void testAddOnlineUser() {
        // When
        freshService.addOnlineUser("testUser");

        // Then
        List<String> users = freshService.getOnlineUsers();
        assertTrue(users.contains("testUser"));
    }

    @Test
    void testAddOnlineUser_Duplicate() {
        // Given
        freshService.addOnlineUser("testUser");

        // When
        freshService.addOnlineUser("testUser");

        // Then
        List<String> users = freshService.getOnlineUsers();
        assertEquals(1, users.size());
    }

    @Test
    void testRemoveOnlineUser() {
        // Given
        freshService.addOnlineUser("testUser");

        // When
        freshService.removeOnlineUser("testUser");

        // Then
        List<String> users = freshService.getOnlineUsers();
        assertFalse(users.contains("testUser"));
    }

    @Test
    void testAddAndRemoveOnlineUser() {
        // When
        freshService.addOnlineUser("testUser");

        // Then
        List<String> users = freshService.getOnlineUsers();
        assertTrue(users.contains("testUser"));

        // When
        freshService.removeOnlineUser("testUser");

        // Then
        users = freshService.getOnlineUsers();
        assertFalse(users.contains("testUser"));
    }

    @Test
    void testGetOnlineUsers() {
        // Given
        freshService.addOnlineUser("user1");
        freshService.addOnlineUser("user2");
        freshService.addOnlineUser("user3");

        // When
        List<String> users = freshService.getOnlineUsers();

        // Then
        assertNotNull(users);
        assertEquals(3, users.size());
        assertTrue(users.contains("user1"));
        assertTrue(users.contains("user2"));
        assertTrue(users.contains("user3"));
    }

    @Test
    void testGetConnectionStats() {
        // Given
        freshService.addOnlineUser("user1");
        freshService.addOnlineUser("user2");

        // When
        var stats = freshService.getConnectionStats();

        // Then
        assertNotNull(stats);
        assertNotNull(stats.get("onlineUsers"));
        assertNotNull(stats.get("totalConnections"));
        assertNotNull(stats.get("lastUpdate"));
    }

    @Test
    void testSendMessageToUser() {
        // Given
        doNothing().when(messagingTemplate).convertAndSendToUser(anyString(), anyString(), any(Object.class));

        // When & Then
        assertDoesNotThrow(() -> {
            messageService.sendMessageToUser("testUser", "Hello World");
        });

        // Then
        verify(messagingTemplate, times(1)).convertAndSendToUser(eq("testUser"), eq("/queue/messages"), eq("Hello World"));
    }

    @Test
    void testBroadcastMessage() {
        // Given
        doNothing().when(messagingTemplate).convertAndSend(anyString(), any(Object.class));

        // When & Then
        assertDoesNotThrow(() -> {
            messageService.broadcastMessage("Broadcast message");
        });

        // Then
        verify(messagingTemplate, times(1)).convertAndSend(eq("/topic/broadcast"), eq("Broadcast message"));
    }
}
