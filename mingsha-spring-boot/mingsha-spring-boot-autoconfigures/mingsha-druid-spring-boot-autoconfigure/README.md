# Mingsha Druid Spring Boot Autoconfigure

## 简介

本模块为 Druid 数据库连接池提供 Spring Boot 自动装配能力，配合 mingsha-druid-spring-boot-starter 使用。

- 自动装配 DruidDataSource
- 支持 application.yml 方式配置
- 可与 MySQL、PostgreSQL 等数据库配合使用

## 快速集成

1. 引入 starter 依赖（推荐通过 starter 集成）：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-druid-spring-boot-starter</artifactId>
    <version>${revision}</version>
</dependency>
```

2. 配置 application.yml：

```yaml
spring:
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    url: jdbc:mysql://localhost:3306/test
    username: root
    password: password
    driver-class-name: com.mysql.cj.jdbc.Driver
    druid:
      initial-size: 5
      min-idle: 5
      max-active: 20
      max-wait: 60000
      validation-query: SELECT 1
      test-while-idle: true
      test-on-borrow: false
      test-on-return: false
```

3. 直接使用 Spring DataSource、JdbcTemplate、MyBatis 等。

## 官方属性兼容说明

本模块完全兼容Spring Boot官方数据源配置，所有参数请参考Spring Boot官方文档（https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties-data)

- 支持所有 `spring.datasource.*` 及其子项（如 hikari、druid、tomcat 等）
- 无需自定义属性类，配置方式与Spring Boot官方一致
- 推荐结合Spring Boot官方自动装配生态使用

