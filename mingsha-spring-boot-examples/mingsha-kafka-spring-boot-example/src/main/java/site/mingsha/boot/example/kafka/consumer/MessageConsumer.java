package site.mingsha.boot.example.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import site.mingsha.boot.example.kafka.entity.UserEvent;
import site.mingsha.boot.example.kafka.service.UserEventProcessService;

import java.util.List;

/**
 * 消息消费者
 *
 * @author mingsha
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MessageConsumer {
    
    private final ObjectMapper objectMapper;
    private final UserEventProcessService userEventProcessService;
    
    /**
     * 处理用户事件
     */
    @KafkaListener(topics = "user-events", groupId = "user-events-group")
    public void handleUserEvent(@Payload String message,
                               @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                               @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                               @Header(KafkaHeaders.OFFSET) long offset,
                               @Header(KafkaHeaders.RECEIVED_KEY) String key) {
        try {
            log.info("收到用户事件: topic={}, partition={}, offset={}, key={}", 
                    topic, partition, offset, key);
            
            // 反序列化用户事件
            UserEvent userEvent = objectMapper.readValue(message, UserEvent.class);
            
            // 处理用户事件
            userEventProcessService.processUserEvent(userEvent);
            
            log.info("用户事件处理成功: eventId={}, userId={}, eventType={}", 
                    userEvent.getEventId(), userEvent.getUserId(), userEvent.getEventType());
        } catch (Exception e) {
            log.error("处理用户事件失败: message={}", message, e);
            // 这里可以发送到死信队列
            sendToDeadLetterQueue(message, e);
        }
    }
    
    /**
     * 处理批量消息
     */
    @KafkaListener(topics = "batch-messages", groupId = "batch-messages-group")
    public void handleBatchMessages(List<String> messages) {
        log.info("收到批量消息，数量: {}", messages.size());
        
        for (String message : messages) {
            try {
                processMessage(message);
            } catch (Exception e) {
                log.error("处理消息失败: {}", e.getMessage(), e);
                sendToDeadLetterQueue(message, e);
            }
        }
    }
    
    /**
     * 处理系统消息
     */
    @KafkaListener(topics = "system-messages", groupId = "system-messages-group")
    public void handleSystemMessage(@Payload String message,
                                   @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                                   @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                                   @Header(KafkaHeaders.OFFSET) long offset) {
        try {
            log.info("收到系统消息: topic={}, partition={}, offset={}, message={}", 
                    topic, partition, offset, message);
            
            // 处理系统消息
            processSystemMessage(message);
            
        } catch (Exception e) {
            log.error("处理系统消息失败: message={}", message, e);
            sendToDeadLetterQueue(message, e);
        }
    }
    
    /**
     * 处理错误消息
     */
    @KafkaListener(topics = "error-messages", groupId = "error-messages-group")
    public void handleErrorMessage(@Payload String message,
                                  @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                                  @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                                  @Header(KafkaHeaders.OFFSET) long offset) {
        try {
            log.warn("收到错误消息: topic={}, partition={}, offset={}, message={}", 
                    topic, partition, offset, message);
            
            // 处理错误消息
            processErrorMessage(message);
            
        } catch (Exception e) {
            log.error("处理错误消息失败: message={}", message, e);
            // 错误消息处理失败，记录到日志
        }
    }
    
    /**
     * 处理消息
     */
    private void processMessage(String message) {
        log.info("处理消息: {}", message);
        // 具体的消息处理逻辑
        // 这里可以根据消息类型进行不同的处理
    }
    
    /**
     * 处理系统消息
     */
    private void processSystemMessage(String message) {
        log.info("处理系统消息: {}", message);
        // 系统消息处理逻辑
        // 例如：系统维护通知、配置更新等
    }
    
    /**
     * 处理错误消息
     */
    private void processErrorMessage(String message) {
        log.warn("处理错误消息: {}", message);
        // 错误消息处理逻辑
        // 例如：记录错误日志、发送告警等
    }
    
    /**
     * 发送到死信队列
     */
    private void sendToDeadLetterQueue(String message, Exception e) {
        try {
            log.warn("发送到死信队列: message={}, error={}", message, e.getMessage());
            // 这里可以实现发送到死信队列的逻辑
            // 例如：发送到专门的死信主题
        } catch (Exception ex) {
            log.error("发送到死信队列失败", ex);
        }
    }
} 