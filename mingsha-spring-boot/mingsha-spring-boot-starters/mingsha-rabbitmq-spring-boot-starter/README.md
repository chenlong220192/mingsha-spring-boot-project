# Mingsha RabbitMQ Spring Boot Starter

## 简介

Mingsha RabbitMQ Spring Boot Starter 提供了 RabbitMQ 消息队列与 Spring Boot 的集成，支持消息生产、消费、事务等功能。

## 功能特性

- RabbitMQ 与 Spring Boot 自动集成
- 支持消息生产与消费
- 支持事务、延迟队列等
- 健康检查与监控
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- RabbitMQ
- Spring AMQP
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-rabbitmq-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加配置：

```yaml
spring:
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: guest
```

## 用法示例

```java
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitService {
    private final RabbitTemplate rabbitTemplate;

    public RabbitService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String queue, String message) {
        rabbitTemplate.convertAndSend(queue, message);
    }
}
```

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.rabbitmq.host` | String | localhost | RabbitMQ 主机 |
| `spring.rabbitmq.port` | Integer | 5672 | RabbitMQ 端口 |
| `spring.rabbitmq.username` | String | guest | 用户名 |
| `spring.rabbitmq.password` | String | guest | 密码 |

## API接口

- 通过 RabbitTemplate 发送消息
- 通过 @RabbitListener 注解消费消息

## 代码结构

```
mingsha-rabbitmq-spring-boot-starter/
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