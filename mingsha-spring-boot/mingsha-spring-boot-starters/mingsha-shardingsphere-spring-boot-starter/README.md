# Mingsha ShardingSphere Spring Boot Starter

## 简介

Mingsha ShardingSphere Spring Boot Starter 提供了 ShardingSphere 分库分表与 Spring Boot 的集成，支持分片、读写分离等功能。

## 功能特性

- 集成 ShardingSphere 分库分表
- 支持读写分离、分片策略
- 支持分布式事务
- 健康检查与监控
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- Apache ShardingSphere
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-shardingsphere-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加配置：

```yaml
spring:
  shardingsphere:
    datasource:
      names: ds0,ds1
      ds0:
        type: com.zaxxer.hikari.HikariDataSource
        driver-class-name: com.mysql.cj.jdbc.Driver
        jdbc-url: jdbc:mysql://localhost:3306/ds0
        username: root
        password: root
      ds1:
        type: com.zaxxer.hikari.HikariDataSource
        driver-class-name: com.mysql.cj.jdbc.Driver
        jdbc-url: jdbc:mysql://localhost:3306/ds1
        username: root
        password: root
    rules:
      sharding:
        tables:
          t_order:
            actual-data-nodes: ds$->{0..1}.t_order_$->{0..1}
            table-strategy:
              standard:
                sharding-column: order_id
                sharding-algorithm-name: t_order_inline
        sharding-algorithms:
          t_order_inline:
            type: INLINE
            props:
              algorithm-expression: t_order_$->{order_id % 2}
```

## 用法示例

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int countOrders() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM t_order_0", Integer.class);
    }
}
```

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.shardingsphere.datasource.names` | String | - | 数据源名称列表 |
| `spring.shardingsphere.rules.sharding.tables` | Map | - | 分片表配置 |

## API接口

- 通过 JdbcTemplate 进行分库分表操作

## 代码结构

```
mingsha-shardingsphere-spring-boot-starter/
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