package site.mingsha.boot.example.kafka.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import site.mingsha.boot.example.kafka.dto.UserEventRequest;
import site.mingsha.boot.example.kafka.entity.UserEvent;
import site.mingsha.boot.example.kafka.service.KafkaUserEventService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Kafka 用户事件服务实现类
 *
 * @author mingsha
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaUserEventServiceImpl implements KafkaUserEventService {
    
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    
    private static final String USER_EVENTS_TOPIC = "user-events";
    
    @Override
    public void sendUserEvent(UserEventRequest request) {
        try {
            // 转换为实体对象
            UserEvent userEvent = convertToUserEvent(request);
            
            // 序列化为JSON
            String message = objectMapper.writeValueAsString(userEvent);
            
            // 发送到Kafka
            kafkaTemplate.send(USER_EVENTS_TOPIC, userEvent.getUserId(), message);
            
            log.info("用户事件发送成功: eventId={}, userId={}, eventType={}", 
                    userEvent.getEventId(), userEvent.getUserId(), userEvent.getEventType());
        } catch (Exception e) {
            log.error("用户事件发送失败: userId={}, eventType={}", 
                    request.getUserId(), request.getEventType(), e);
            throw new RuntimeException("用户事件发送失败", e);
        }
    }
    
    @Override
    public void sendBatchUserEvents(List<UserEventRequest> requests) {
        try {
            for (UserEventRequest request : requests) {
                sendUserEvent(request);
            }
            log.info("批量用户事件发送成功: count={}", requests.size());
        } catch (Exception e) {
            log.error("批量用户事件发送失败: count={}", requests.size(), e);
            throw new RuntimeException("批量用户事件发送失败", e);
        }
    }
    
    /**
     * 转换请求为实体对象
     */
    private UserEvent convertToUserEvent(UserEventRequest request) {
        UserEvent userEvent = new UserEvent();
        userEvent.setEventId(UUID.randomUUID().toString());
        userEvent.setUserId(request.getUserId());
        userEvent.setEventType(request.getEventType());
        userEvent.setTimestamp(request.getTimestamp());
        userEvent.setData(request.getData());
        userEvent.setSourceIp(request.getSourceIp());
        userEvent.setUserAgent(request.getUserAgent());
        userEvent.setSessionId(request.getSessionId());
        userEvent.setCreateTime(LocalDateTime.now());
        userEvent.setUpdateTime(LocalDateTime.now());
        return userEvent;
    }
} 