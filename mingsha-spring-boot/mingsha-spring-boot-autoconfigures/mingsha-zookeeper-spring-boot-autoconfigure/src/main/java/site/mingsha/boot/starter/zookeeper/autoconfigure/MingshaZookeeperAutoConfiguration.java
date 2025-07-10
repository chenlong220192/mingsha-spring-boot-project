package site.mingsha.boot.starter.zookeeper.autoconfigure;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mingsha Zookeeper 自动配置
 */
@Configuration
@ConditionalOnClass(CuratorFramework.class)
@EnableConfigurationProperties(MingshaZookeeperProperties.class)
public class MingshaZookeeperAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public CuratorFramework curatorFramework(MingshaZookeeperProperties properties) {
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(
                properties.getRetryIntervalMs(),
                properties.getRetryCount(),
                properties.getMaxRetryIntervalMs());
        
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(properties.getConnectString())
                .sessionTimeoutMs(properties.getSessionTimeoutMs())
                .connectionTimeoutMs(properties.getConnectionTimeoutMs())
                .retryPolicy(retryPolicy)
                .namespace(properties.getNamespace())
                .build();
        
        client.start();
        return client;
    }
} 