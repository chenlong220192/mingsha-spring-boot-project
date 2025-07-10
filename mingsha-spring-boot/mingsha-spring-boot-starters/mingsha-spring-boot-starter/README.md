# Mingsha Spring Boot Starter

## 简介

Mingsha Spring Boot Starter 是 Mingsha Spring Boot 项目的核心启动器，提供了 Spring Boot 应用的基础配置和自动装配功能，是所有其他 Mingsha Starter 的基础依赖。

## 功能特性

- Spring Boot 自动配置
- 基础依赖管理
- 配置属性支持
- 自动装配支持
- 条件化配置
- 配置元数据
- 健康检查
- 监控指标
- 日志配置
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加基础配置：

```yaml
spring:
  application:
    name: mingsha-application
  profiles:
    active: dev
  main:
    banner-mode: console
    web-application-type: servlet
server:
  port: 8080
  servlet:
    context-path: /
```

## 用法示例

无需额外代码，Spring Boot 自动集成。

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.application.name` | String | - | 应用名称 |
| `server.port` | Integer | 8080 | 服务端口 |

## API接口

- 标准 Spring Boot 应用接口

## 代码结构

```
mingsha-spring-boot-starter/
├── pom.xml
├── src/
│   ├── main/java/site/mingsha/boot/
│   └── main/resources/
└── README.md
```

## 测试

```bash
mvn test
```

## 贡献

欢迎提交 Issue 和 Pull Request！ 