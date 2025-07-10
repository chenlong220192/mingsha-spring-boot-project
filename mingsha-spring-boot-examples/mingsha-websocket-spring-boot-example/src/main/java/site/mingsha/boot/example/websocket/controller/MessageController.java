package site.mingsha.boot.example.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.mingsha.boot.example.websocket.service.MessageService;

import java.util.List;
import java.util.Map;

/**
 * 消息控制器 - 演示 WebSocket 消息发送
 */
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 发送消息到指定用户
     */
    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam String userId,
                                             @RequestParam String message) {
        messageService.sendMessageToUser(userId, message);
        return ResponseEntity.ok("消息发送成功");
    }

    /**
     * 广播消息到所有用户
     */
    @PostMapping("/broadcast")
    public ResponseEntity<String> broadcastMessage(@RequestParam String message) {
        messageService.broadcastMessage(message);
        return ResponseEntity.ok("广播消息发送成功");
    }

    /**
     * 获取在线用户列表
     */
    @GetMapping("/users/online")
    public ResponseEntity<List<String>> getOnlineUsers() {
        List<String> users = messageService.getOnlineUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * 获取连接统计信息
     */
    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getConnectionStats() {
        Map<String, Object> stats = messageService.getConnectionStats();
        return ResponseEntity.ok(stats);
    }
} 