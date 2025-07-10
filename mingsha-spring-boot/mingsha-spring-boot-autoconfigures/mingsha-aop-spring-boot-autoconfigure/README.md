# Mingsha AOP Spring Boot Autoconfigure

## 简介

本模块为 AOP 切面编程提供 Spring Boot 自动装配能力，配合 mingsha-aop-spring-boot-starter 使用。

- 自动装配 AOP 代理和切面
- 支持 application.yml 方式配置
- 提供日志、性能监控等切面功能

## 快速集成

1. 引入 starter 依赖（推荐通过 starter 集成）：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-aop-spring-boot-starter</artifactId>
    <version>${revision}</version>
</dependency>
```

2. 配置 application.yml：

```yaml
spring:
  aop:
    auto: true
    proxy-target-class: true
```

3. 使用 @Aspect 注解创建切面，@Pointcut 定义切点。

## 官方属性兼容说明

本模块完全兼容Spring Boot官方AOP配置，所有参数请参考Spring Boot官方文档（https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties.core.spring.aop)

- 支持所有 `spring.aop.*` 配置项
- 无需自定义属性类，配置方式与Spring Boot官方一致
- 推荐结合Spring Boot官方自动装配生态使用

