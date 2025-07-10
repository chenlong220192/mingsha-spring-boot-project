# Mingsha Mail Spring Boot Autoconfigure

## 简介

本模块为邮件发送功能提供 Spring Boot 自动装配能力，配合 mingsha-mail-spring-boot-starter 使用。

- 自动装配 JavaMailSender、MailSender
- 支持 application.yml 方式配置
- 提供邮件发送的自动配置

## 快速集成

1. 引入 starter 依赖（推荐通过 starter 集成）：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-mail-spring-boot-starter</artifactId>
    <version>${revision}</version>
</dependency>
```

2. 配置 application.yml：

```yaml
spring:
  mail:
    host: smtp.gmail.com
    port: 587
    username: your-email@gmail.com
    password: your-password
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
```

3. 直接使用 JavaMailSender 发送邮件。

## 官方属性兼容说明

本模块完全兼容Spring Boot官方Mail配置，所有参数请参考Spring Boot官方文档（https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties.integration.spring.mail)

- 支持所有 `spring.mail.*` 配置项
- 无需自定义属性类，配置方式与Spring Boot官方一致
- 推荐结合Spring Boot官方自动装配生态使用

