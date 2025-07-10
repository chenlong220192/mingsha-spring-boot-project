package site.mingsha.boot.starter.shardingsphere.autoconfigure;

import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
import org.apache.shardingsphere.infra.config.mode.ModeConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Mingsha ShardingSphere 自动配置
 */
@Configuration
@ConditionalOnClass(ShardingSphereDataSourceFactory.class)
@ConditionalOnProperty(prefix = "spring.shardingsphere", name = "enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(MingshaShardingSphereProperties.class)
public class MingshaShardingSphereAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public DataSource shardingSphereDataSource(MingshaShardingSphereProperties properties) throws SQLException {
        // 这里主要是为了提供配置属性的支持
        // 实际的ShardingSphere配置需要根据具体的业务需求来实现
        return null; // 实际由用户配置提供
    }
} 