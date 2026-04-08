package site.mingsha.boot.starter.tomcat.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Auto-configuration for Tomcat.
 *
 * Note: In Spring Boot 4.0, embedded Tomcat packages were completely restructured.
 * This configuration requires manual adaptation for Spring Boot 4.0 compatibility.
 */
@Configuration
@ConditionalOnClass(name = "org.apache.catalina.startup.Tomcat")
@ConditionalOnProperty(prefix = "server.tomcat", name = "enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(MingshaTomcatProperties.class)
public class MingshaTomcatAutoConfiguration {
    // Tomcat auto-configuration requires adaptation for Spring Boot 4.0
}
