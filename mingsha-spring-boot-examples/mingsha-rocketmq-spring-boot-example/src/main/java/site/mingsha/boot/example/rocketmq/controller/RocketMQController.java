package site.mingsha.boot.example.rocketmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.mingsha.boot.starter.rocketmq.autoconfigure.MingshaRocketMQMessageHandler;
import org.apache.rocketmq.client.producer.SendResult;

import java.util.HashMap;
import java.util.Map;

/**
 * RocketMQ 示例控制器
 *
 * @author mingsha
 * @since 1.0.0
 */
@RestController
@RequestMapping("/rocketmq")
public class RocketMQController {

    @Autowired
    private MingshaRocketMQMessageHandler messageHandler;

    /**
     * 发送同步消息
     */
    @PostMapping("/send/sync")
    public Map<String, Object> sendSyncMessage(@RequestParam String topic, 
                                              @RequestParam String message,
                                              @RequestParam(required = false) String tags) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            SendResult sendResult = messageHandler.sendSyncMessage(topic, message, tags);
            
            if (sendResult != null && sendResult.getSendStatus().name().equals("SEND_OK")) {
                result.put("success", true);
                result.put("message", "消息发送成功");
                result.put("messageId", sendResult.getMsgId());
                result.put("topic", topic);
                result.put("tags", tags);
            } else {
                result.put("success", false);
                result.put("message", "消息发送失败");
                result.put("status", sendResult != null ? sendResult.getSendStatus() : "UNKNOWN");
            }
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "消息发送异常: " + e.getMessage());
        }
        
        return result;
    }

    /**
     * 发送异步消息
     */
    @PostMapping("/send/async")
    public Map<String, Object> sendAsyncMessage(@RequestParam String topic, 
                                               @RequestParam String message,
                                               @RequestParam(required = false) String tags) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            messageHandler.sendAsyncMessage(topic, message, tags);
            result.put("success", true);
            result.put("message", "异步消息已提交发送");
            result.put("topic", topic);
            result.put("tags", tags);
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "异步消息发送异常: " + e.getMessage());
        }
        
        return result;
    }

    /**
     * 发送延迟消息
     */
    @PostMapping("/send/delay")
    public Map<String, Object> sendDelayMessage(@RequestParam String topic, 
                                               @RequestParam String message,
                                               @RequestParam int delayLevel,
                                               @RequestParam(required = false) String tags) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            SendResult sendResult = messageHandler.sendDelayMessage(topic, message, tags, delayLevel);
            
            if (sendResult != null && sendResult.getSendStatus().name().equals("SEND_OK")) {
                result.put("success", true);
                result.put("message", "延迟消息发送成功");
                result.put("messageId", sendResult.getMsgId());
                result.put("topic", topic);
                result.put("tags", tags);
                result.put("delayLevel", delayLevel);
            } else {
                result.put("success", false);
                result.put("message", "延迟消息发送失败");
                result.put("status", sendResult != null ? sendResult.getSendStatus() : "UNKNOWN");
            }
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "延迟消息发送异常: " + e.getMessage());
        }
        
        return result;
    }

    /**
     * 获取配置信息
     */
    @GetMapping("/config")
    public Map<String, Object> getConfig() {
        Map<String, Object> result = new HashMap<>();
        
        try {
            result.put("success", true);
            result.put("producerGroup", messageHandler.getProperties().getProducerGroup());
            result.put("consumerGroup", messageHandler.getProperties().getConsumerGroup());
            result.put("sendMessageTimeout", messageHandler.getProperties().getSendMessageTimeout());
            result.put("maxMessageSize", messageHandler.getProperties().getMaxMessageSize());
            result.put("enabled", messageHandler.getProperties().isEnabled());
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "获取配置异常: " + e.getMessage());
        }
        
        return result;
    }

    /**
     * 健康检查
     */
    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> result = new HashMap<>();
        result.put("status", "UP");
        result.put("service", "RocketMQ Example");
        result.put("timestamp", System.currentTimeMillis());
        return result;
    }
} 