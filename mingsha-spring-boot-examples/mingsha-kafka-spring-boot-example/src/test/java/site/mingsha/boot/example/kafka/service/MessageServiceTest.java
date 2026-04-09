package site.mingsha.boot.example.kafka.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * 消息服务测试 - 单元测试
 */
@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @InjectMocks
    private MessageService messageService;

    @BeforeEach
    void setUp() {
        // mock send 方法返回 null (Future)
        when(kafkaTemplate.send(anyString(), anyString())).thenReturn(null);
    }

    @Test
    void testSendMessage() {
        // When
        assertDoesNotThrow(() -> {
            messageService.sendMessage("test-topic", "测试消息");
        });

        // Then
        verify(kafkaTemplate, times(1)).send(eq("test-topic"), anyString());
    }

    @Test
    void testSendMessageToDefault() {
        // When
        assertDoesNotThrow(() -> {
            messageService.sendMessageToDefault("测试默认主题消息");
        });

        // Then
        verify(kafkaTemplate, times(1)).send(eq("default-topic"), anyString());
    }

    @Test
    void testSendBatchMessages() {
        // When
        assertDoesNotThrow(() -> {
            messageService.sendBatchMessages("batch-topic", 5);
        });

        // Then
        verify(kafkaTemplate, times(5)).send(eq("batch-topic"), anyString());
    }
}
