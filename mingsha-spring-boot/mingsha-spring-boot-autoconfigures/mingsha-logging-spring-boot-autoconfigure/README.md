# Mingsha Logging Spring Boot Autoconfigure

## 简介

本模块为日志增强功能提供 Spring Boot 自动装配能力，配合 mingsha-logging-spring-boot-starter 使用。

- 自动装配日志配置和增强功能
- 支持 application.yml 方式配置
- 提供日志格式化和输出增强的自动配置

## 快速集成

1. 引入 starter 依赖（推荐通过 starter 集成）：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-logging-spring-boot-starter</artifactId>
    <version>${revision}</version>
</dependency>
```

2. 配置 application.yml：

```yaml
logging:
  level:
    root: INFO
    com.example: DEBUG
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
    file: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
```

3. 直接使用 SLF4J 或 Logback 进行日志记录。

## 官方属性兼容说明

本模块完全兼容Spring Boot官方Logging配置，所有参数请参考Spring Boot官方文档（https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties.logging)

- 支持所有 `logging.*` 配置项
- 无需自定义属性类，配置方式与Spring Boot官方一致
- 推荐结合Spring Boot官方自动装配生态使用

