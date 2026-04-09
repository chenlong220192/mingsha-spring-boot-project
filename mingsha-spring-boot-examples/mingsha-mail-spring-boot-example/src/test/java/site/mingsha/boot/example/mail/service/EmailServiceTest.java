package site.mingsha.boot.example.mail.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.internet.MimeMessage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * 邮件服务测试 - 单元测试
 */
@ExtendWith(MockitoExtension.class)
class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @Mock
    private MimeMessage mimeMessage;

    @InjectMocks
    private EmailService emailService;

    @BeforeEach
    void setUp() {
        // 初始化操作（如果需要）
    }

    @Test
    void testSendSimpleEmail() {
        // Given
        SimpleMailMessage sentMessage = new SimpleMailMessage();
        doNothing().when(mailSender).send(any(SimpleMailMessage.class));

        // When
        assertDoesNotThrow(() -> {
            emailService.sendSimpleEmail("test@example.com", "测试邮件", "这是一封测试邮件");
        });

        // Then
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    @Test
    void testSendHtmlEmail() throws Exception {
        // Given
        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);
        doNothing().when(mailSender).send(any(MimeMessage.class));

        // When
        assertDoesNotThrow(() -> {
            String htmlContent = "<h1>测试HTML邮件</h1><p>这是一封HTML格式的测试邮件</p>";
            emailService.sendHtmlEmail("test@example.com", "测试HTML邮件", htmlContent);
        });

        // Then
        verify(mailSender, times(1)).send(any(MimeMessage.class));
    }

    @Test
    void testSendEmailWithAttachment() throws Exception {
        // Given
        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);
        doNothing().when(mailSender).send(any(MimeMessage.class));

        // When
        assertDoesNotThrow(() -> {
            emailService.sendEmailWithAttachment("test@example.com", "测试附件邮件",
                "这是一封带附件的测试邮件", "pom.xml");
        });

        // Then
        verify(mailSender, times(1)).send(any(MimeMessage.class));
    }
}
