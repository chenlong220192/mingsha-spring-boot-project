package site.mingsha.boot.autoconfigure.mongodb;

import com.mongodb.client.MongoClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * MongoDB自动配置
 *
 * @author mingsha
 * @date 2025-07-10
 */
@Configuration
@ConditionalOnClass({MongoClient.class, MongoTemplate.class})
@ConditionalOnProperty(prefix = "mingsha.mongodb", name = "enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(MongoProperties.class)
public class MongoAutoConfiguration {

    /**
     * 配置MongoDB模板
     */
    @Bean
    @ConditionalOnMissingBean
    public MongoTemplate mongoTemplate(MongoClient mongoClient, MongoProperties properties) {
        return new MongoTemplate(mongoClient, properties.getDatabase());
    }
} 