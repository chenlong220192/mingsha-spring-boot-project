package site.mingsha.boot.example.kafka.service;

import java.util.List;
import java.util.Map;

/**
 * Kafka 消息服务接口
 *
 * @author mingsha
 * @since 1.0.0
 */
public interface KafkaMessageService {
    
    /**
     * 发送消息
     *
     * @param topic   主题
     * @param message 消息内容
     */
    void sendMessage(String topic, String message);
    
    /**
     * 发送带键的消息
     *
     * @param topic   主题
     * @param key     消息键
     * @param message 消息内容
     */
    void sendMessageWithKey(String topic, String key, String message);
    
    /**
     * 异步发送消息
     *
     * @param topic   主题
     * @param message 消息内容
     */
    void sendMessageAsync(String topic, String message);
    
    /**
     * 批量发送消息
     *
     * @param topic    主题
     * @param messages 消息列表
     */
    void sendBatchMessages(String topic, List<String> messages);
    
    /**
     * 获取主题信息
     *
     * @return 主题信息列表
     */
    List<Map<String, Object>> getTopics();
    
    /**
     * 获取消费者组信息
     *
     * @return 消费者组信息列表
     */
    List<Map<String, Object>> getConsumerGroups();
    
    /**
     * 重置消费者偏移量
     *
     * @param groupId 消费者组ID
     * @param topic   主题
     * @param offset  偏移量策略
     */
    void resetOffset(String groupId, String topic, String offset);
    
    /**
     * 健康检查
     *
     * @return 是否健康
     */
    boolean isHealthy();
} 