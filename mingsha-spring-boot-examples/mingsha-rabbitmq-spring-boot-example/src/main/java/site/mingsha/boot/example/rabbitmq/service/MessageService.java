package site.mingsha.boot.example.rabbitmq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 消息服务 - 演示 RabbitMQ 消息发送
 */
@Service
public class MessageService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送简单消息
     */
    public void sendSimpleMessage(String message) {
        String fullMessage = "[" + LocalDateTime.now() + "] " + message;
        amqpTemplate.convertAndSend("simple.queue", fullMessage);
    }

    /**
     * 发送延迟消息
     */
    public void sendDelayMessage(String message, long delay) {
        String fullMessage = "[" + LocalDateTime.now() + "] " + message;
        amqpTemplate.convertAndSend("delay.exchange", "delay.routing.key", fullMessage, msg -> {
            msg.getMessageProperties().setHeader("x-delay", delay);
            return msg;
        });
    }

    /**
     * 发送广播消息
     */
    public void sendBroadcastMessage(String message) {
        String fullMessage = "[" + LocalDateTime.now() + "] " + message;
        amqpTemplate.convertAndSend("broadcast.exchange", "", fullMessage);
    }
} 