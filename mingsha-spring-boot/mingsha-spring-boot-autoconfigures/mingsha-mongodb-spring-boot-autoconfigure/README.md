# Mingsha MongoDB Spring Boot Autoconfigure

## 简介

本模块为 MongoDB 文档数据库提供 Spring Boot 自动装配能力，配合 mingsha-mongodb-spring-boot-starter 使用。

- 自动装配 MongoClient、MongoTemplate
- 支持 application.yml 方式配置
- 提供 MongoDB 文档操作的自动配置

## 快速集成

1. 引入 starter 依赖（推荐通过 starter 集成）：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-mongodb-spring-boot-starter</artifactId>
    <version>${revision}</version>
</dependency>
```

2. 配置 application.yml：

```yaml
spring:
  data:
    mongodb:
      host: localhost
      port: 27017
      database: test
      username: admin
      password: password
```

3. 直接使用 MongoTemplate 或 Spring Data MongoDB Repository 进行文档操作。

## 官方属性兼容说明

本模块完全兼容Spring Boot官方MongoDB配置，所有参数请参考Spring Boot官方文档（https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties.data.spring.data.mongodb)

- 支持所有 `spring.data.mongodb.*` 配置项
- 无需自定义属性类，配置方式与Spring Boot官方一致
- 推荐结合Spring Boot官方自动装配生态使用

