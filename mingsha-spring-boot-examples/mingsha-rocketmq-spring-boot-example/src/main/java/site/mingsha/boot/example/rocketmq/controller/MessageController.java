package site.mingsha.boot.example.rocketmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.mingsha.boot.example.rocketmq.service.MessageService;

/**
 * 消息控制器 - 演示 RocketMQ 消息发送
 */
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 发送同步消息
     */
    @PostMapping("/sync")
    public ResponseEntity<String> sendSyncMessage(@RequestParam String topic,
                                                 @RequestParam String message) {
        messageService.sendSyncMessage(topic, message);
        return ResponseEntity.ok("同步消息发送成功到主题: " + topic);
    }

    /**
     * 发送异步消息
     */
    @PostMapping("/async")
    public ResponseEntity<String> sendAsyncMessage(@RequestParam String topic,
                                                  @RequestParam String message) {
        messageService.sendAsyncMessage(topic, message);
        return ResponseEntity.ok("异步消息发送成功到主题: " + topic);
    }

    /**
     * 发送延迟消息
     */
    @PostMapping("/delay")
    public ResponseEntity<String> sendDelayMessage(@RequestParam String topic,
                                                  @RequestParam String message,
                                                  @RequestParam(defaultValue = "3") int delayLevel) {
        messageService.sendDelayMessage(topic, message, delayLevel);
        return ResponseEntity.ok("延迟消息发送成功，延迟级别: " + delayLevel);
    }

    /**
     * 发送顺序消息
     */
    @PostMapping("/order")
    public ResponseEntity<String> sendOrderMessage(@RequestParam String topic,
                                                  @RequestParam String message,
                                                  @RequestParam String hashKey) {
        messageService.sendOrderMessage(topic, message, hashKey);
        return ResponseEntity.ok("顺序消息发送成功");
    }
} 