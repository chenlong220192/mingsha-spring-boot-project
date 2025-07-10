# Mingsha MyBatis H2 Spring Boot Example

## 简介

本示例演示如何使用 Mingsha MyBatis Spring Boot Starter 集成 MyBatis 和 H2 内存数据库，实现数据库访问和操作。

## 功能特性

- 集成 MyBatis
- 集成 H2 内存数据库
- 支持 Mapper XML 和注解
- 支持事务管理

## 技术栈

- Spring Boot 3.x
- MyBatis 3.x
- H2 Database
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 克隆项目

```bash
git clone <your-repo-url>
cd mingsha-spring-boot-project/mingsha-spring-boot-examples/mingsha-mybatis-h2-spring-boot-example
```

### 2. 添加依赖

已在 `pom.xml` 中集成：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-mybatis-spring-boot-starter</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

### 3. 启动应用

```bash
mvn spring-boot:run
```

## 用法示例

- 访问 http://localhost:8080/ 进行接口测试
- 查看控制台输出的 SQL 日志

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.datasource.url` | String | jdbc:h2:mem:testdb | 数据库连接地址 |
| `mybatis.mapper-locations` | String | classpath:/mappers/*.xml | Mapper XML 路径 |

## API接口

- 标准 MyBatis 数据访问接口

## 代码结构

```
mingsha-mybatis-h2-spring-boot-example/
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