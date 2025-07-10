# Mingsha Zookeeper Spring Boot Autoconfigure

## 简介

本模块为 Zookeeper 分布式协调服务提供 Spring Boot 自动装配能力，配合 mingsha-zookeeper-spring-boot-starter 使用。

- 自动装配 ZooKeeper 客户端和配置
- 支持 application.yml 方式配置
- 提供分布式锁、配置中心等功能的自动配置

## 快速集成

1. 引入 starter 依赖（推荐通过 starter 集成）：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-zookeeper-spring-boot-starter</artifactId>
    <version>${revision}</version>
</dependency>
```

2. 配置 application.yml：

```yaml
spring:
  cloud:
    zookeeper:
      connect-string: localhost:2181
      base-sleep-time-ms: 50
      max-retries: 10
```

3. 直接使用 ZooKeeper 客户端进行分布式协调操作。

## 官方属性兼容说明

本模块完全兼容Spring Boot官方ZooKeeper配置，所有参数请参考Spring Boot官方文档（https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties.integration.spring.cloud.zookeeper)

- 支持所有 `spring.cloud.zookeeper.*` 配置项
- 无需自定义属性类，配置方式与Spring Boot官方一致
- 推荐结合Spring Boot官方自动装配生态使用

