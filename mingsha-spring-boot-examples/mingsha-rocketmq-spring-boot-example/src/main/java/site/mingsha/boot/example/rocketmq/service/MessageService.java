package site.mingsha.boot.example.rocketmq.service;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 消息服务 - 演示 RocketMQ 消息发送
 */
@Service
public class MessageService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送同步消息
     */
    public void sendSyncMessage(String topic, String message) {
        String fullMessage = "[" + LocalDateTime.now() + "] " + message;
        SendResult result = rocketMQTemplate.syncSend(topic, fullMessage);
        System.out.println("同步消息发送结果: " + result);
    }

    /**
     * 发送异步消息
     */
    public void sendAsyncMessage(String topic, String message) {
        String fullMessage = "[" + LocalDateTime.now() + "] " + message;
        rocketMQTemplate.asyncSend(topic, fullMessage, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("异步消息发送成功: " + sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                System.err.println("异步消息发送失败: " + throwable.getMessage());
            }
        });
    }

    /**
     * 发送延迟消息
     */
    public void sendDelayMessage(String topic, String message, int delayLevel) {
        String fullMessage = "[" + LocalDateTime.now() + "] " + message;
        rocketMQTemplate.syncSend(topic, MessageBuilder.withPayload(fullMessage)
                .setHeader("DELAY_LEVEL", delayLevel)
                .build());
    }

    /**
     * 发送顺序消息
     */
    public void sendOrderMessage(String topic, String message, String hashKey) {
        String fullMessage = "[" + LocalDateTime.now() + "] " + message;
        rocketMQTemplate.syncSendOrderly(topic, fullMessage, hashKey);
    }
} 