# Mingsha Redis Spring Boot Example

## 简介

本示例演示如何使用 Mingsha Redis Spring Boot Starter 集成 Redis，实现高性能的缓存与数据存储。

## 功能特性

- 集成 Redis
- 支持 Spring Data Redis
- 支持缓存、分布式锁、消息队列等
- 健康检查与监控

## 技术栈

- Spring Boot 3.x
- Redis
- Spring Data Redis
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 克隆项目

```bash
git clone <your-repo-url>
cd mingsha-spring-boot-project/mingsha-spring-boot-examples/mingsha-redis-spring-boot-example
```

### 2. 添加依赖

已在 `pom.xml` 中集成：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-redis-spring-boot-starter</artifactId>
</dependency>
```

### 3. 启动应用

```bash
mvn spring-boot:run
```

## 用法示例

- 访问 http://localhost:8080/ 进行接口测试
- 查看 Redis 缓存与数据操作效果

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.redis.host` | String | localhost | Redis 主机 |
| `spring.redis.port` | Integer | 6379 | Redis 端口 |
| `spring.redis.password` | String | - | Redis 密码 |

## API接口

- 标准 RedisTemplate、StringRedisTemplate 接口

## 代码结构

```
mingsha-redis-spring-boot-example/
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