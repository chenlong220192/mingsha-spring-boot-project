package site.mingsha.boot.example.websocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 消息服务 - 演示 WebSocket 消息发送
 */
@Service
public class MessageService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private final List<String> onlineUsers = new CopyOnWriteArrayList<>();
    private final Map<String, Object> connectionStats = new ConcurrentHashMap<>();

    /**
     * 发送消息到指定用户
     */
    public void sendMessageToUser(String userId, String message) {
        messagingTemplate.convertAndSendToUser(userId, "/queue/messages", message);
    }

    /**
     * 广播消息到所有用户
     */
    public void broadcastMessage(String message) {
        messagingTemplate.convertAndSend("/topic/broadcast", message);
    }

    /**
     * 添加在线用户
     */
    public void addOnlineUser(String userId) {
        if (!onlineUsers.contains(userId)) {
            onlineUsers.add(userId);
            updateConnectionStats();
        }
    }

    /**
     * 移除在线用户
     */
    public void removeOnlineUser(String userId) {
        onlineUsers.remove(userId);
        updateConnectionStats();
    }

    /**
     * 获取在线用户列表
     */
    public List<String> getOnlineUsers() {
        return new CopyOnWriteArrayList<>(onlineUsers);
    }

    /**
     * 获取连接统计信息
     */
    public Map<String, Object> getConnectionStats() {
        return new ConcurrentHashMap<>(connectionStats);
    }

    /**
     * 更新连接统计信息
     */
    private void updateConnectionStats() {
        connectionStats.put("onlineUsers", onlineUsers.size());
        connectionStats.put("totalConnections", onlineUsers.size());
        connectionStats.put("lastUpdate", System.currentTimeMillis());
    }
} 