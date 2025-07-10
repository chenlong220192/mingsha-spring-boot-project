package site.mingsha.boot.example.kafka.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Kafka 监控指标
 *
 * @author mingsha
 * @since 1.0.0
 */
@Slf4j
@Component
public class KafkaMetrics {
    
    private final MeterRegistry meterRegistry;
    private final ConcurrentHashMap<String, Counter> messageCounters = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Timer> messageTimers = new ConcurrentHashMap<>();
    
    public KafkaMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }
    
    /**
     * 记录消息发送成功
     */
    public void recordMessageSent(String topic) {
        Counter counter = messageCounters.computeIfAbsent("kafka_messages_sent",
                k -> Counter.builder("kafka_messages_sent")
                        .description("Number of Kafka messages sent")
                        .tag("topic", topic)
                        .register(meterRegistry));
        counter.increment();
    }
    
    /**
     * 记录消息发送失败
     */
    public void recordMessageSendFailed(String topic) {
        Counter counter = messageCounters.computeIfAbsent("kafka_messages_send_failed",
                k -> Counter.builder("kafka_messages_send_failed")
                        .description("Number of Kafka messages send failed")
                        .tag("topic", topic)
                        .register(meterRegistry));
        counter.increment();
    }
    
    /**
     * 记录消息接收成功
     */
    public void recordMessageReceived(String topic) {
        Counter counter = messageCounters.computeIfAbsent("kafka_messages_received",
                k -> Counter.builder("kafka_messages_received")
                        .description("Number of Kafka messages received")
                        .tag("topic", topic)
                        .register(meterRegistry));
        counter.increment();
    }
    
    /**
     * 记录消息处理成功
     */
    public void recordMessageProcessed(String topic) {
        Counter counter = messageCounters.computeIfAbsent("kafka_messages_processed",
                k -> Counter.builder("kafka_messages_processed")
                        .description("Number of Kafka messages processed")
                        .tag("topic", topic)
                        .register(meterRegistry));
        counter.increment();
    }
    
    /**
     * 记录消息处理失败
     */
    public void recordMessageProcessFailed(String topic) {
        Counter counter = messageCounters.computeIfAbsent("kafka_messages_process_failed",
                k -> Counter.builder("kafka_messages_process_failed")
                        .description("Number of Kafka messages process failed")
                        .tag("topic", topic)
                        .register(meterRegistry));
        counter.increment();
    }
    
    /**
     * 记录用户事件处理
     */
    public void recordUserEventProcessed(String eventType) {
        Counter counter = messageCounters.computeIfAbsent("kafka_user_events_processed",
                k -> Counter.builder("kafka_user_events_processed")
                        .description("Number of user events processed")
                        .tag("event_type", eventType)
                        .register(meterRegistry));
        counter.increment();
    }
    
    /**
     * 记录消息处理时间
     */
    public void recordMessageProcessingTime(String topic, long timeMs) {
        Timer timer = messageTimers.computeIfAbsent("kafka_message_processing_time",
                k -> Timer.builder("kafka_message_processing_time")
                        .description("Time taken to process Kafka messages")
                        .tag("topic", topic)
                        .register(meterRegistry));
        timer.record(timeMs, TimeUnit.MILLISECONDS);
    }
    
    /**
     * 记录消息发送时间
     */
    public void recordMessageSendTime(String topic, long timeMs) {
        Timer timer = messageTimers.computeIfAbsent("kafka_message_send_time",
                k -> Timer.builder("kafka_message_send_time")
                        .description("Time taken to send Kafka messages")
                        .tag("topic", topic)
                        .register(meterRegistry));
        timer.record(timeMs, TimeUnit.MILLISECONDS);
    }
    
    /**
     * 记录批量消息处理
     */
    public void recordBatchMessageProcessed(String topic, int batchSize) {
        Counter counter = messageCounters.computeIfAbsent("kafka_batch_messages_processed",
                k -> Counter.builder("kafka_batch_messages_processed")
                        .description("Number of batch messages processed")
                        .tag("topic", topic)
                        .register(meterRegistry));
        counter.increment(batchSize);
    }
    
    /**
     * 记录死信队列消息
     */
    public void recordDeadLetterMessage(String topic) {
        Counter counter = messageCounters.computeIfAbsent("kafka_dead_letter_messages",
                k -> Counter.builder("kafka_dead_letter_messages")
                        .description("Number of messages sent to dead letter queue")
                        .tag("topic", topic)
                        .register(meterRegistry));
        counter.increment();
    }
    
    /**
     * 记录消费者组状态
     */
    public void recordConsumerGroupStatus(String groupId, String status) {
        Counter counter = messageCounters.computeIfAbsent("kafka_consumer_group_status",
                k -> Counter.builder("kafka_consumer_group_status")
                        .description("Consumer group status changes")
                        .tag("group_id", groupId)
                        .tag("status", status)
                        .register(meterRegistry));
        counter.increment();
    }
    
    /**
     * 记录主题分区数量
     */
    public void recordTopicPartitions(String topic, int partitionCount) {
        Counter counter = messageCounters.computeIfAbsent("kafka_topic_partitions",
                k -> Counter.builder("kafka_topic_partitions")
                        .description("Number of partitions per topic")
                        .tag("topic", topic)
                        .register(meterRegistry));
        // 这里使用gauge更合适，但为了简化使用counter
        counter.increment(partitionCount);
    }
} 