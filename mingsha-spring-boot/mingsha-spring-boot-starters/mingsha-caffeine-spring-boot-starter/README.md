# Mingsha Caffeine Spring Boot Starter

## 简介

Mingsha Caffeine Spring Boot Starter 提供了 Caffeine 本地缓存与 Spring Boot 的集成，支持高性能本地缓存能力。

## 功能特性

- 集成 Caffeine 本地缓存
- 支持 Spring Cache 注解
- 缓存自动配置
- 缓存统计与监控
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- Caffeine
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-caffeine-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加配置：

```yaml
spring:
  cache:
    type: caffeine
    caffeine:
      spec: maximumSize=1000,expireAfterWrite=600s
```

## 用法示例

```java
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Cacheable(value = "users", key = "#id")
    public User getUserById(Long id) {
        // 查询数据库
        return userRepository.findById(id);
    }
}
```

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.cache.type` | String | `caffeine` | 缓存类型 |
| `spring.cache.caffeine.spec` | String | - | Caffeine 缓存规格 |

## API接口

- 通过 Spring Cache 注解实现缓存接口

## 代码结构

```
mingsha-caffeine-spring-boot-starter/
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