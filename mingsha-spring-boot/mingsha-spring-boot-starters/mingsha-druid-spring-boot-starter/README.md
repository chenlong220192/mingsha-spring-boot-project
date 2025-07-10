# Mingsha Druid Spring Boot Starter

## 简介

Mingsha Druid Spring Boot Starter 提供了 Druid 数据库连接池与 Spring Boot 的集成，支持高性能数据库连接管理与监控。

## 功能特性

- 集成 Druid 数据库连接池
- 支持 SQL 监控与统计
- 支持连接池参数配置
- 健康检查与监控
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- Druid
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-druid-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加配置：

```yaml
spring:
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    url: jdbc:mysql://localhost:3306/test
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver
    druid:
      initial-size: 5
      min-idle: 5
      max-active: 20
      stat-view-servlet:
        enabled: true
        login-username: admin
        login-password: admin
```

## 用法示例

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DruidService {
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
| `spring.datasource.type` | String | com.alibaba.druid.pool.DruidDataSource | 连接池类型 |
| `spring.datasource.url` | String | - | 数据库连接地址 |
| `spring.datasource.username` | String | - | 数据库用户名 |
| `spring.datasource.password` | String | - | 数据库密码 |
| `spring.datasource.druid.initial-size` | Integer | 5 | 初始连接数 |
| `spring.datasource.druid.max-active` | Integer | 20 | 最大连接数 |

## API接口

- 通过 JdbcTemplate 进行数据库操作
- 通过 `/druid` 监控页面查看连接池状态

## 代码结构

```
mingsha-druid-spring-boot-starter/
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