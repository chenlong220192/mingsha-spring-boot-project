# Mingsha RocketMQ Spring Boot Starter

## 简介

Mingsha RocketMQ Spring Boot Starter 提供了 RocketMQ 消息队列与 Spring Boot 的集成，支持消息生产、消费、事务等功能。

## 功能特性

- RocketMQ 与 Spring Boot 自动集成
- 支持消息生产与消费
- 支持事务、延迟消息等
- 健康检查与监控
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- RocketMQ
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-rocketmq-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加配置：

```yaml
spring:
  rocketmq:
    name-server: localhost:9876
    producer:
      group: mingsha-producer-group
    consumer:
      group: mingsha-consumer-group
```

## 用法示例

```java
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;

@Service
public class RocketService {
    private final RocketMQTemplate rocketMQTemplate;

    public RocketService(RocketMQTemplate rocketMQTemplate) {
        this.rocketMQTemplate = rocketMQTemplate;
    }

    public void sendMessage(String topic, String message) {
        rocketMQTemplate.convertAndSend(topic, message);
    }
}
```

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.rocketmq.name-server` | String | localhost:9876 | NameServer 地址 |
| `spring.rocketmq.producer.group` | String | - | 生产者分组 |
| `spring.rocketmq.consumer.group` | String | - | 消费者分组 |

## API接口

- 通过 RocketMQTemplate 发送消息
- 通过 @RocketMQMessageListener 注解消费消息

## 代码结构

```
mingsha-rocketmq-spring-boot-starter/
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