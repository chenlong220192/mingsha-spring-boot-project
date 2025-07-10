# Mingsha Kafka Spring Boot Starter

## 简介

Mingsha Kafka Spring Boot Starter 提供了 Kafka 消息队列与 Spring Boot 的集成，支持消息生产、消费、事务等功能。

## 功能特性

- Kafka 与 Spring Boot 自动集成
- 支持消息生产与消费
- 支持分区、批量、事务
- 健康检查与监控
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- Apache Kafka
- Spring for Apache Kafka
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-kafka-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加配置：

```yaml
spring:
  kafka:
    bootstrap-servers: localhost:9092
    consumer:
      group-id: mingsha-group
      auto-offset-reset: earliest
    producer:
      retries: 3
      batch-size: 16384
      buffer-memory: 33554432
```

## 用法示例

```java
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}
```

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.kafka.bootstrap-servers` | String | - | Kafka 集群地址 |
| `spring.kafka.consumer.group-id` | String | - | 消费者分组 |
| `spring.kafka.producer.retries` | Integer | 0 | 生产者重试次数 |

## API接口

- 通过 KafkaTemplate 发送消息
- 通过 @KafkaListener 注解消费消息

## 代码结构

```
mingsha-kafka-spring-boot-starter/
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