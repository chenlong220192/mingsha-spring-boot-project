# Mingsha Elasticsearch Spring Boot Starter

## 简介

Mingsha Elasticsearch Spring Boot Starter 提供了 Elasticsearch 与 Spring Boot 的集成，支持文档存储、全文检索、自动配置等。

## 功能特性

- Elasticsearch 与 Spring Boot 自动集成
- Spring Data Elasticsearch 支持
- 健康检查与监控
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- Elasticsearch
- Spring Data Elasticsearch
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-elasticsearch-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加配置：

```yaml
spring:
  data:
    elasticsearch:
      uris: http://localhost:9200
      username: elastic
      password: changeme
```

## 用法示例

```java
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends ElasticsearchRepository<Document, String> {
    List<Document> findByTitle(String title);
}
```

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.data.elasticsearch.uris` | String | `http://localhost:9200` | ES 节点地址 |
| `spring.data.elasticsearch.username` | String | - | 用户名 |
| `spring.data.elasticsearch.password` | String | - | 密码 |

## API接口

- 通过 Spring Data Elasticsearch Repository 实现数据访问接口

## 代码结构

```
mingsha-elasticsearch-spring-boot-starter/
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