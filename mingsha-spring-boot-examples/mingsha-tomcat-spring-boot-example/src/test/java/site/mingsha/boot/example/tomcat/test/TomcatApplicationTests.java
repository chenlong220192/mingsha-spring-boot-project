package site.mingsha.boot.example.tomcat.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

/**
 * Tomcat 应用测试类
 *
 * @author mingsha
 * @since 1.0.0
 */
@SpringBootTest
@TestPropertySource(properties = {
    "server.port=0",
    "server.tomcat.threads.max=50",
    "server.tomcat.threads.min-spare=5"
})
class TomcatApplicationTests {

    @Test
    void contextLoads() {
        // 测试应用上下文加载
    }
} 