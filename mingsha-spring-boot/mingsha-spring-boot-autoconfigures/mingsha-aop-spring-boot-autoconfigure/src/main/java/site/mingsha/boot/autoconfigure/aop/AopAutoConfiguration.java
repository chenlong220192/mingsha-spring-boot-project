package site.mingsha.boot.autoconfigure.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP自动配置
 *
 * @author mingsha
 * @date 2025-07-10
 */
@Configuration
@ConditionalOnClass(Aspect.class)
@ConditionalOnProperty(prefix = "mingsha.aop", name = "enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(AopProperties.class)
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = false)
public class AopAutoConfiguration {

    // AOP配置已通过@EnableAspectJAutoProxy注解启用
    // 具体的切面实现由用户自定义
} 