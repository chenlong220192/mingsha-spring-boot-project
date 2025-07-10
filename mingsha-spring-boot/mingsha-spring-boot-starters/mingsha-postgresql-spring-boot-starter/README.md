# Mingsha PostgreSQL Spring Boot Starter

## 简介

Mingsha PostgreSQL Spring Boot Starter 提供了 PostgreSQL 数据库驱动与 Spring Boot 的集成，支持高效的数据库访问和配置。

## 功能特性

- 集成 PostgreSQL 驱动
- 支持标准 Spring Boot 数据源配置
- 支持连接池参数配置
- 健康检查与监控
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- PostgreSQL 14+
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-postgresql-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加配置：

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/test
    username: postgres
    password: postgres
    driver-class-name: org.postgresql.Driver
```

## 用法示例

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PostgresService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int countUsers() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM user", Integer.class);
    }
}
```

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.datasource.url` | String | - | 数据库连接地址 |
| `spring.datasource.username` | String | - | 数据库用户名 |
| `spring.datasource.password` | String | - | 数据库密码 |
| `spring.datasource.driver-class-name` | String | org.postgresql.Driver | 驱动类名 |

## API接口

- 通过 JdbcTemplate 进行数据库操作

## 代码结构

```
mingsha-postgresql-spring-boot-starter/
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