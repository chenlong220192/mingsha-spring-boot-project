package site.mingsha.boot.example.websocket.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MessageServiceTest {
    @Autowired
    private MessageService messageService;

    @Test
    void testAddAndRemoveOnlineUser() {
        String userId = "testUser";
        messageService.addOnlineUser(userId);
        List<String> users = messageService.getOnlineUsers();
        assertTrue(users.contains(userId));
        
        messageService.removeOnlineUser(userId);
        users = messageService.getOnlineUsers();
        assertFalse(users.contains(userId));
    }

    @Test
    void testGetOnlineUsers() {
        messageService.addOnlineUser("user1");
        messageService.addOnlineUser("user2");
        
        List<String> users = messageService.getOnlineUsers();
        assertTrue(users.contains("user1"));
        assertTrue(users.contains("user2"));
    }

    @Test
    void testGetConnectionStats() {
        messageService.addOnlineUser("user1");
        Map<String, Object> stats = messageService.getConnectionStats();
        
        assertNotNull(stats.get("onlineUsers"));
        assertNotNull(stats.get("totalConnections"));
        assertNotNull(stats.get("lastUpdate"));
    }

    @Test
    void testSendMessageToUser() {
        assertDoesNotThrow(() -> {
            messageService.sendMessageToUser("testUser", "Hello World");
        });
    }

    @Test
    void testBroadcastMessage() {
        assertDoesNotThrow(() -> {
            messageService.broadcastMessage("Broadcast message");
        });
    }
} 