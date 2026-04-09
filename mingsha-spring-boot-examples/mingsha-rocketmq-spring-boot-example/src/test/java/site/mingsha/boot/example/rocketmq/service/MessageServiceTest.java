package site.mingsha.boot.example.rocketmq.service;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * 消息服务测试 - 单元测试
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class MessageServiceTest {

    @Mock
    private RocketMQTemplate rocketMQTemplate;

    @InjectMocks
    private MessageService messageService;

    @Test
    void testSendSyncMessage() {
        // Given
        SendResult sendResult = new SendResult();
        when(rocketMQTemplate.syncSend(anyString(), anyString())).thenReturn(sendResult);

        // When & Then
        assertDoesNotThrow(() -> {
            messageService.sendSyncMessage("test-topic", "测试消息");
        });
    }

    @Test
    void testSendAsyncMessage() {
        // Given
        doNothing().when(rocketMQTemplate).asyncSend(anyString(), anyString(), any(SendCallback.class));

        // When & Then
        assertDoesNotThrow(() -> {
            messageService.sendAsyncMessage("test-topic", "测试异步消息");
        });
    }

    @Test
    void testSendDelayMessage() {
        // Given
        SendResult sendResult = new SendResult();
        when(rocketMQTemplate.syncSend(anyString(), any(org.springframework.messaging.Message.class))).thenReturn(sendResult);

        // When & Then
        assertDoesNotThrow(() -> {
            messageService.sendDelayMessage("test-topic", "测试延迟消息", 3);
        });
    }
}
