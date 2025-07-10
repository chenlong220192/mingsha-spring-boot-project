package site.mingsha.boot.example.kafka.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetResetStrategy;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.TopicPartitionInfo;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import site.mingsha.boot.example.kafka.service.KafkaMessageService;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Kafka 消息服务实现类
 *
 * @author mingsha
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaMessageServiceImpl implements KafkaMessageService {
    
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final AdminClient adminClient;
    
    @Override
    public void sendMessage(String topic, String message) {
        try {
            kafkaTemplate.send(topic, message);
            log.info("消息发送成功: topic={}, message={}", topic, message);
        } catch (Exception e) {
            log.error("消息发送失败: topic={}, message={}", topic, message, e);
            throw new RuntimeException("消息发送失败", e);
        }
    }
    
    @Override
    public void sendMessageWithKey(String topic, String key, String message) {
        try {
            kafkaTemplate.send(topic, key, message);
            log.info("消息发送成功: topic={}, key={}, message={}", topic, key, message);
        } catch (Exception e) {
            log.error("消息发送失败: topic={}, key={}, message={}", topic, key, message, e);
            throw new RuntimeException("消息发送失败", e);
        }
    }
    
    @Override
    public void sendMessageAsync(String topic, String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("异步消息发送成功: topic={}, partition={}, offset={}, message={}", 
                        topic, result.getRecordMetadata().partition(), 
                        result.getRecordMetadata().offset(), message);
            } else {
                log.error("异步消息发送失败: topic={}, message={}", topic, message, ex);
            }
        });
    }
    
    @Override
    public void sendBatchMessages(String topic, List<String> messages) {
        try {
            for (String message : messages) {
                kafkaTemplate.send(topic, message);
            }
            log.info("批量消息发送成功: topic={}, count={}", topic, messages.size());
        } catch (Exception e) {
            log.error("批量消息发送失败: topic={}, count={}", topic, messages.size(), e);
            throw new RuntimeException("批量消息发送失败", e);
        }
    }
    
    @Override
    public List<Map<String, Object>> getTopics() {
        try {
            ListTopicsResult topicsResult = adminClient.listTopics();
            Set<String> topicNames = topicsResult.names().get(10, TimeUnit.SECONDS);
            
            List<Map<String, Object>> topics = new ArrayList<>();
            for (String topicName : topicNames) {
                Map<String, Object> topicInfo = new HashMap<>();
                topicInfo.put("name", topicName);
                
                // 获取主题详细信息
                DescribeTopicsResult describeResult = adminClient.describeTopics(Collections.singleton(topicName));
                Map<String, TopicDescription> descriptions = describeResult.all().get(10, TimeUnit.SECONDS);
                TopicDescription description = descriptions.get(topicName);
                
                if (description != null) {
                    topicInfo.put("partitions", description.partitions().size());
                    topicInfo.put("replicationFactor", description.partitions().get(0).replicas().size());
                    topicInfo.put("internal", description.isInternal());
                }
                
                topics.add(topicInfo);
            }
            
            return topics;
        } catch (Exception e) {
            log.error("获取主题信息失败", e);
            throw new RuntimeException("获取主题信息失败", e);
        }
    }
    
    @Override
    public List<Map<String, Object>> getConsumerGroups() {
        try {
            ListConsumerGroupsResult groupsResult = adminClient.listConsumerGroups();
            Collection<ConsumerGroupListing> groupListings = groupsResult.valid().get(10, TimeUnit.SECONDS);
            
            List<Map<String, Object>> groups = new ArrayList<>();
            for (ConsumerGroupListing groupListing : groupListings) {
                Map<String, Object> groupInfo = new HashMap<>();
                groupInfo.put("groupId", groupListing.groupId());
                groupInfo.put("isSimple", groupListing.isSimpleConsumerGroup());
                
                // 获取消费者组详细信息
                DescribeConsumerGroupsResult describeResult = adminClient.describeConsumerGroups(
                        Collections.singleton(groupListing.groupId()));
                Map<String, ConsumerGroupDescription> descriptions = describeResult.all().get(10, TimeUnit.SECONDS);
                ConsumerGroupDescription description = descriptions.get(groupListing.groupId());
                
                if (description != null) {
                    groupInfo.put("state", description.state().toString());
                    groupInfo.put("members", description.members().size());
                }
                
                groups.add(groupInfo);
            }
            
            return groups;
        } catch (Exception e) {
            log.error("获取消费者组信息失败", e);
            throw new RuntimeException("获取消费者组信息失败", e);
        }
    }
    
    @Override
    public void resetOffset(String groupId, String topic, String offset) {
        try {
            // 创建消费者来重置偏移量
            Properties props = new Properties();
            props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
            props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
            props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
            props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
            props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
            
            try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
                // 获取主题分区信息
                List<TopicPartition> partitions = new ArrayList<>();
                ListTopicsResult topicsResult = adminClient.listTopics();
                Set<String> topicNames = topicsResult.names().get(10, TimeUnit.SECONDS);
                
                if (topicNames.contains(topic)) {
                    DescribeTopicsResult describeResult = adminClient.describeTopics(Collections.singleton(topic));
                    Map<String, TopicDescription> descriptions = describeResult.all().get(10, TimeUnit.SECONDS);
                    TopicDescription description = descriptions.get(topic);
                    
                    if (description != null) {
                        for (TopicPartitionInfo partitionInfo : description.partitions()) {
                            partitions.add(new TopicPartition(topic, partitionInfo.partition()));
                        }
                    }
                }
                
                if (!partitions.isEmpty()) {
                    consumer.assign(partitions);
                    
                    // 根据策略重置偏移量
                    switch (offset.toLowerCase()) {
                        case "earliest":
                            consumer.seekToBeginning(partitions);
                            break;
                        case "latest":
                            consumer.seekToEnd(partitions);
                            break;
                        default:
                            throw new IllegalArgumentException("不支持的偏移量策略: " + offset);
                    }
                    
                    log.info("偏移量重置成功: groupId={}, topic={}, offset={}", groupId, topic, offset);
                }
            }
        } catch (Exception e) {
            log.error("重置偏移量失败: groupId={}, topic={}, offset={}", groupId, topic, offset, e);
            throw new RuntimeException("重置偏移量失败", e);
        }
    }
    
    @Override
    public boolean isHealthy() {
        try {
            // 尝试发送一个测试消息到内部主题
            String testTopic = "__test_health_check";
            kafkaTemplate.send(testTopic, "health_check").get(5, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            log.warn("Kafka 健康检查失败", e);
            return false;
        }
    }
} 