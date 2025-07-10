# Mingsha MyBatis PostgreSQL Spring Boot Example

## 简介

本示例演示如何使用 Mingsha MyBatis Spring Boot Starter 集成 MyBatis 和 PostgreSQL，实现关系型数据库的访问与操作。

## 功能特性

- 集成 MyBatis 持久层框架
- 支持 PostgreSQL 数据库
- 支持多数据源配置
- 分页、动态 SQL、类型处理器

## 技术栈

- Spring Boot 3.x
- MyBatis
- PostgreSQL
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 克隆项目

```bash
git clone <your-repo-url>
cd mingsha-spring-boot-project/mingsha-spring-boot-examples/mingsha-mybatis-postgresql-spring-boot-example
```

### 2. 添加依赖

已在 `pom.xml` 中集成：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-mybatis-spring-boot-starter</artifactId>
</dependency>
```

### 3. 启动应用

```bash
mvn spring-boot:run
```

## 用法示例

- 访问 http://localhost:8080/ 进行接口测试
- 查看数据库操作日志

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.datasource.url` | String | - | 数据库连接 URL |
| `spring.datasource.username` | String | - | 数据库用户名 |
| `spring.datasource.password` | String | - | 数据库密码 |
| `mybatis.mapper-locations` | String | classpath:mapper/*.xml | Mapper XML 路径 |

## API接口

- 标准 MyBatis Mapper 接口

## 代码结构

```
mingsha-mybatis-postgresql-spring-boot-example/
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