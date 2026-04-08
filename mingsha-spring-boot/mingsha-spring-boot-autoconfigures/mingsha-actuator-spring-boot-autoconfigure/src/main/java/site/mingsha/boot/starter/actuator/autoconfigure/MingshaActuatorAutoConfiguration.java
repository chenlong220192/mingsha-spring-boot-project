package site.mingsha.boot.starter.actuator.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;

/**
 * Auto-configuration for Mingsha Actuator endpoints.
 *
 * Note: In Spring Boot 4.0, HealthEndpointProperties was removed.
 * Health indicators are now auto-configured via HealthContributorAutoConfiguration.
 */
@Configuration
@ConditionalOnClass(name = "org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties")
public class MingshaActuatorAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public WebEndpointProperties webEndpointProperties() {
        return new WebEndpointProperties();
    }
}
