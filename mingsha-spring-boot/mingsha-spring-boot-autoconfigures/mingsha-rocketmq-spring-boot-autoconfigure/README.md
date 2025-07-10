# Mingsha RocketMQ Spring Boot Autoconfigure

## 简介

本模块为 RocketMQ 消息队列提供 Spring Boot 自动装配能力，配合 mingsha-rocketmq-spring-boot-starter 使用。

- 自动装配 RocketMQ 生产者和消费者
- 支持 application.yml 方式配置
- 提供消息发送和接收的自动配置

## 快速集成

1. 引入 starter 依赖（推荐通过 starter 集成）：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-rocketmq-spring-boot-starter</artifactId>
    <version>${revision}</version>
</dependency>
```

2. 配置 application.yml：

```yaml
rocketmq:
  name-server: localhost:9876
  producer:
    group: my-producer-group
  consumer:
    group: my-consumer-group
```

3. 使用 RocketMQTemplate 发送消息，@RocketMQMessageListener 接收消息。

## 官方属性兼容说明

本模块完全兼容RocketMQ官方配置，所有参数请参考RocketMQ官方文档（https://rocketmq.apache.org/docs/quick-start/)

- 支持所有 `rocketmq.*` 配置项
- 无需自定义属性类，配置方式与RocketMQ官方一致
- 推荐结合Spring Boot官方自动装配生态使用

