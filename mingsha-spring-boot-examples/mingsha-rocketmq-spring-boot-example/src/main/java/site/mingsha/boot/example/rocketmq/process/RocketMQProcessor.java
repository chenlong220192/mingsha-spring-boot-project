package site.mingsha.boot.example.rocketmq.process;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import site.mingsha.boot.example.rocketmq.mq.producer.RocketMQProducer;
import site.mingsha.kernel.core.utils.ExceptionUtils;
import site.mingsha.kernel.logger.LogUtils;
import site.mingsha.kernel.logger.pattern.LogPattern;
import org.springframework.stereotype.Component;

/**
 * @author chenlong
 * @date 2020-06-09
 */
@Component
public class RocketMQProcessor {

    private static final String TOPIC = "topic_test";
    private static final String TAG_DEMO_0 = "demo_0";
    private static final String TAG_DEMO_1 = "demo_1";

    /**
     *
     */
    @Autowired
    private RocketMQProducer producer;

    /**
     *
     */
    public void execute() {
        final long start = System.currentTimeMillis();
        LogUtils.setModule("MQ-Producer");
        try {
            producer.asyncSend(TOPIC, TAG_DEMO_0, String.format("我是测试消息【%s】- %d", TAG_DEMO_0, System.currentTimeMillis()));

            producer.asyncSend(TOPIC, TAG_DEMO_1, String.format("我是测试消息【%s】- %d", TAG_DEMO_1, System.currentTimeMillis()));
        } catch (Exception e) {
            LogUtils.error(String.format(LogPattern.ERROR_NO_REQ, TAG_DEMO_0, System.currentTimeMillis() - start, ExceptionUtils.extract(e)));
        } finally {
            LogUtils.clear();
        }
    }

}
