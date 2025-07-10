package site.mingsha.boot.starter.logging.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Mingsha Logging 自动配置类
 *
 * @author mingsha
 * @since 1.0.0
 */
@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@EnableConfigurationProperties(MingshaLoggingProperties.class)
@ConditionalOnProperty(prefix = "logging", name = "interceptor-enabled", havingValue = "true", matchIfMissing = true)
public class MingshaLoggingAutoConfiguration implements WebMvcConfigurer {

    private final MingshaLoggingProperties properties;

    public MingshaLoggingAutoConfiguration(MingshaLoggingProperties properties) {
        this.properties = properties;
    }

    /**
     * 配置日志拦截器
     */
    @Bean
    @ConditionalOnMissingBean
    public MingshaLoggingInterceptor mingshaLoggingInterceptor() {
        MingshaLoggingInterceptor interceptor = new MingshaLoggingInterceptor();
        interceptor.setIncludeHeaders(properties.getInterceptor().isIncludeHeaders());
        interceptor.setIncludeBody(properties.getInterceptor().isIncludeBody());
        interceptor.setMaxBodyLength(properties.getInterceptor().getMaxBodyLength());
        return interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mingshaLoggingInterceptor());
    }
} 