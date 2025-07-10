# Mingsha WebSocket Spring Boot Autoconfigure

## 简介

本模块为 WebSocket 实时通信提供 Spring Boot 自动装配能力，配合 mingsha-websocket-spring-boot-starter 使用。

- 自动装配 WebSocket 配置和处理器
- 支持 application.yml 方式配置
- 提供 WebSocket 端点和消息处理的自动配置

## 快速集成

1. 引入 starter 依赖（推荐通过 starter 集成）：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-websocket-spring-boot-starter</artifactId>
    <version>${revision}</version>
</dependency>
```

2. 配置 application.yml：

```yaml
spring:
  websocket:
    max-text-message-size: 8192
    max-binary-message-size: 8192
```

3. 使用 @ServerEndpoint 创建 WebSocket 端点，@OnMessage 处理消息。

## 官方属性兼容说明

本模块完全兼容Spring Boot官方WebSocket配置，所有参数请参考Spring Boot官方文档（https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties.web.spring.websocket)

- 支持所有 `spring.websocket.*` 配置项
- 无需自定义属性类，配置方式与Spring Boot官方一致
- 推荐结合Spring Boot官方自动装配生态使用

