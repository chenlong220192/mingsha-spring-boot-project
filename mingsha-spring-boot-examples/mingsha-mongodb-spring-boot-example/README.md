# Mingsha MongoDB Spring Boot Example

## 简介

本示例演示如何使用 Mingsha MongoDB Spring Boot Starter 集成 MongoDB，实现文档数据库的访问和操作。

## 功能特性

- 集成 MongoDB
- 支持 Spring Data MongoDB
- 支持文档存储、查询、聚合
- 健康检查与监控

## 技术栈

- Spring Boot 3.x
- MongoDB
- Spring Data MongoDB
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 克隆项目

```bash
git clone <your-repo-url>
cd mingsha-spring-boot-project/mingsha-spring-boot-examples/mingsha-mongodb-spring-boot-example
```

### 2. 添加依赖

已在 `pom.xml` 中集成：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-mongodb-spring-boot-starter</artifactId>
</dependency>
```

### 3. 启动应用

```bash
mvn spring-boot:run
```

## 用法示例

- 访问 http://localhost:8080/ 进行接口测试
- 查看 MongoDB 文档存储和查询效果

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.data.mongodb.host` | String | localhost | MongoDB 主机 |
| `spring.data.mongodb.port` | Integer | 27017 | MongoDB 端口 |
| `spring.data.mongodb.database` | String | - | 数据库名 |

## API接口

- 标准 Spring Data MongoDB Repository 接口

## 代码结构

```
mingsha-mongodb-spring-boot-example/
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