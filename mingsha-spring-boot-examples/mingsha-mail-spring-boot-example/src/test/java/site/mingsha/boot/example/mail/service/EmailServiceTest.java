package site.mingsha.boot.example.mail.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmailServiceTest {
    @Autowired
    private EmailService emailService;

    @Test
    void testSendSimpleEmail() {
        assertDoesNotThrow(() -> {
            emailService.sendSimpleEmail("test@example.com", "测试邮件", "这是一封测试邮件");
        });
    }

    @Test
    void testSendHtmlEmail() {
        assertDoesNotThrow(() -> {
            String htmlContent = "<h1>测试HTML邮件</h1><p>这是一封HTML格式的测试邮件</p>";
            emailService.sendHtmlEmail("test@example.com", "测试HTML邮件", htmlContent);
        });
    }

    @Test
    void testSendEmailWithAttachment() {
        assertDoesNotThrow(() -> {
            // 注意：这里需要提供一个实际存在的文件路径
            emailService.sendEmailWithAttachment("test@example.com", "测试附件邮件", 
                "这是一封带附件的测试邮件", "pom.xml");
        });
    }
} 