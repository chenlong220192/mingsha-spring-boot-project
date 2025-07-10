# Mingsha Solr Spring Boot Example

## 简介

本示例演示如何使用 Mingsha Solr Spring Boot Starter 集成 Solr，实现全文检索与文档存储。

## 功能特性

- 集成 Solr 搜索引擎
- 支持 Spring Data Solr
- 支持文档存储、全文检索、聚合
- 健康检查与监控

## 技术栈

- Spring Boot 3.x
- Apache Solr
- Spring Data Solr
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 克隆项目

```bash
git clone <your-repo-url>
cd mingsha-spring-boot-project/mingsha-spring-boot-examples/mingsha-solr-spring-boot-example
```

### 2. 添加依赖

已在 `pom.xml` 中集成：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-solr-spring-boot-starter</artifactId>
</dependency>
```

### 3. 启动应用

```bash
mvn spring-boot:run
```

## 用法示例

- 访问 http://localhost:8080/ 进行接口测试
- 查看 Solr 文档存储和检索效果

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.data.solr.host` | String | http://localhost:8983/solr | Solr 服务地址 |
| `spring.data.solr.zk-host` | String | - | ZooKeeper 地址（集群） |

## API接口

- 标准 Spring Data Solr Repository 接口

## 代码结构

```
mingsha-solr-spring-boot-example/
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