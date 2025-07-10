# Mingsha Kafka Spring Boot Autoconfigure

## 简介

本模块为 Kafka 消息队列提供 Spring Boot 自动装配能力，配合 mingsha-kafka-spring-boot-starter 使用。

- 自动装配 KafkaTemplate、KafkaListenerContainerFactory
- 支持 application.yml 方式配置
- 提供生产者和消费者的自动配置

## 快速集成

1. 引入 starter 依赖（推荐通过 starter 集成）：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-kafka-spring-boot-starter</artifactId>
    <version>${revision}</version>
</dependency>
```

2. 配置 application.yml：

```yaml
spring:
  kafka:
    bootstrap-servers: localhost:9092
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.apache.kafka.common.serialization.StringSerializer
    consumer:
      group-id: my-group
      auto-offset-reset: earliest
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
```

3. 直接使用 KafkaTemplate 发送消息，@KafkaListener 接收消息。

## 官方属性兼容说明

本模块完全兼容Spring Boot官方Kafka配置，所有参数请参考Spring Boot官方文档（https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties.integration.spring.kafka)

- 支持所有 `spring.kafka.*` 及其子项（producer、consumer、admin等）
- 无需自定义属性类，配置方式与Spring Boot官方一致
- 推荐结合Spring Boot官方自动装配生态使用

