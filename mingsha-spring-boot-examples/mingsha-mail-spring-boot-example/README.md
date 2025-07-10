# Mingsha Mail Spring Boot Example

## 简介

本示例演示如何使用 Mingsha Mail Spring Boot Starter 集成邮件发送功能，支持多种邮件协议和模板渲染。

## 功能特性

- 集成 JavaMail 邮件发送
- 支持 SMTP、SSL、TLS 等协议
- 支持文本、HTML、附件邮件
- 支持 Thymeleaf/Freemarker 邮件模板

## 技术栈

- Spring Boot 3.x
- JavaMail
- Thymeleaf/Freemarker
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 克隆项目

```bash
git clone <your-repo-url>
cd mingsha-spring-boot-project/mingsha-spring-boot-examples/mingsha-mail-spring-boot-example
```

### 2. 添加依赖

已在 `pom.xml` 中集成：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-mail-spring-boot-starter</artifactId>
</dependency>
```

### 3. 启动应用

```bash
mvn spring-boot:run
```

## 用法示例

- 发送文本、HTML、带附件邮件
- 查看邮件发送日志

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.mail.host` | String | - | 邮件服务器主机 |
| `spring.mail.port` | Integer | 25 | 邮件服务器端口 |
| `spring.mail.username` | String | - | 邮箱用户名 |
| `spring.mail.password` | String | - | 邮箱密码 |

## API接口

- 通过 JavaMailSender 发送邮件

## 代码结构

```
mingsha-mail-spring-boot-example/
├── pom.xml
├── src/
│   ├── main/java/
│   └── main/resources/
└── README.md
```

## 测试

```bash
mvn test
```

## 贡献

欢迎提交 Issue 和 Pull Request！ 