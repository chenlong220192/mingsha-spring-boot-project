# Mingsha Redis Spring Boot Starter

## 简介

Mingsha Redis Spring Boot Starter 提供了 Redis 与 Spring Boot 的集成，支持缓存、分布式锁、消息队列等功能，提供完整的 Redis 解决方案。

## 功能特性

- Redis 与 Spring Boot 自动集成
- Spring Cache 缓存支持
- RedisTemplate 配置
- 分布式锁支持
- 消息发布订阅
- 连接池配置
- 健康检查支持
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- Redis
- Lettuce/Jedis
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-redis-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加配置：

```yaml
spring:
  redis:
    host: localhost
    port: 6379
    password: 
    database: 0
    lettuce:
      pool:
        max-active: 8
        max-idle: 8
        min-idle: 0
        max-wait: -1ms
        time-between-eviction-runs: 30s
    timeout: 2000ms
    cluster:
      nodes:
        - 127.0.0.1:7001
        - 127.0.0.1:7002
        - 127.0.0.1:7003
      max-redirects: 3
    sentinel:
      master: mymaster
      nodes:
        - 127.0.0.1:26379
        - 127.0.0.1:26380
        - 127.0.0.1:26381
```

## 用法示例

### 使用 RedisTemplate

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/redis")
public class RedisController {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @PostMapping("/set")
    public String setValue(@RequestParam String key, @RequestParam String value) {
        redisTemplate.opsForValue().set(key, value);
        return "设置成功";
    }
    @GetMapping("/get/{key}")
    public Object getValue(@PathVariable String key) {
        return redisTemplate.opsForValue().get(key);
    }
    @DeleteMapping("/delete/{key}")
    public String deleteValue(@PathVariable String key) {
        redisTemplate.delete(key);
        return "删除成功";
    }
}
```

### 使用 Spring Cache

```java
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Cacheable(value = "users", key = "#id")
    public User getUserById(Long id) {
        return userRepository.findById(id);
    }
    @CachePut(value = "users", key = "#user.id")
    public User updateUser(User user) {
        return userRepository.save(user);
    }
    @CacheEvict(value = "users", key = "#id")
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
```

### 使用分布式锁

```java
import org.springframework.integration.support.locks.LockRegistry;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private LockRegistry lockRegistry;
    public void processOrder(String orderId) {
        Lock lock = lockRegistry.obtain(orderId);
        try {
            if (lock.tryLock(10, TimeUnit.SECONDS)) {
                try {
                    // 处理订单逻辑
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
```

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.redis.host` | String | `localhost` | Redis 服务器地址 |
| `spring.redis.port` | Integer | `6379` | Redis 服务器端口 |
| `spring.redis.password` | String | - | Redis 密码 |
| `spring.redis.database` | Integer | `0` | 数据库索引 |
| `spring.redis.timeout` | Duration | `2000ms` | 连接超时时间 |
| `spring.redis.lettuce.pool.max-active` | Integer | `8` | 最大活跃连接数 |
| `spring.redis.lettuce.pool.max-idle` | Integer | `8` | 最大空闲连接数 |
| `spring.redis.lettuce.pool.min-idle` | Integer | `0` | 最小空闲连接数 |
| `spring.redis.lettuce.pool.max-wait` | Duration | `-1ms` | 获取连接等待时间 |
| `spring.redis.cluster.nodes` | List | - | 集群节点列表 |
| `spring.redis.cluster.max-redirects` | Integer | `3` | 最大重定向次数 |
| `spring.redis.sentinel.master` | String | - | 主节点名称 |
| `spring.redis.sentinel.nodes` | List | - | 哨兵节点列表 |

## API接口

- RedisTemplate 相关 RESTful API 示例见上文
- Spring Cache 注解式缓存接口见上文

## 代码结构

```
mingsha-redis-spring-boot-starter/
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