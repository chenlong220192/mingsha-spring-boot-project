package site.mingsha.boot.starter.rocketmq.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Mingsha RocketMQ 配置属性
 *
 * @author mingsha
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "rocketmq")
public class MingshaRocketMQProperties {

    /**
     * 是否启用 RocketMQ
     */
    private boolean enabled = true;

    /**
     * 生产者组名
     */
    private String producerGroup = "mingsha-producer-group";

    /**
     * 消费者组名
     */
    private String consumerGroup = "mingsha-consumer-group";

    /**
     * 消息发送超时时间
     */
    private int sendMessageTimeout = 3000;

    /**
     * 消息压缩阈值
     */
    private int compressMessageBodyThreshold = 4096;

    /**
     * 最大消息大小
     */
    private int maxMessageSize = 4194304;

    /**
     * 重试次数
     */
    private int retryTimesWhenSendFailed = 2;

    /**
     * 异步发送重试次数
     */
    private int retryTimesWhenSendAsyncFailed = 2;

    /**
     * 是否启用消息轨迹
     */
    private boolean enableMsgTrace = false;

    /**
     * 消息轨迹主题
     */
    private String customizedTraceTopic = "RMQ_SYS_TRACE_TOPIC";

    // Getters and Setters
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getProducerGroup() {
        return producerGroup;
    }

    public void setProducerGroup(String producerGroup) {
        this.producerGroup = producerGroup;
    }

    public String getConsumerGroup() {
        return consumerGroup;
    }

    public void setConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
    }

    public int getSendMessageTimeout() {
        return sendMessageTimeout;
    }

    public void setSendMessageTimeout(int sendMessageTimeout) {
        this.sendMessageTimeout = sendMessageTimeout;
    }

    public int getCompressMessageBodyThreshold() {
        return compressMessageBodyThreshold;
    }

    public void setCompressMessageBodyThreshold(int compressMessageBodyThreshold) {
        this.compressMessageBodyThreshold = compressMessageBodyThreshold;
    }

    public int getMaxMessageSize() {
        return maxMessageSize;
    }

    public void setMaxMessageSize(int maxMessageSize) {
        this.maxMessageSize = maxMessageSize;
    }

    public int getRetryTimesWhenSendFailed() {
        return retryTimesWhenSendFailed;
    }

    public void setRetryTimesWhenSendFailed(int retryTimesWhenSendFailed) {
        this.retryTimesWhenSendFailed = retryTimesWhenSendFailed;
    }

    public int getRetryTimesWhenSendAsyncFailed() {
        return retryTimesWhenSendAsyncFailed;
    }

    public void setRetryTimesWhenSendAsyncFailed(int retryTimesWhenSendAsyncFailed) {
        this.retryTimesWhenSendAsyncFailed = retryTimesWhenSendAsyncFailed;
    }

    public boolean isEnableMsgTrace() {
        return enableMsgTrace;
    }

    public void setEnableMsgTrace(boolean enableMsgTrace) {
        this.enableMsgTrace = enableMsgTrace;
    }

    public String getCustomizedTraceTopic() {
        return customizedTraceTopic;
    }

    public void setCustomizedTraceTopic(String customizedTraceTopic) {
        this.customizedTraceTopic = customizedTraceTopic;
    }
} 