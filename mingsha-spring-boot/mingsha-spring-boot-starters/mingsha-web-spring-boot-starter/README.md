# Mingsha Web Spring Boot Starter

## 简介

Mingsha Web Spring Boot Starter 提供了 Web 应用开发的基础集成，支持 Spring MVC、参数校验、全局异常处理等。

## 功能特性

- 集成 Spring MVC
- 支持参数校验、全局异常处理
- 支持 CORS、拦截器等
- 健康检查与监控
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- Spring MVC
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-web-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加配置：

```yaml
server:
  port: 8080
spring:
  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher
  web:
    resources:
      static-locations: classpath:/static/
```

## 用法示例

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Mingsha!";
    }
}
```

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `server.port` | Integer | 8080 | 服务端口 |
| `spring.mvc.pathmatch.matching-strategy` | String | ant_path_matcher | 路径匹配策略 |

## API接口

- 标准 RESTful HTTP 接口

## 代码结构

```
mingsha-web-spring-boot-starter/
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