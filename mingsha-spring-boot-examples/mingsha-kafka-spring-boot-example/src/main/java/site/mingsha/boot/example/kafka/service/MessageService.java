package site.mingsha.boot.example.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 消息服务 - 演示 Kafka 消息发送
 */
@Service
public class MessageService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String DEFAULT_TOPIC = "default-topic";

    /**
     * 发送消息到指定主题
     */
    public void sendMessage(String topic, String message) {
        String fullMessage = "[" + LocalDateTime.now() + "] " + message;
        kafkaTemplate.send(topic, fullMessage);
    }

    /**
     * 发送消息到默认主题
     */
    public void sendMessageToDefault(String message) {
        sendMessage(DEFAULT_TOPIC, message);
    }

    /**
     * 批量发送消息
     */
    public void sendBatchMessages(String topic, int count) {
        for (int i = 0; i < count; i++) {
            String message = "批量消息 #" + (i + 1);
            sendMessage(topic, message);
        }
    }
} 