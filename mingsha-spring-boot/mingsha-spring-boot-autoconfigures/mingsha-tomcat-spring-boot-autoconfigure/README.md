# Mingsha Tomcat Spring Boot Autoconfigure

## 简介

本模块为 Tomcat 内嵌服务器提供 Spring Boot 自动装配能力，配合 mingsha-tomcat-spring-boot-starter 使用。

- 自动装配 Tomcat 服务器配置
- 支持 application.yml 方式配置
- 提供 Tomcat 连接池和性能优化的自动配置

## 快速集成

1. 引入 starter 依赖（推荐通过 starter 集成）：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-tomcat-spring-boot-starter</artifactId>
    <version>${revision}</version>
</dependency>
```

2. 配置 application.yml：

```yaml
server:
  port: 8080
  tomcat:
    threads:
      max: 200
      min-spare: 10
    connection-timeout: 20000
```

3. 启动应用即可使用配置的 Tomcat 服务器。

## 官方属性兼容说明

本模块完全兼容Spring Boot官方Tomcat配置，所有参数请参考Spring Boot官方文档（https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties.web.server.tomcat)

- 支持所有 `server.tomcat.*` 配置项
- 无需自定义属性类，配置方式与Spring Boot官方一致
- 推荐结合Spring Boot官方自动装配生态使用

