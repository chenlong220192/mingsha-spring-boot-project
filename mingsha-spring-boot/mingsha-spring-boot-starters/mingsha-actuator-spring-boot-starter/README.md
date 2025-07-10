# Mingsha Actuator Spring Boot Starter

## 简介

Mingsha Actuator Spring Boot Starter 集成了 Spring Boot Actuator，提供健康检查、应用信息、监控指标等生产级特性。

## 功能特性

- 健康检查端点
- 应用信息端点
- 系统状态与监控指标
- 自定义健康检查扩展
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- Spring Boot Actuator
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-actuator-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加配置：

```yaml
management:
  endpoints:
    web:
      exposure:
        include: '*'
  endpoint:
    health:
      show-details: always
```

## 用法示例

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActuatorDemoController {
    @GetMapping("/api/actuator/info")
    public String info() {
        return "App Info";
    }
}
```

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `management.endpoints.web.exposure.include` | String | `*` | 暴露所有端点 |
| `management.endpoint.health.show-details` | String | `always` | 显示健康检查详情 |

## API接口

- `/actuator/health` 健康检查
- `/actuator/info` 应用信息
- `/actuator/metrics` 监控指标

## 代码结构

```
mingsha-actuator-spring-boot-starter/
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