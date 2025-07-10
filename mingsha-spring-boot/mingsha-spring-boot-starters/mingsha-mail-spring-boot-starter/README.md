# Mingsha Mail Spring Boot Starter

## 简介

Mingsha Mail Spring Boot Starter 提供了邮件发送与 Spring Boot 的集成，支持多种邮件协议和模板渲染，简化邮件服务开发。

## 功能特性

- 集成 JavaMail 邮件发送
- 支持 SMTP、SSL、TLS 等协议
- 支持文本、HTML、附件邮件
- 支持 Thymeleaf/Freemarker 邮件模板
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- JavaMail
- Thymeleaf/Freemarker
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-mail-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加配置：

```yaml
spring:
  mail:
    host: smtp.example.com
    port: 465
    username: user@example.com
    password: yourpassword
    protocol: smtps
    properties:
      mail:
        smtp:
          auth: true
          ssl:
            enable: true
          starttls:
            enable: true
```

## 用法示例

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }
}
```

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.mail.host` | String | - | 邮件服务器主机 |
| `spring.mail.port` | Integer | 25 | 邮件服务器端口 |
| `spring.mail.username` | String | - | 邮箱用户名 |
| `spring.mail.password` | String | - | 邮箱密码 |
| `spring.mail.protocol` | String | smtp | 协议类型 |

## API接口

- 通过 JavaMailSender 发送邮件

## 代码结构

```
mingsha-mail-spring-boot-starter/
├── pom.xml
├── src/
│   ├── main/java/site/mingsha/boot/
│   └── main/resources/
└── README.md
```

## 测试

```bash
mvn test
```

## 贡献

欢迎提交 Issue 和 Pull Request！ 