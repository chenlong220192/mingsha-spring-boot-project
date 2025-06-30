package site.mingsha.boot.example.rocketmq;

import site.mingsha.boot.example.rocketmq.process.RocketMQProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * @author chenlong
 * @date 2020-06-11
 */
@SpringBootApplication
public class RocketMQApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(RocketMQApplication.class, args);
        applicationContext.getBean(RocketMQProcessor.class).execute();
    }

}
