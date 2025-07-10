package site.mingsha.boot.example.logging.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class LogControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testRecordLog() throws Exception {
        mockMvc.perform(post("/api/logs/record")
                .param("level", "info")
                .param("message", "测试日志"))
                .andExpect(status().isOk())
                .andExpect(content().string("日志记录成功: info - 测试日志"));
    }

    @Test
    void testRecordException() throws Exception {
        mockMvc.perform(post("/api/logs/exception")
                .param("message", "测试异常"))
                .andExpect(status().isOk())
                .andExpect(content().string("异常日志记录成功"));
    }

    @Test
    void testRecordStructuredLog() throws Exception {
        mockMvc.perform(post("/api/logs/structured")
                .param("userId", "123")
                .param("action", "登录"))
                .andExpect(status().isOk())
                .andExpect(content().string("结构化日志记录成功"));
    }
} 