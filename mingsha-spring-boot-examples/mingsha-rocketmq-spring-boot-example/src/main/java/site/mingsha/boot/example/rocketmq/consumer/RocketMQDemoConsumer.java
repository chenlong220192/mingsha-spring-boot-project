package site.mingsha.boot.example.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * RocketMQ 消费者示例，监听 test-topic
 *
 * @author mingsha
 * @since 1.0.0
 */
@Component
@RocketMQMessageListener(
        topic = "test-topic",
        consumerGroup = "mingsha-example-consumer-group",
        messageModel = MessageModel.CLUSTERING
)
public class RocketMQDemoConsumer implements RocketMQListener<String> {
    private static final Logger log = LoggerFactory.getLogger(RocketMQDemoConsumer.class);

    @Override
    public void onMessage(String message) {
        log.info("收到消息：{}", message);
    }
} 