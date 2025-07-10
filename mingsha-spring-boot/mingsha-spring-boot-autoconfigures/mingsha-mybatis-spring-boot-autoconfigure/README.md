# Mingsha MyBatis Spring Boot Autoconfigure

## 简介

本模块为 MyBatis 持久层框架提供 Spring Boot 自动装配能力，配合 mingsha-mybatis-spring-boot-starter 使用。

- 自动装配 SqlSessionFactory、MapperScannerConfigurer
- 支持 application.yml 方式配置
- 提供 MyBatis 映射器和配置的自动配置

## 快速集成

1. 引入 starter 依赖（推荐通过 starter 集成）：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-mybatis-spring-boot-starter</artifactId>
    <version>${revision}</version>
</dependency>
```

2. 配置 application.yml：

```yaml
mybatis:
  mapper-locations: classpath:mapper/*.xml
  type-aliases-package: com.example.entity
  configuration:
    map-underscore-to-camel-case: true
```

3. 直接使用 @Mapper 注解或 @MapperScan 扫描 Mapper 接口。

## 官方属性兼容说明

本模块完全兼容Spring Boot官方MyBatis配置，所有参数请参考Spring Boot官方文档（https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties.data.mybatis)

- 支持所有 `mybatis.*` 配置项
- 无需自定义属性类，配置方式与Spring Boot官方一致
- 推荐结合Spring Boot官方自动装配生态使用

