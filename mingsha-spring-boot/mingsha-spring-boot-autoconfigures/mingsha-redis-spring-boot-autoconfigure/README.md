# Mingsha Redis Spring Boot Autoconfigure

## 简介

本模块为 Redis 缓存数据库提供 Spring Boot 自动装配能力，配合 mingsha-redis-spring-boot-starter 使用。

- 自动装配 RedisTemplate、StringRedisTemplate
- 支持 application.yml 方式配置
- 提供 Redis 缓存和会话存储的自动配置

## 快速集成

1. 引入 starter 依赖（推荐通过 starter 集成）：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-redis-spring-boot-starter</artifactId>
    <version>${revision}</version>
</dependency>
```

2. 配置 application.yml：

```yaml
spring:
  data:
    redis:
      host: localhost
      port: 6379
      password: 
      database: 0
      timeout: 2000ms
```

3. 直接使用 RedisTemplate 或 StringRedisTemplate 进行 Redis 操作。

## 官方属性兼容说明

本模块完全兼容Spring Boot官方Redis配置，所有参数请参考Spring Boot官方文档（https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties.data.spring.data.redis)

- 支持所有 `spring.data.redis.*` 配置项
- 无需自定义属性类，配置方式与Spring Boot官方一致
- 推荐结合Spring Boot官方自动装配生态使用

