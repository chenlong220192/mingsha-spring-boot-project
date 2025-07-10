package site.mingsha.boot.example.kafka.service;

import site.mingsha.boot.example.kafka.dto.UserEventRequest;

/**
 * Kafka 用户事件服务接口
 *
 * @author mingsha
 * @since 1.0.0
 */
public interface KafkaUserEventService {
    
    /**
     * 发送用户事件
     *
     * @param request 用户事件请求
     */
    void sendUserEvent(UserEventRequest request);
    
    /**
     * 批量发送用户事件
     *
     * @param requests 用户事件请求列表
     */
    void sendBatchUserEvents(java.util.List<UserEventRequest> requests);
} 