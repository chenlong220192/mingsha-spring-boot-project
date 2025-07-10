package site.mingsha.boot.starter.caffeine.autoconfigure;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Mingsha Caffeine 自动配置
 */
@Configuration
@ConditionalOnClass(Caffeine.class)
@EnableConfigurationProperties(MingshaCaffeineProperties.class)
public class MingshaCaffeineAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public CacheManager cacheManager(MingshaCaffeineProperties properties) {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .maximumSize(properties.getMaxSize())
                .expireAfterWrite(properties.getExpireAfterWrite(), TimeUnit.SECONDS)
                .expireAfterAccess(properties.getExpireAfterAccess(), TimeUnit.SECONDS)
                .refreshAfterWrite(properties.getRefreshAfterWrite(), TimeUnit.SECONDS)
                .recordStats()
        );
        return cacheManager;
    }
} 