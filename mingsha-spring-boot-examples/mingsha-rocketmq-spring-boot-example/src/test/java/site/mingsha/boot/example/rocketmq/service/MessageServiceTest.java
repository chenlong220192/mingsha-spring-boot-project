package site.mingsha.boot.example.rocketmq.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MessageServiceTest {
    @Autowired
    private MessageService messageService;

    @Test
    void testSendSyncMessage() {
        assertDoesNotThrow(() -> {
            messageService.sendSyncMessage("test-topic", "测试同步消息");
        });
    }

    @Test
    void testSendAsyncMessage() {
        assertDoesNotThrow(() -> {
            messageService.sendAsyncMessage("test-topic", "测试异步消息");
        });
    }

    @Test
    void testSendDelayMessage() {
        assertDoesNotThrow(() -> {
            messageService.sendDelayMessage("test-topic", "测试延迟消息", 3);
        });
    }

    @Test
    void testSendOrderMessage() {
        assertDoesNotThrow(() -> {
            messageService.sendOrderMessage("test-topic", "测试顺序消息", "test-key");
        });
    }
} 