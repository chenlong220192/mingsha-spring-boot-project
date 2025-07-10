# Mingsha Solr Spring Boot Starter

## 简介

Mingsha Solr Spring Boot Starter 提供了 Solr 搜索引擎与 Spring Boot 的集成，支持全文检索、索引管理等功能。

## 功能特性

- 集成 Solr 搜索引擎
- 支持全文检索、索引管理
- 健康检查与监控
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- Apache Solr
- Spring Data Solr
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-solr-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加配置：

```yaml
spring:
  data:
    solr:
      host: http://localhost:8983/solr
```

## 用法示例

```java
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends SolrCrudRepository<Product, String> {
    Product findByName(String name);
}
```

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.data.solr.host` | String | http://localhost:8983/solr | Solr 服务地址 |

## API接口

- 通过 Spring Data Solr Repository 进行数据访问

## 代码结构

```
mingsha-solr-spring-boot-starter/
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