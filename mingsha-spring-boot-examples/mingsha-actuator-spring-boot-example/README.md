# Mingsha Actuator Spring Boot Example

## 简介

本示例演示如何使用 Mingsha Actuator Spring Boot Starter 集成 Spring Boot Actuator，实现健康检查、应用信息、监控指标等生产级特性。

## 功能特性

- 健康检查端点
- 应用信息端点
- 系统状态与监控指标
- 自定义健康检查扩展

## 技术栈

- Spring Boot 3.x
- Spring Boot Actuator
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 克隆项目

```bash
git clone <your-repo-url>
cd mingsha-spring-boot-project/mingsha-spring-boot-examples/mingsha-actuator-spring-boot-example
```

### 2. 添加依赖

已在 `pom.xml` 中集成：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-actuator-spring-boot-starter</artifactId>
</dependency>
```

### 3. 启动应用

```bash
mvn spring-boot:run
```

## 用法示例

- 访问健康检查端点：http://localhost:8080/actuator/health
- 访问应用信息端点：http://localhost:8080/actuator/info
- 访问监控指标端点：http://localhost:8080/actuator/metrics

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
mingsha-actuator-spring-boot-example/
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