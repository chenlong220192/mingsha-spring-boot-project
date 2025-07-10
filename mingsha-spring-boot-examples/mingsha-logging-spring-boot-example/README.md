# Mingsha Logging Spring Boot Example

## 简介

本示例演示如何使用 Mingsha Logging Spring Boot Starter 集成 HTTP 请求/响应日志拦截器，增强 Spring Boot 日志记录能力。

## 功能特性

- HTTP 请求/响应日志拦截
- 可配置的请求头和请求体记录
- 支持标准 Spring Boot 日志配置

## 技术栈

- Spring Boot 3.x
- Logback/SLF4J
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 克隆项目

```bash
git clone <your-repo-url>
cd mingsha-spring-boot-project/mingsha-spring-boot-examples/mingsha-logging-spring-boot-example
```

### 2. 添加依赖

已在 `pom.xml` 中集成：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-logging-spring-boot-starter</artifactId>
</dependency>
```

### 3. 启动应用

```bash
mvn spring-boot:run
```

## 用法示例

- 查看控制台和日志文件输出的 HTTP 请求/响应日志
- 可通过 `application.yml` 配置日志级别和格式

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `logging.level.root` | String | INFO | 全局日志级别 |
| `logging.pattern.console` | String | - | 控制台日志格式 |

## API接口

- 标准 Spring Boot Web 接口

## 代码结构

```
mingsha-logging-spring-boot-example/
├── pom.xml
├── src/
│   ├── main/java/
│   └── main/resources/
└── README.md
```

## 测试

```bash
mvn test
```

## 贡献

欢迎提交 Issue 和 Pull Request！ 