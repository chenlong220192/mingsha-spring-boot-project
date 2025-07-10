# Mingsha Zookeeper Spring Boot Example

## 简介

本示例演示如何使用 Mingsha Zookeeper Spring Boot Starter 集成 Zookeeper，实现分布式协调与注册发现。

## 功能特性

- 集成 Zookeeper
- 支持分布式协调、注册与发现
- 支持节点监听、数据同步
- 健康检查与监控

## 技术栈

- Spring Boot 3.x
- Zookeeper
- Curator
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 克隆项目

```bash
git clone <your-repo-url>
cd mingsha-spring-boot-project/mingsha-spring-boot-examples/mingsha-zookeeper-spring-boot-example
```

### 2. 添加依赖

已在 `pom.xml` 中集成：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-zookeeper-spring-boot-starter</artifactId>
</dependency>
```

### 3. 启动应用

```bash
mvn spring-boot:run
```

## 用法示例

- 节点注册、监听与数据同步
- 查看 Zookeeper 事件日志

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.zookeeper.connect-string` | String | localhost:2181 | Zookeeper 连接串 |
| `spring.zookeeper.session-timeout` | Integer | 60000 | 会话超时时间(ms) |

## API接口

- 标准 CuratorFramework、Watcher 接口

## 代码结构

```
mingsha-zookeeper-spring-boot-example/
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