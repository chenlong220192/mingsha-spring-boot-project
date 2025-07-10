package site.mingsha.boot.example.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.mingsha.boot.example.kafka.service.MessageService;

/**
 * 消息控制器 - 演示 Kafka 消息发送
 */
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 发送消息到指定主题
     */
    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam String topic,
                                            @RequestParam String message) {
        messageService.sendMessage(topic, message);
        return ResponseEntity.ok("消息发送成功到主题: " + topic);
    }

    /**
     * 发送消息到默认主题
     */
    @PostMapping("/send/default")
    public ResponseEntity<String> sendMessageToDefault(@RequestParam String message) {
        messageService.sendMessageToDefault(message);
        return ResponseEntity.ok("消息发送成功到默认主题");
    }

    /**
     * 批量发送消息
     */
    @PostMapping("/send/batch")
    public ResponseEntity<String> sendBatchMessages(@RequestParam String topic,
                                                   @RequestParam int count) {
        messageService.sendBatchMessages(topic, count);
        return ResponseEntity.ok("批量消息发送成功，数量: " + count);
    }
} 