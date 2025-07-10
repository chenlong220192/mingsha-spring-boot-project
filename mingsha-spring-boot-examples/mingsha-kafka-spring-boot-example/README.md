# Mingsha Kafka Spring Boot Example

## 简介

本示例演示如何使用 Mingsha Kafka Spring Boot Starter 集成 Kafka，实现消息的生产与消费。

## 功能特性

- 集成 Kafka 消息队列
- 支持消息生产与消费
- 支持分区、组、批量消费
- 健康检查与监控

## 技术栈

- Spring Boot 3.x
- Apache Kafka
- Spring for Apache Kafka
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 克隆项目

```bash
git clone <your-repo-url>
cd mingsha-spring-boot-project/mingsha-spring-boot-examples/mingsha-kafka-spring-boot-example
```

### 2. 添加依赖

已在 `pom.xml` 中集成：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-kafka-spring-boot-starter</artifactId>
</dependency>
```

### 3. 启动应用

```bash
mvn spring-boot:run
```

## 用法示例

- 发送和消费 Kafka 消息
- 查看消息日志

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.kafka.bootstrap-servers` | String | localhost:9092 | Kafka 服务地址 |
| `spring.kafka.consumer.group-id` | String | test-group | 消费者组 |
| `spring.kafka.producer.key-serializer` | String | - | 生产者 Key 序列化 |
| `spring.kafka.producer.value-serializer` | String | - | 生产者 Value 序列化 |

## API接口

- 标准 KafkaListener、KafkaTemplate 接口

## 代码结构

```
mingsha-kafka-spring-boot-example/
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