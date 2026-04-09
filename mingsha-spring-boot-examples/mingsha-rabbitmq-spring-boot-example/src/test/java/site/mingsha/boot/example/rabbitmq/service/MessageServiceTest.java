package site.mingsha.boot.example.rabbitmq.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * 消息服务测试 - 单元测试
 */
@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    @Mock
    private AmqpTemplate amqpTemplate;

    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private MessageService messageService;

    @BeforeEach
    void setUp() {
        // 初始化操作（如果需要）
    }

    @Test
    void testSendSimpleMessage() {
        // Given
        doNothing().when(amqpTemplate).convertAndSend(anyString(), anyString());

        // When
        assertDoesNotThrow(() -> {
            messageService.sendSimpleMessage("测试简单消息");
        });

        // Then
        verify(amqpTemplate, times(1)).convertAndSend(eq("simple.queue"), anyString());
    }

    @Test
    void testSendDelayMessage() {
        // Given
        doNothing().when(amqpTemplate).convertAndSend(anyString(), anyString(), any(), any());

        // When
        assertDoesNotThrow(() -> {
            messageService.sendDelayMessage("测试延迟消息", 1000);
        });

        // Then
        verify(amqpTemplate, times(1)).convertAndSend(
            eq("delay.exchange"),
            eq("delay.routing.key"),
            anyString(),
            any()
        );
    }

    @Test
    void testSendBroadcastMessage() {
        // Given
        doNothing().when(amqpTemplate).convertAndSend(anyString(), anyString(), anyString());

        // When
        assertDoesNotThrow(() -> {
            messageService.sendBroadcastMessage("测试广播消息");
        });

        // Then
        verify(amqpTemplate, times(1)).convertAndSend(
            eq("broadcast.exchange"),
            eq(""),
            anyString()
        );
    }
}
