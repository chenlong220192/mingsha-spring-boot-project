# Mingsha Zookeeper Spring Boot Starter

## 简介

Mingsha Zookeeper Spring Boot Starter 提供了 Zookeeper 分布式协调服务与 Spring Boot 的集成，支持分布式锁、注册中心等功能。

## 功能特性

- 集成 Zookeeper 客户端
- 支持分布式锁、注册中心
- 支持节点监听、数据发布订阅
- 健康检查与监控
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- Apache Zookeeper
- Curator
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-zookeeper-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加配置：

```yaml
spring:
  zookeeper:
    connect-string: localhost:2181
    session-timeout: 60000
    connection-timeout: 15000
```

## 用法示例

```java
import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZookeeperService {
    @Autowired
    private CuratorFramework curatorFramework;

    public void createNode(String path, byte[] data) throws Exception {
        curatorFramework.create().creatingParentsIfNeeded().forPath(path, data);
    }
}
```

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.zookeeper.connect-string` | String | localhost:2181 | Zookeeper 连接地址 |
| `spring.zookeeper.session-timeout` | Integer | 60000 | 会话超时时间（毫秒） |
| `spring.zookeeper.connection-timeout` | Integer | 15000 | 连接超时时间（毫秒） |

## API接口

- 通过 CuratorFramework 进行节点操作

## 代码结构

```
mingsha-zookeeper-spring-boot-starter/
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