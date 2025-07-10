package site.mingsha.boot.starter.actuator.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties;

@Configuration
@ConditionalOnClass(name = "org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties")
public class MingshaActuatorAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public WebEndpointProperties webEndpointProperties() {
        return new WebEndpointProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    public HealthEndpointProperties healthEndpointProperties() {
        return new HealthEndpointProperties();
    }
} 