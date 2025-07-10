package site.mingsha.boot.example.actuator.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

/**
 * Actuator 应用测试类
 *
 * @author mingsha
 * @since 1.0.0
 */
@SpringBootTest
@TestPropertySource(properties = {
    "management.endpoints.web.exposure.include=health,info",
    "management.endpoint.health.show-details=always"
})
class ActuatorApplicationTests {

    @Test
    void contextLoads() {
        // 测试应用上下文加载
    }
} 