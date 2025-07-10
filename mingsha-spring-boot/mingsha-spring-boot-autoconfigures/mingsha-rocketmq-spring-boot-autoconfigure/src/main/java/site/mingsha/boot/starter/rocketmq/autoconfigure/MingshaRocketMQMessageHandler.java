package site.mingsha.boot.starter.rocketmq.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Mingsha RocketMQ 消息处理器
 *
 * @author mingsha
 * @since 1.0.0
 */
public class MingshaRocketMQMessageHandler {

    private static final Logger logger = LoggerFactory.getLogger(MingshaRocketMQMessageHandler.class);

    private final MingshaRocketMQProperties properties;

    @Autowired(required = false)
    private RocketMQTemplate rocketMQTemplate;

    public MingshaRocketMQMessageHandler(MingshaRocketMQProperties properties) {
        this.properties = properties;
    }

    /**
     * 发送同步消息
     */
    public SendResult sendSyncMessage(String topic, String message) {
        return sendSyncMessage(topic, message, null);
    }

    /**
     * 发送同步消息（带标签）
     */
    public SendResult sendSyncMessage(String topic, String message, String tags) {
        try {
            if (rocketMQTemplate == null) {
                logger.warn("RocketMQTemplate 未初始化");
                return null;
            }

            String destination = tags != null ? topic + ":" + tags : topic;
            SendResult result = rocketMQTemplate.syncSend(destination, message);
            
            if (result.getSendStatus() == SendStatus.SEND_OK) {
                logger.debug("消息发送成功: topic={}, messageId={}", topic, result.getMsgId());
            } else {
                logger.warn("消息发送失败: topic={}, status={}", topic, result.getSendStatus());
            }
            
            return result;
        } catch (Exception e) {
            logger.error("发送同步消息异常: topic={}, message={}", topic, message, e);
            throw new RuntimeException("发送消息失败", e);
        }
    }

    /**
     * 发送异步消息
     */
    public void sendAsyncMessage(String topic, String message) {
        sendAsyncMessage(topic, message, null);
    }

    /**
     * 发送异步消息（带标签）
     */
    public void sendAsyncMessage(String topic, String message, String tags) {
        try {
            if (rocketMQTemplate == null) {
                logger.warn("RocketMQTemplate 未初始化");
                return;
            }

            String destination = tags != null ? topic + ":" + tags : topic;
            rocketMQTemplate.asyncSend(destination, message, new org.apache.rocketmq.client.producer.SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    if (sendResult.getSendStatus() == SendStatus.SEND_OK) {
                        logger.debug("异步消息发送成功: topic={}, messageId={}", topic, sendResult.getMsgId());
                    } else {
                        logger.warn("异步消息发送失败: topic={}, status={}", topic, sendResult.getSendStatus());
                    }
                }

                @Override
                public void onException(Throwable throwable) {
                    logger.error("异步消息发送失败: topic={}, message={}", topic, message, throwable);
                }
            });
        } catch (Exception e) {
            logger.error("发送异步消息异常: topic={}, message={}", topic, message, e);
            throw new RuntimeException("发送异步消息失败", e);
        }
    }

    /**
     * 发送延迟消息
     */
    public SendResult sendDelayMessage(String topic, String message, int delayLevel) {
        return sendDelayMessage(topic, message, null, delayLevel);
    }

    /**
     * 发送延迟消息（带标签）
     */
    public SendResult sendDelayMessage(String topic, String message, String tags, int delayLevel) {
        try {
            if (rocketMQTemplate == null) {
                logger.warn("RocketMQTemplate 未初始化");
                return null;
            }

            String destination = tags != null ? topic + ":" + tags : topic;
            SendResult result = rocketMQTemplate.syncSend(destination, 
                MessageBuilder.withPayload(message)
                    .setHeader("DELAY_TIME_LEVEL", delayLevel)
                    .build());
            
            if (result.getSendStatus() == SendStatus.SEND_OK) {
                logger.debug("延迟消息发送成功: topic={}, messageId={}, delayLevel={}", 
                    topic, result.getMsgId(), delayLevel);
            } else {
                logger.warn("延迟消息发送失败: topic={}, status={}", topic, result.getSendStatus());
            }
            
            return result;
        } catch (Exception e) {
            logger.error("发送延迟消息异常: topic={}, message={}, delayLevel={}", 
                topic, message, delayLevel, e);
            throw new RuntimeException("发送延迟消息失败", e);
        }
    }

    /**
     * 获取配置属性
     */
    public MingshaRocketMQProperties getProperties() {
        return properties;
    }
} 