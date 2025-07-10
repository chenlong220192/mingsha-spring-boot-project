package site.mingsha.boot.example.rabbitmq.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MessageServiceTest {
    @Autowired
    private MessageService messageService;

    @Test
    void testSendSimpleMessage() {
        assertDoesNotThrow(() -> {
            messageService.sendSimpleMessage("测试简单消息");
        });
    }

    @Test
    void testSendDelayMessage() {
        assertDoesNotThrow(() -> {
            messageService.sendDelayMessage("测试延迟消息", 1000);
        });
    }

    @Test
    void testSendBroadcastMessage() {
        assertDoesNotThrow(() -> {
            messageService.sendBroadcastMessage("测试广播消息");
        });
    }
} 