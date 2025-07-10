# Mingsha WebSocket Spring Boot Starter

## 简介

Mingsha WebSocket Spring Boot Starter 提供了 WebSocket 实时通信与 Spring Boot 的集成，支持消息推送、广播、点对点通信等功能。

## 功能特性

- 集成 Spring WebSocket
- 支持消息推送、广播、点对点通信
- 支持自定义消息处理器
- 健康检查与监控
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- Spring WebSocket
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-websocket-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加配置：

```yaml
server:
  port: 8080
spring:
  websocket:
    enabled: true
```

## 用法示例

```java
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class MyWebSocketHandler extends TextWebSocketHandler {
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 处理收到的消息
        session.sendMessage(new TextMessage("Echo: " + message.getPayload()));
    }
}
```

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.websocket.enabled` | Boolean | true | 是否启用 WebSocket |
| `server.port` | Integer | 8080 | 服务端口 |

## API接口

- WebSocket 标准接口 ws://host:port/xxx

## 代码结构

```
mingsha-websocket-spring-boot-starter/
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