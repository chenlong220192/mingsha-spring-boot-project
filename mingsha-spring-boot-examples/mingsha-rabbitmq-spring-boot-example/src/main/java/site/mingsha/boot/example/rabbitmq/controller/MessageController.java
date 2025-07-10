package site.mingsha.boot.example.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.mingsha.boot.example.rabbitmq.service.MessageService;

/**
 * 消息控制器 - 演示 RabbitMQ 消息发送
 */
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 发送简单消息
     */
    @PostMapping("/simple")
    public ResponseEntity<String> sendSimpleMessage(@RequestParam String message) {
        messageService.sendSimpleMessage(message);
        return ResponseEntity.ok("简单消息发送成功: " + message);
    }

    /**
     * 发送延迟消息
     */
    @PostMapping("/delay")
    public ResponseEntity<String> sendDelayMessage(@RequestParam String message, 
                                                  @RequestParam(defaultValue = "5000") long delay) {
        messageService.sendDelayMessage(message, delay);
        return ResponseEntity.ok("延迟消息发送成功: " + message + ", 延迟: " + delay + "ms");
    }

    /**
     * 发送广播消息
     */
    @PostMapping("/broadcast")
    public ResponseEntity<String> sendBroadcastMessage(@RequestParam String message) {
        messageService.sendBroadcastMessage(message);
        return ResponseEntity.ok("广播消息发送成功: " + message);
    }
} 