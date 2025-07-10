package site.mingsha.boot.example.kafka.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.mingsha.boot.example.kafka.dto.MessageRequest;
import site.mingsha.boot.example.kafka.dto.MessageResponse;
import site.mingsha.boot.example.kafka.dto.UserEventRequest;
import site.mingsha.boot.example.kafka.dto.UserEventResponse;
import site.mingsha.boot.example.kafka.service.KafkaMessageService;
import site.mingsha.boot.example.kafka.service.KafkaUserEventService;

import java.util.List;
import java.util.Map;

/**
 * Kafka 消息控制器
 *
 * @author mingsha
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/api/kafka")
@RequiredArgsConstructor
public class KafkaController {
    
    private final KafkaMessageService kafkaMessageService;
    private final KafkaUserEventService kafkaUserEventService;
    
    /**
     * 发送简单消息
     */
    @PostMapping("/send")
    public ResponseEntity<MessageResponse> sendMessage(@RequestBody MessageRequest request) {
        try {
            kafkaMessageService.sendMessage(request.getTopic(), request.getMessage());
            return ResponseEntity.ok(MessageResponse.success("消息发送成功"));
        } catch (Exception e) {
            log.error("发送消息失败", e);
            return ResponseEntity.badRequest().body(MessageResponse.error("消息发送失败: " + e.getMessage()));
        }
    }
    
    /**
     * 发送带键的消息
     */
    @PostMapping("/send-with-key")
    public ResponseEntity<MessageResponse> sendMessageWithKey(@RequestBody MessageRequest request) {
        try {
            kafkaMessageService.sendMessageWithKey(request.getTopic(), request.getKey(), request.getMessage());
            return ResponseEntity.ok(MessageResponse.success("消息发送成功"));
        } catch (Exception e) {
            log.error("发送消息失败", e);
            return ResponseEntity.badRequest().body(MessageResponse.error("消息发送失败: " + e.getMessage()));
        }
    }
    
    /**
     * 异步发送消息
     */
    @PostMapping("/send-async")
    public ResponseEntity<MessageResponse> sendMessageAsync(@RequestBody MessageRequest request) {
        try {
            kafkaMessageService.sendMessageAsync(request.getTopic(), request.getMessage());
            return ResponseEntity.ok(MessageResponse.success("消息发送请求已提交"));
        } catch (Exception e) {
            log.error("异步发送消息失败", e);
            return ResponseEntity.badRequest().body(MessageResponse.error("消息发送失败: " + e.getMessage()));
        }
    }
    
    /**
     * 批量发送消息
     */
    @PostMapping("/send-batch")
    public ResponseEntity<MessageResponse> sendBatchMessages(@RequestBody Map<String, Object> request) {
        try {
            String topic = (String) request.get("topic");
            @SuppressWarnings("unchecked")
            List<String> messages = (List<String>) request.get("messages");
            kafkaMessageService.sendBatchMessages(topic, messages);
            return ResponseEntity.ok(MessageResponse.success("批量消息发送成功"));
        } catch (Exception e) {
            log.error("批量发送消息失败", e);
            return ResponseEntity.badRequest().body(MessageResponse.error("批量消息发送失败: " + e.getMessage()));
        }
    }
    
    /**
     * 发送用户事件
     */
    @PostMapping("/send-user-event")
    public ResponseEntity<UserEventResponse> sendUserEvent(@RequestBody UserEventRequest request) {
        try {
            kafkaUserEventService.sendUserEvent(request);
            return ResponseEntity.ok(UserEventResponse.success("用户事件发送成功"));
        } catch (Exception e) {
            log.error("发送用户事件失败", e);
            return ResponseEntity.badRequest().body(UserEventResponse.error("用户事件发送失败: " + e.getMessage()));
        }
    }
    
    /**
     * 获取主题信息
     */
    @GetMapping("/topics")
    public ResponseEntity<MessageResponse> getTopics() {
        try {
            List<Map<String, Object>> topics = kafkaMessageService.getTopics();
            return ResponseEntity.ok(MessageResponse.success("获取主题信息成功", topics));
        } catch (Exception e) {
            log.error("获取主题信息失败", e);
            return ResponseEntity.badRequest().body(MessageResponse.error("获取主题信息失败: " + e.getMessage()));
        }
    }
    
    /**
     * 获取消费者组信息
     */
    @GetMapping("/consumer-groups")
    public ResponseEntity<MessageResponse> getConsumerGroups() {
        try {
            List<Map<String, Object>> groups = kafkaMessageService.getConsumerGroups();
            return ResponseEntity.ok(MessageResponse.success("获取消费者组信息成功", groups));
        } catch (Exception e) {
            log.error("获取消费者组信息失败", e);
            return ResponseEntity.badRequest().body(MessageResponse.error("获取消费者组信息失败: " + e.getMessage()));
        }
    }
    
    /**
     * 重置消费者偏移量
     */
    @PostMapping("/reset-offset")
    public ResponseEntity<MessageResponse> resetOffset(@RequestBody Map<String, String> request) {
        try {
            String groupId = request.get("groupId");
            String topic = request.get("topic");
            String offset = request.get("offset");
            kafkaMessageService.resetOffset(groupId, topic, offset);
            return ResponseEntity.ok(MessageResponse.success("偏移量重置成功"));
        } catch (Exception e) {
            log.error("重置偏移量失败", e);
            return ResponseEntity.badRequest().body(MessageResponse.error("重置偏移量失败: " + e.getMessage()));
        }
    }
    
    /**
     * 健康检查
     */
    @GetMapping("/health")
    public ResponseEntity<MessageResponse> health() {
        try {
            boolean isHealthy = kafkaMessageService.isHealthy();
            if (isHealthy) {
                return ResponseEntity.ok(MessageResponse.success("Kafka 连接正常"));
            } else {
                return ResponseEntity.status(503).body(MessageResponse.error("Kafka 连接异常"));
            }
        } catch (Exception e) {
            log.error("健康检查失败", e);
            return ResponseEntity.status(503).body(MessageResponse.error("健康检查失败: " + e.getMessage()));
        }
    }
} 