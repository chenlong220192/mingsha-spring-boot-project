# Mingsha Logging Spring Boot Starter

## 简介

Mingsha Logging Spring Boot Starter 提供了 HTTP 请求/响应日志拦截器功能，增强 Spring Boot 的日志记录能力。

## 功能特性

- HTTP 请求/响应日志拦截器
- 可配置的请求头和请求体记录
- 完整的配置元数据支持
- 使用标准 Spring Boot 日志配置

## 技术栈

- Spring Boot 3.x
- Logback/SLF4J
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-logging-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加配置：

```yaml
logging:
  level:
    root: INFO
    site.mingsha: DEBUG
    org.springframework.web: DEBUG
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n"
    file: "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n"
  file:
    name: logs/application.log
  interceptor-enabled: true
  interceptor:
    include-headers: true
    include-body: false
    max-body-length: 1024
```

## 用法示例

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    private static final Logger logger = LoggerFactory.getLogger(ExampleController.class);
    @GetMapping("/test")
    public String test() {
        logger.info("This is an info message");
        logger.debug("This is a debug message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");
        return "Hello World";
    }
}
```

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `logging.level.root` | String | `INFO` | 根日志级别 |
| `logging.level.site.mingsha` | String | - | Mingsha 包的日志级别 |
| `logging.pattern.console` | String | - | 控制台日志格式 |
| `logging.pattern.file` | String | - | 文件日志格式 |
| `logging.file.name` | String | - | 日志文件路径 |
| `logging.interceptor-enabled` | Boolean | `true` | 是否启用拦截器 |
| `logging.interceptor.include-headers` | Boolean | `true` | 是否包含请求头 |
| `logging.interceptor.include-body` | Boolean | `false` | 是否包含请求体 |
| `logging.interceptor.max-body-length` | Integer | `1024` | 请求体最大长度 |

## API接口

- 日志拦截器自动记录所有 HTTP 请求/响应日志
- 业务代码可直接使用 SLF4J/Logback 进行日志输出

## 代码结构

```
mingsha-logging-spring-boot-starter/
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