# Mingsha RocketMQ Spring Boot Example

## 简介

本示例演示如何使用 Mingsha RocketMQ Spring Boot Starter 集成 RocketMQ，实现消息的生产与消费。

## 功能特性

- 集成 RocketMQ 消息队列
- 支持消息生产与消费
- 支持主题、标签、顺序消息
- 健康检查与监控

## 技术栈

- Spring Boot 3.x
- RocketMQ
- Spring Cloud Stream
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 克隆项目

```bash
git clone <your-repo-url>
cd mingsha-spring-boot-project/mingsha-spring-boot-examples/mingsha-rocketmq-spring-boot-example
```

### 2. 添加依赖

已在 `pom.xml` 中集成：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-rocketmq-spring-boot-starter</artifactId>
</dependency>
```

### 3. 启动应用

```bash
mvn spring-boot:run
```

## 用法示例

- 发送和消费 RocketMQ 消息
- 查看消息日志

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.rocketmq.name-server` | String | localhost:9876 | NameServer 地址 |
| `spring.rocketmq.producer.group` | String | - | 生产者组 |
| `spring.rocketmq.consumer.group` | String | - | 消费者组 |

## API接口

- 标准 RocketMQListener、RocketMQTemplate 接口

## 代码结构

```
mingsha-rocketmq-spring-boot-example/
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