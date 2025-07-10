# Mingsha MongoDB Spring Boot Starter

## 简介

Mingsha MongoDB Spring Boot Starter 提供了 MongoDB 与 Spring Boot 的集成，支持文档数据库操作、自动配置、健康检查等。

## 功能特性

- MongoDB 与 Spring Boot 自动集成
- Spring Data MongoDB 支持
- 健康检查与监控
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- MongoDB
- Spring Data MongoDB
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-mongodb-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加配置：

```yaml
spring:
  data:
    mongodb:
      host: localhost
      port: 27017
      database: mingsha_example
```

## 用法示例

```java
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
```

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.data.mongodb.host` | String | `localhost` | MongoDB 主机 |
| `spring.data.mongodb.port` | Integer | `27017` | 端口号 |
| `spring.data.mongodb.database` | String | - | 数据库名 |

## API接口

- 通过 Spring Data MongoDB Repository 实现数据访问接口

## 代码结构

```
mingsha-mongodb-spring-boot-starter/
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