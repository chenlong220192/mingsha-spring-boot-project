package site.mingsha.boot.autoconfigure.solr;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Solr自动配置
 *
 * @author mingsha
 * @date 2025-07-10
 */
@Configuration
@ConditionalOnProperty(prefix = "mingsha.solr", name = "enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(SolrProperties.class)
public class SolrAutoConfiguration {

    // Solr配置已通过@EnableConfigurationProperties启用
    // 具体的Solr客户端配置由用户根据实际需求添加依赖后实现
} 