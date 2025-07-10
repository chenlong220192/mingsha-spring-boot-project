package site.mingsha.boot.starter.rocketmq.autoconfigure;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mingsha RocketMQ 自动配置类
 *
 * @author mingsha
 * @since 1.0.0
 */
@Configuration
@ConditionalOnClass(RocketMQTemplate.class)
@EnableConfigurationProperties(MingshaRocketMQProperties.class)
@ConditionalOnProperty(prefix = "rocketmq", name = "enabled", havingValue = "true", matchIfMissing = true)
public class MingshaRocketMQAutoConfiguration {

    /**
     * 配置 RocketMQ 消息处理器
     */
    @Bean
    @ConditionalOnMissingBean
    public MingshaRocketMQMessageHandler mingshaRocketMQMessageHandler(MingshaRocketMQProperties properties) {
        return new MingshaRocketMQMessageHandler(properties);
    }
} 