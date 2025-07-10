# Mingsha Spring Boot Starters

## 项目简介

Mingsha Spring Boot Starters 是一套基于 Spring Boot 的快速开发启动器集合，提供了丰富的功能模块，帮助开发者快速构建企业级应用。

## 功能模块

| Starter | 功能 | 文档 |
|---------|------|------|
| `mingsha-spring-boot-starter` | 核心启动器，提供基础配置 | [文档](mingsha-spring-boot-starter/README.md) |
| `mingsha-web-spring-boot-starter` | Web应用启动器，集成Spring MVC | [文档](mingsha-web-spring-boot-starter/README.md) |
| `mingsha-test-spring-boot-starter` | 测试启动器，提供测试支持 | [文档](mingsha-test-spring-boot-starter/README.md) |
| `mingsha-mybatis-spring-boot-starter` | MyBatis 集成，支持 Druid 连接池 | [文档](mingsha-mybatis-spring-boot-starter/README.md) |
| `mingsha-redis-spring-boot-starter` | Redis 缓存集成 | [文档](mingsha-redis-spring-boot-starter/README.md) |
| `mingsha-mongodb-spring-boot-starter` | MongoDB 文档数据库启动器 | [文档](mingsha-mongodb-spring-boot-starter/README.md) |
| `mingsha-elasticsearch-spring-boot-starter` | Elasticsearch 搜索引擎启动器 | [文档](mingsha-elasticsearch-spring-boot-starter/README.md) |
| `mingsha-solr-spring-boot-starter` | Solr 搜索引擎启动器 | [文档](mingsha-solr-spring-boot-starter/README.md) |
| `mingsha-shardingsphere-spring-boot-starter` | ShardingSphere 分库分表启动器 | [文档](mingsha-shardingsphere-spring-boot-starter/README.md) |
| `mingsha-rocketmq-spring-boot-starter` | RocketMQ 消息队列启动器 | [文档](mingsha-rocketmq-spring-boot-starter/README.md) |
| `mingsha-rabbitmq-spring-boot-starter` | RabbitMQ 消息队列启动器 | [文档](mingsha-rabbitmq-spring-boot-starter/README.md) |
| `mingsha-kafka-spring-boot-starter` | Kafka 消息队列启动器 | [文档](mingsha-kafka-spring-boot-starter/README.md) |
| `mingsha-caffeine-spring-boot-starter` | Caffeine 本地缓存启动器 | [文档](mingsha-caffeine-spring-boot-starter/README.md) |
| `mingsha-actuator-spring-boot-starter` | Spring Boot Actuator 监控启动器 | [文档](mingsha-actuator-spring-boot-starter/README.md) |
| `mingsha-logging-spring-boot-starter` | 日志启动器，提供统一日志配置 | [文档](mingsha-logging-spring-boot-starter/README.md) |
| `mingsha-websocket-spring-boot-starter` | WebSocket 启动器 | [文档](mingsha-websocket-spring-boot-starter/README.md) |
| `mingsha-tomcat-spring-boot-starter` | Tomcat 服务器启动器 | [文档](mingsha-tomcat-spring-boot-starter/README.md) |
| `mingsha-ldap-spring-boot-starter` | LDAP 目录服务启动器 | [文档](mingsha-ldap-spring-boot-starter/README.md) |
| `mingsha-mail-spring-boot-starter` | 邮件服务启动器 | [文档](mingsha-mail-spring-boot-starter/README.md) |
| `mingsha-zookeeper-spring-boot-starter` | ZooKeeper 配置中心启动器 | [文档](mingsha-zookeeper-spring-boot-starter/README.md) |
| `mingsha-aop-spring-boot-starter` | AOP 切面编程启动器 | [文档](mingsha-aop-spring-boot-starter/README.md) |
| `mingsha-postgresql-spring-boot-starter` | PostgreSQL 数据库启动器 | [文档](mingsha-postgresql-spring-boot-starter/README.md) |
| `mingsha-druid-spring-boot-starter` | Druid 数据库连接池启动器 | [文档](mingsha-druid-spring-boot-starter/README.md) |
| `mingsha-mysql-spring-boot-starter` | MySQL 数据库启动器 | [文档](mingsha-mysql-spring-boot-starter/README.md) |

## 快速开始

### 1. 添加依赖

在 `pom.xml` 中添加需要的启动器依赖：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-web-spring-boot-starter</artifactId>
    <version>${revision}</version>
</dependency>
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-mybatis-spring-boot-starter</artifactId>
    <version>${revision}</version>
</dependency>
```

### 2. 配置属性

在 `application.yml` 中配置相关属性：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/test
    username: root
    password: password
  redis:
    host: localhost
    port: 6379
```

### 3. 启动应用

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

## 配置说明

每个启动器都提供了丰富的配置选项，详细配置请参考各模块的 README.md 文档。

## 版本兼容性

- Spring Boot: 3.3.0+
- Java: 17+
- Maven: 3.6+

## 贡献指南

欢迎提交 Issue 和 Pull Request 来改进这个项目。

## 许可证

本项目采用 MIT 许可证。 