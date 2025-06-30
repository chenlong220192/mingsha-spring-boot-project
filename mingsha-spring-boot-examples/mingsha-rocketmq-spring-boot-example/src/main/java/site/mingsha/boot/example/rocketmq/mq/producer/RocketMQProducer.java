package site.mingsha.boot.example.rocketmq.mq.producer;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import site.mingsha.kernel.logger.LogUtils;
import site.mingsha.kernel.logger.pattern.LogPattern;

/**
 * @author chenlong
 * @date 2020-06-09
 */
@Component
public class RocketMQProducer {

    /**
     * rocketmq模板注入
     */
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送同步消息（阻塞当前线程，等待broker响应发送结果，这样不太容易丢失消息）
     * sendResult为返回的发送结果
     */
    public <T> SendResult sendMsg(String topic, String tag, T msg) {
        return rocketMQTemplate.syncSend(topic + ":" + tag, MessageBuilder.withPayload(msg).build());
    }

    /**
     * 发送异步消息
     * 发送异步消息（通过线程池执行发送到broker的消息任务，执行完后回调：在SendCallback中可处理相关成功失败时的逻辑）
     * （适合对响应时间敏感的业务场景）
     *
     * @param topic 消息Topic
     * @param msg   消息实体
     */
    public <T> void asyncSend(String topic, String tag, T msg) {
        final long start = System.currentTimeMillis();
        asyncSend(topic + ":" + tag, MessageBuilder.withPayload(msg).build(), new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                // LogUtils.info(String.format(LogPattern.TIME_MESSAGE, System.currentTimeMillis() - start, FastJsonUtils.getJsonStr(sendResult)));
            }

            @Override
            public void onException(Throwable throwable) {
                LogUtils.error(String.format(LogPattern.ERROR_NO_REQ, System.currentTimeMillis() - start, throwable.getMessage()));
            }
        });
    }


    /**
     * 发送异步消息
     * 发送异步消息（通过线程池执行发送到broker的消息任务，执行完后回调：在SendCallback中可处理相关成功失败时的逻辑）
     * （适合对响应时间敏感的业务场景）
     *
     * @param topic        消息Topic
     * @param message      消息实体
     * @param sendCallback 回调函数
     */
    public void asyncSend(String topic, Message<?> message, SendCallback sendCallback) {
        rocketMQTemplate.asyncSend(topic, message, sendCallback);
    }

}
