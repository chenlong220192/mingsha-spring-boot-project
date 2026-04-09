package site.mingsha.boot.example.logging.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LogControllerTest {

    @Test
    void testRecordLog() {
        LogController controller = new LogController();

        ResponseEntity<String> response = controller.recordLog("info", "测试日志");

        assertEquals(200, response.getStatusCode().value());
        assertTrue(response.getBody().contains("日志记录成功"));
        assertTrue(response.getBody().contains("info"));
    }

    @Test
    void testRecordException() {
        LogController controller = new LogController();

        ResponseEntity<String> response = controller.recordException("测试异常");

        assertEquals(200, response.getStatusCode().value());
        assertEquals("异常日志记录成功", response.getBody());
    }

    @Test
    void testRecordStructuredLog() {
        LogController controller = new LogController();

        ResponseEntity<String> response = controller.recordStructuredLog("123", "登录");

        assertEquals(200, response.getStatusCode().value());
        assertEquals("结构化日志记录成功", response.getBody());
    }

    @Test
    void testRecordLogWithDifferentLevels() {
        LogController controller = new LogController();

        // 测试 debug 级别
        ResponseEntity<String> debugResponse = controller.recordLog("debug", "debug消息");
        assertEquals(200, debugResponse.getStatusCode().value());

        // 测试 warn 级别
        ResponseEntity<String> warnResponse = controller.recordLog("warn", "warn消息");
        assertEquals(200, warnResponse.getStatusCode().value());

        // 测试 error 级别
        ResponseEntity<String> errorResponse = controller.recordLog("error", "error消息");
        assertEquals(200, errorResponse.getStatusCode().value());
    }
}
