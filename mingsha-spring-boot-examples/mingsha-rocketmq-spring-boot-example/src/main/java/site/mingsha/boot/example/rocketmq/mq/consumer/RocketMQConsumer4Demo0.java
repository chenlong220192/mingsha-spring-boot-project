package site.mingsha.boot.example.rocketmq.mq.consumer;

import site.mingsha.kernel.logger.LogUtils;
import site.mingsha.kernel.logger.pattern.LogPattern;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author chenlong
 * @date 2020-06-09
 */
@Component
@RocketMQMessageListener(topic = "topic_test", selectorExpression = "demo_0", consumerGroup = "consumer_group_0")
public class RocketMQConsumer4Demo0 implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        // 处理消息的逻辑
        LogUtils.info(String.format(LogPattern.WARN_NO_TIME_NO_REQ, message));
    }

}
