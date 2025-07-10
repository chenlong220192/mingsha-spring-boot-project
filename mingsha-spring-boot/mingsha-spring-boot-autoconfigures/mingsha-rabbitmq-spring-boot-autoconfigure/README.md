# Mingsha RabbitMQ Spring Boot Autoconfigure

## 简介

本模块为 RabbitMQ 消息队列提供 Spring Boot 自动装配能力，配合 mingsha-rabbitmq-spring-boot-starter 使用。

- 自动装配 RabbitTemplate、AmqpAdmin
- 支持 application.yml 方式配置
- 提供消息发送和接收的自动配置

## 快速集成

1. 引入 starter 依赖（推荐通过 starter 集成）：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-rabbitmq-spring-boot-starter</artifactId>
    <version>${revision}</version>
</dependency>
```

2. 配置 application.yml：

```yaml
spring:
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: guest
    virtual-host: /
```

3. 使用 RabbitTemplate 发送消息，@RabbitListener 接收消息。

## 官方属性兼容说明

本模块完全兼容Spring Boot官方RabbitMQ配置，所有参数请参考Spring Boot官方文档（https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties.integration.spring.rabbitmq)

- 支持所有 `spring.rabbitmq.*` 配置项
- 无需自定义属性类，配置方式与Spring Boot官方一致
- 推荐结合Spring Boot官方自动装配生态使用

