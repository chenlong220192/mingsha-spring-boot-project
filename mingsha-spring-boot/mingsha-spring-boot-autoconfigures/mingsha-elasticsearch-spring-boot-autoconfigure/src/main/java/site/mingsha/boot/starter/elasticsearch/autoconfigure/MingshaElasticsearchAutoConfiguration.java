package site.mingsha.boot.starter.elasticsearch.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

/**
 * Mingsha Elasticsearch 自动配置
 */
@Configuration
@ConditionalOnClass(ElasticsearchOperations.class)
@EnableConfigurationProperties(MingshaElasticsearchProperties.class)
public class MingshaElasticsearchAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ElasticsearchOperations elasticsearchOperations(MingshaElasticsearchProperties properties) {
        // 使用Spring Boot自动配置的ElasticsearchOperations
        // 这里主要是为了提供配置属性的支持
        return null; // 实际由Spring Boot自动配置提供
    }
} 