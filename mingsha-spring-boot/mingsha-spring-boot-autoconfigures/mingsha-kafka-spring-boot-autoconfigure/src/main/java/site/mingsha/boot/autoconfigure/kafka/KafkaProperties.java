package site.mingsha.boot.autoconfigure.kafka;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Kafka 配置属性
 *
 * @author mingsha
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaProperties {
    
    /**
     * Kafka 服务器地址
     */
    private String bootstrapServers = "localhost:9092";
    
    /**
     * 消费者组ID
     */
    private String groupId = "default-group";
    
    /**
     * 自动提交偏移量
     */
    private boolean enableAutoCommit = true;
    
    /**
     * 自动提交间隔
     */
    private int autoCommitIntervalMs = 1000;
    
    /**
     * 会话超时时间
     */
    private int sessionTimeoutMs = 30000;
    
    /**
     * 键反序列化器
     */
    private String keyDeserializer = "org.apache.kafka.common.serialization.StringDeserializer";
    
    /**
     * 值反序列化器
     */
    private String valueDeserializer = "org.apache.kafka.common.serialization.StringDeserializer";
    
    /**
     * 键序列化器
     */
    private String keySerializer = "org.apache.kafka.common.serialization.StringSerializer";
    
    /**
     * 值序列化器
     */
    private String valueSerializer = "org.apache.kafka.common.serialization.StringSerializer";
    
    /**
     * 生产者确认机制
     */
    private String acks = "1";
    
    /**
     * 重试次数
     */
    private int retries = 3;
    
    /**
     * 批量大小
     */
    private int batchSize = 16384;
    
    /**
     * 延迟时间
     */
    private int lingerMs = 1;
    
    /**
     * 缓冲区大小
     */
    private int bufferMemory = 33554432;
    
    public String getBootstrapServers() {
        return bootstrapServers;
    }
    
    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }
    
    public String getGroupId() {
        return groupId;
    }
    
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    
    public boolean isEnableAutoCommit() {
        return enableAutoCommit;
    }
    
    public void setEnableAutoCommit(boolean enableAutoCommit) {
        this.enableAutoCommit = enableAutoCommit;
    }
    
    public int getAutoCommitIntervalMs() {
        return autoCommitIntervalMs;
    }
    
    public void setAutoCommitIntervalMs(int autoCommitIntervalMs) {
        this.autoCommitIntervalMs = autoCommitIntervalMs;
    }
    
    public int getSessionTimeoutMs() {
        return sessionTimeoutMs;
    }
    
    public void setSessionTimeoutMs(int sessionTimeoutMs) {
        this.sessionTimeoutMs = sessionTimeoutMs;
    }
    
    public String getKeyDeserializer() {
        return keyDeserializer;
    }
    
    public void setKeyDeserializer(String keyDeserializer) {
        this.keyDeserializer = keyDeserializer;
    }
    
    public String getValueDeserializer() {
        return valueDeserializer;
    }
    
    public void setValueDeserializer(String valueDeserializer) {
        this.valueDeserializer = valueDeserializer;
    }
    
    public String getKeySerializer() {
        return keySerializer;
    }
    
    public void setKeySerializer(String keySerializer) {
        this.keySerializer = keySerializer;
    }
    
    public String getValueSerializer() {
        return valueSerializer;
    }
    
    public void setValueSerializer(String valueSerializer) {
        this.valueSerializer = valueSerializer;
    }
    
    public String getAcks() {
        return acks;
    }
    
    public void setAcks(String acks) {
        this.acks = acks;
    }
    
    public int getRetries() {
        return retries;
    }
    
    public void setRetries(int retries) {
        this.retries = retries;
    }
    
    public int getBatchSize() {
        return batchSize;
    }
    
    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }
    
    public int getLingerMs() {
        return lingerMs;
    }
    
    public void setLingerMs(int lingerMs) {
        this.lingerMs = lingerMs;
    }
    
    public int getBufferMemory() {
        return bufferMemory;
    }
    
    public void setBufferMemory(int bufferMemory) {
        this.bufferMemory = bufferMemory;
    }
} 