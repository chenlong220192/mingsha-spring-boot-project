# Mingsha Actuator Spring Boot Autoconfigure

## 简介

本模块为 Spring Boot Actuator 监控管理提供自动装配能力，配合 mingsha-actuator-spring-boot-starter 使用。

- 自动装配 Actuator 端点和健康检查
- 支持 application.yml 方式配置
- 提供应用监控和健康检查的自动配置

## 快速集成

1. 引入 starter 依赖（推荐通过 starter 集成）：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-actuator-spring-boot-starter</artifactId>
    <version>${revision}</version>
</dependency>
```

2. 配置 application.yml：

```yaml
management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics
  endpoint:
    health:
      show-details: always
```

3. 访问 /actuator 端点查看应用监控信息。

## 官方属性兼容说明

本模块完全兼容Spring Boot官方Actuator配置，所有参数请参考Spring Boot官方文档（https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties.actuator)

- 支持所有 `management.*` 配置项
- 无需自定义属性类，配置方式与Spring Boot官方一致
- 推荐结合Spring Boot官方自动装配生态使用

