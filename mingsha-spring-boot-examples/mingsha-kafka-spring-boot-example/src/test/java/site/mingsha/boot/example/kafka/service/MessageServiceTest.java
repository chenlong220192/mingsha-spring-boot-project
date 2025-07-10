package site.mingsha.boot.example.kafka.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MessageServiceTest {
    @Autowired
    private MessageService messageService;

    @Test
    void testSendMessage() {
        assertDoesNotThrow(() -> {
            messageService.sendMessage("test-topic", "测试消息");
        });
    }

    @Test
    void testSendMessageToDefault() {
        assertDoesNotThrow(() -> {
            messageService.sendMessageToDefault("测试默认主题消息");
        });
    }

    @Test
    void testSendBatchMessages() {
        assertDoesNotThrow(() -> {
            messageService.sendBatchMessages("batch-topic", 5);
        });
    }
} 