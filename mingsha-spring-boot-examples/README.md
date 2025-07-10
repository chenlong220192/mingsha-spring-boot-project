# Mingsha Spring Boot Examples

## 项目简介

Mingsha Spring Boot Examples 是一套完整的示例项目集合，展示了如何使用 Mingsha Spring Boot Starters 构建各种类型的应用。

## 示例项目列表

| 示例 | 说明 | 文档 |
|------|------|------|
| `mingsha-actuator-spring-boot-example` | 监控管理示例 | [文档](mingsha-actuator-spring-boot-example/README.md) |
| `mingsha-logging-spring-boot-example` | 日志配置示例 | [文档](mingsha-logging-spring-boot-example/README.md) |
| `mingsha-mybatis-h2-spring-boot-example` | MyBatis H2 数据库操作示例 | [文档](mingsha-mybatis-h2-spring-boot-example/README.md) |
| `mingsha-redis-spring-boot-example` | Redis 缓存操作示例 | [文档](mingsha-redis-spring-boot-example/README.md) |
| `mingsha-mongodb-spring-boot-example` | MongoDB 文档数据库示例 | [文档](mingsha-mongodb-spring-boot-example/README.md) |
| `mingsha-elasticsearch-spring-boot-example` | Elasticsearch 搜索引擎示例 | [文档](mingsha-elasticsearch-spring-boot-example/README.md) |
| `mingsha-solr-spring-boot-example` | Solr 搜索引擎示例 | [文档](mingsha-solr-spring-boot-example/README.md) |
| `mingsha-shardingsphere-spring-boot-example` | 分库分表示例 | [文档](mingsha-shardingsphere-spring-boot-example/README.md) |
| `mingsha-mybatis-mysql-spring-boot-example` | MyBatis + MySQL 示例 | [文档](mingsha-mybatis-mysql-spring-boot-example/README.md) |
| `mingsha-mybatis-postgresql-spring-boot-example` | MyBatis + PostgreSQL 示例 | [文档](mingsha-mybatis-postgresql-spring-boot-example/README.md) |
| `mingsha-rocketmq-spring-boot-example` | RocketMQ 消息队列示例 | [文档](mingsha-rocketmq-spring-boot-example/README.md) |
| `mingsha-rabbitmq-spring-boot-example` | RabbitMQ 消息队列示例 | [文档](mingsha-rabbitmq-spring-boot-example/README.md) |
| `mingsha-kafka-spring-boot-example` | Kafka 消息队列示例 | [文档](mingsha-kafka-spring-boot-example/README.md) |
| `mingsha-caffeine-spring-boot-example` | Caffeine 本地缓存示例 | [文档](mingsha-caffeine-spring-boot-example/README.md) |
| `mingsha-websocket-spring-boot-example` | WebSocket 实时通信示例 | [文档](mingsha-websocket-spring-boot-example/README.md) |
| `mingsha-tomcat-spring-boot-example` | Tomcat 服务器配置示例 | [文档](mingsha-tomcat-spring-boot-example/README.md) |
| `mingsha-ldap-spring-boot-example` | LDAP 目录服务认证示例 | [文档](mingsha-ldap-spring-boot-example/README.md) |
| `mingsha-mail-spring-boot-example` | 邮件发送示例 | [文档](mingsha-mail-spring-boot-example/README.md) |
| `mingsha-zookeeper-spring-boot-example` | ZooKeeper 配置中心示例 | [文档](mingsha-zookeeper-spring-boot-example/README.md) |
| `mingsha-aop-spring-boot-example` | AOP 切面编程示例 | [文档](mingsha-aop-spring-boot-example/README.md) |

## 快速开始

### 1. 环境准备

- JDK 17+
- Maven 3.6+
- 相关中间件（MySQL、Redis、MongoDB等）

### 2. 运行示例

选择要运行的示例项目：

```bash
# 运行 MyBatis 示例
cd mingsha-mybatis-h2-spring-boot-example
mvn spring-boot:run
# 运行 Redis 示例
cd mingsha-redis-spring-boot-example
mvn spring-boot:run
# 运行 RocketMQ 示例
cd mingsha-rocketmq-spring-boot-example
mvn spring-boot:run
# 运行 Kafka 示例
cd mingsha-kafka-spring-boot-example
mvn spring-boot:run
# 运行 Actuator 示例
cd mingsha-actuator-spring-boot-example
mvn spring-boot:run
# 运行其他示例
cd mingsha-aop-spring-boot-example && mvn spring-boot:run
cd mingsha-ldap-spring-boot-example && mvn spring-boot:run
cd mingsha-mongodb-spring-boot-example && mvn spring-boot:run
cd mingsha-solr-spring-boot-example && mvn spring-boot:run
```

### 3. 访问应用

大多数示例应用运行在 `http://localhost:8080`，具体端口请查看各示例的配置文件。

## 示例项目结构

每个示例项目都包含以下结构：

```
src/main/java/site/mingsha/boot/example/
├── [模块名]Application.java          # 主应用类
├── controller/                       # 控制器层
├── service/                          # 服务层
├── entity/                           # 实体类
└── config/                           # 配置类

src/main/resources/
├── application.yml                   # 主配置文件
├── application-server.yml            # 服务器配置
├── application-logging.yml           # 日志配置
└── application-[模块名].yml          # 模块专用配置
```

## 配置说明

### 通用配置

所有示例项目都使用统一的配置结构：

```yaml
spring:
  application:
    name: mingsha-[模块名]-spring-boot-example
  profiles:
    include:
      - server
      - logging
      - [模块名]
```

### 模块配置

每个模块都有专门的配置文件，包含该模块的特定配置。

## 测试

### 单元测试

```bash
mvn test
```

### 集成测试

```bash
mvn verify
```

## 常见问题

### 1. 端口冲突

如果8080端口被占用，可以修改 `application-server.yml` 中的端口配置。

### 2. 数据库连接

确保相关数据库服务已启动，并检查连接配置是否正确。

### 3. 中间件依赖

某些示例需要特定的中间件支持，请确保相关服务已启动。

## 贡献指南

欢迎提交 Issue 和 Pull Request 来改进示例项目。

## 相关文档

- [Mingsha Spring Boot Starters](../mingsha-spring-boot/mingsha-spring-boot-starters/README.md)
- [Spring Boot 官方文档](https://spring.io/projects/spring-boot)

## 许可证

本项目采用 MIT 许可证。 