# Mingsha Druid Spring Boot Example

## 简介

本示例演示如何使用 Mingsha Druid Spring Boot Starter 集成 Druid 数据库连接池，实现高效的数据库连接管理与监控。

## 功能特性

- 集成 Druid 数据库连接池
- 支持多数据源配置
- SQL 监控与统计
- Web 监控控制台

## 技术栈

- Spring Boot 3.x
- Druid
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 克隆项目

```bash
git clone <your-repo-url>
cd mingsha-spring-boot-project/mingsha-spring-boot-examples/mingsha-druid-spring-boot-example
```

### 2. 添加依赖

已在 `pom.xml` 中集成：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-druid-spring-boot-starter</artifactId>
</dependency>
```

### 3. 启动应用

```bash
mvn spring-boot:run
```

## 用法示例

- 访问 Druid 监控页面 http://localhost:8080/druid
- 查看 SQL 执行统计

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.datasource.url` | String | - | 数据库连接 URL |
| `spring.datasource.username` | String | - | 数据库用户名 |
| `spring.datasource.password` | String | - | 数据库密码 |
| `spring.datasource.driver-class-name` | String | com.mysql.cj.jdbc.Driver | 驱动类名 |

## API接口

- 标准 DataSource、Druid 监控接口

## 代码结构

```
mingsha-druid-spring-boot-example/
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