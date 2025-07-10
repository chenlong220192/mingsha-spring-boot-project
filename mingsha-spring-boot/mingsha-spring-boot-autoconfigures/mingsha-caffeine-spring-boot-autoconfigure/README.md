# Mingsha Caffeine Spring Boot Autoconfigure

## 简介

本模块为 Caffeine 本地缓存提供 Spring Boot 自动装配能力，配合 mingsha-caffeine-spring-boot-starter 使用。

- 自动装配 Caffeine 缓存管理器
- 支持 application.yml 方式配置
- 提供高性能本地缓存的自动配置

## 快速集成

1. 引入 starter 依赖（推荐通过 starter 集成）：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-caffeine-spring-boot-starter</artifactId>
    <version>${revision}</version>
</dependency>
```

2. 配置 application.yml：

```yaml
spring:
  cache:
    type: caffeine
    caffeine:
      spec: maximumSize=500,expireAfterWrite=600s
```

3. 使用 @Cacheable、@CacheEvict 等注解进行缓存操作。

## 官方属性兼容说明

本模块完全兼容Spring Boot官方Caffeine配置，所有参数请参考Spring Boot官方文档（https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties.data.spring.cache.caffeine)

- 支持所有 `spring.cache.caffeine.*` 配置项
- 无需自定义属性类，配置方式与Spring Boot官方一致
- 推荐结合Spring Boot官方自动装配生态使用

