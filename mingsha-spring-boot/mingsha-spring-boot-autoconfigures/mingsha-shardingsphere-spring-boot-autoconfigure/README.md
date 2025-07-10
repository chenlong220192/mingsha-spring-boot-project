# Mingsha ShardingSphere Spring Boot Autoconfigure

## 简介

本模块为 ShardingSphere 分库分表提供 Spring Boot 自动装配能力，配合 mingsha-shardingsphere-spring-boot-starter 使用。

- 自动装配 ShardingSphere 数据源和配置
- 支持 application.yml 方式配置
- 提供分库分表和读写分离的自动配置

## 快速集成

1. 引入 starter 依赖（推荐通过 starter 集成）：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-shardingsphere-spring-boot-starter</artifactId>
    <version>${revision}</version>
</dependency>
```

2. 配置 application.yml：

```yaml
spring:
  shardingsphere:
    datasource:
      names: ds0,ds1
      ds0:
        type: com.zaxxer.hikari.HikariDataSource
        driver-class-name: com.mysql.cj.jdbc.Driver
        jdbc-url: jdbc:mysql://localhost:3306/ds0
        username: root
        password: password
      ds1:
        type: com.zaxxer.hikari.HikariDataSource
        driver-class-name: com.mysql.cj.jdbc.Driver
        jdbc-url: jdbc:mysql://localhost:3306/ds1
        username: root
        password: password
```

3. 直接使用 DataSource 进行分库分表操作。

## 官方属性兼容说明

本模块完全兼容ShardingSphere官方配置，所有参数请参考ShardingSphere官方文档（https://shardingsphere.apache.org/document/current/cn/user-manual/shardingsphere-jdbc/spring-boot-starter/)

- 支持所有 `spring.shardingsphere.*` 配置项
- 无需自定义属性类，配置方式与ShardingSphere官方一致
- 推荐结合Spring Boot官方自动装配生态使用

