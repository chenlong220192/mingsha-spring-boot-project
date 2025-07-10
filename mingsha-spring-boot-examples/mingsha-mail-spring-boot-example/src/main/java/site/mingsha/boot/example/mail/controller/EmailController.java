package site.mingsha.boot.example.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.mingsha.boot.example.mail.service.EmailService;

/**
 * 邮件控制器 - 演示邮件发送功能
 */
@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    /**
     * 发送简单文本邮件
     */
    @PostMapping("/send/simple")
    public ResponseEntity<String> sendSimpleEmail(@RequestParam String to,
                                                 @RequestParam String subject,
                                                 @RequestParam String content) {
        emailService.sendSimpleEmail(to, subject, content);
        return ResponseEntity.ok("简单邮件发送成功");
    }

    /**
     * 发送HTML邮件
     */
    @PostMapping("/send/html")
    public ResponseEntity<String> sendHtmlEmail(@RequestParam String to,
                                               @RequestParam String subject,
                                               @RequestParam String htmlContent) {
        emailService.sendHtmlEmail(to, subject, htmlContent);
        return ResponseEntity.ok("HTML邮件发送成功");
    }

    /**
     * 发送带附件的邮件
     */
    @PostMapping("/send/attachment")
    public ResponseEntity<String> sendEmailWithAttachment(@RequestParam String to,
                                                         @RequestParam String subject,
                                                         @RequestParam String content,
                                                         @RequestParam String attachmentPath) {
        emailService.sendEmailWithAttachment(to, subject, content, attachmentPath);
        return ResponseEntity.ok("带附件邮件发送成功");
    }
} 