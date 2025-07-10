# Mingsha MyBatis Spring Boot Starter

## 简介

Mingsha MyBatis Spring Boot Starter 提供了 MyBatis 与 Spring Boot 的集成，支持 Druid 连接池、MySQL 驱动等，提供完整的数据库访问解决方案。

## 功能特性

- MyBatis 与 Spring Boot 自动集成
- Druid 连接池支持
- MySQL 驱动集成
- 完整的配置元数据支持
- 使用标准 Spring Boot 数据源配置

## 技术栈

- Spring Boot 3.x
- MyBatis 3.x
- Druid
- MySQL
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-mybatis-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加配置：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai
    username: root
    password: password
    driver-class-name: com.mysql.cj.jdbc.Driver
    druid:
      initial-size: 5
      min-idle: 5
      max-active: 20
      max-wait: 60000
      time-between-eviction-runs-millis: 60000
      min-evictable-idle-time-millis: 300000
      validation-query: SELECT 1
      test-while-idle: true
      test-on-borrow: false
      test-on-return: false
      filters: stat,wall,log4j
mybatis:
  mapper-locations: classpath:mapper/*.xml
  type-aliases-package: com.example.entity
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: true
    lazy-loading-enabled: true
    aggressive-lazy-loading: false
```

## 用法示例

### Mapper 接口

```java
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> findAll();
    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(Long id);
}
```

### 控制器示例

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping
    public List<User> getAllUsers() {
        return userMapper.findAll();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userMapper.findById(id);
    }
}
```

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.datasource.url` | String | - | 数据库连接URL |
| `spring.datasource.username` | String | - | 数据库用户名 |
| `spring.datasource.password` | String | - | 数据库密码 |
| `spring.datasource.driver-class-name` | String | `com.mysql.cj.jdbc.Driver` | 数据库驱动类名 |
| `spring.datasource.druid.initial-size` | Integer | `5` | 初始连接数 |
| `spring.datasource.druid.min-idle` | Integer | `5` | 最小空闲连接数 |
| `spring.datasource.druid.max-active` | Integer | `20` | 最大活跃连接数 |
| `spring.datasource.druid.max-wait` | Long | `60000` | 获取连接等待超时时间 |
| `spring.datasource.druid.validation-query` | String | `SELECT 1` | 验证查询SQL |
| `spring.datasource.druid.test-while-idle` | Boolean | `true` | 空闲时是否检测连接有效性 |
| `spring.datasource.druid.filters` | String | `stat,wall,log4j` | 监控统计拦截的filters |
| `mybatis.mapper-locations` | String | `classpath:mapper/*.xml` | Mapper 文件位置 |
| `mybatis.type-aliases-package` | String | - | 类型别名包 |
| `mybatis.configuration.map-underscore-to-camel-case` | Boolean | `true` | 开启驼峰命名转换 |
| `mybatis.configuration.cache-enabled` | Boolean | `true` | 开启二级缓存 |

## 代码结构

```
mingsha-mybatis-spring-boot-starter/
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