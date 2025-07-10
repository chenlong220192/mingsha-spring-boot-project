# Mingsha ShardingSphere Spring Boot Example

## 简介

本示例演示如何使用 Mingsha ShardingSphere Spring Boot Starter 集成 ShardingSphere，实现分库分表与分布式事务。

## 功能特性

- 集成 ShardingSphere 分库分表
- 支持分布式事务
- 支持多数据源、读写分离
- 健康检查与监控

## 技术栈

- Spring Boot 3.x
- Apache ShardingSphere
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 克隆项目

```bash
git clone <your-repo-url>
cd mingsha-spring-boot-project/mingsha-spring-boot-examples/mingsha-shardingsphere-spring-boot-example
```

### 2. 添加依赖

已在 `pom.xml` 中集成：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-shardingsphere-spring-boot-starter</artifactId>
</dependency>
```

### 3. 启动应用

```bash
mvn spring-boot:run
```

## 用法示例

- 访问 http://localhost:8080/ 进行接口测试
- 查看分库分表和事务效果

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.shardingsphere.datasource.names` | String | - | 数据源名称列表 |
| `spring.shardingsphere.rules.sharding.tables` | String | - | 分表配置 |
| `spring.shardingsphere.rules.readwrite-splitting.data-sources` | String | - | 读写分离配置 |

## API接口

- 标准 ShardingSphere DataSource、分库分表相关接口

## 代码结构

```
mingsha-shardingsphere-spring-boot-example/
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