# Mingsha WebSocket Spring Boot Example

## 简介

本示例演示如何使用 Mingsha WebSocket Spring Boot Starter 集成 WebSocket，实现实时通信能力。

## 功能特性

- 集成 WebSocket
- 支持点对点、广播消息
- 支持自定义消息处理器
- 健康检查与监控

## 技术栈

- Spring Boot 3.x
- WebSocket
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 克隆项目

```bash
git clone <your-repo-url>
cd mingsha-spring-boot-project/mingsha-spring-boot-examples/mingsha-websocket-spring-boot-example
```

### 2. 添加依赖

已在 `pom.xml` 中集成：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-websocket-spring-boot-starter</artifactId>
</dependency>
```

### 3. 启动应用

```bash
mvn spring-boot:run
```

## 用法示例

- 建立 WebSocket 连接进行消息收发
- 查看消息日志

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.websocket.path` | String | /ws | WebSocket 端点路径 |
| `spring.websocket.allowed-origins` | String | * | 允许的来源 |

## API接口

- 标准 @ServerEndpoint、@OnMessage 注解接口

## 代码结构

```
mingsha-websocket-spring-boot-example/
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