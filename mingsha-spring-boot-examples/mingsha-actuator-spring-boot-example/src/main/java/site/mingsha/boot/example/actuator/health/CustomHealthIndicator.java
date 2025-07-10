package site.mingsha.boot.example.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * 自定义健康检查
 */
@Component
public class CustomHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        // 这里可以做自定义健康检查逻辑
        boolean healthy = true;
        if (healthy) {
            return Health.up().withDetail("custom", "服务运行正常").build();
        } else {
            return Health.down().withDetail("custom", "服务异常").build();
        }
    }
} 