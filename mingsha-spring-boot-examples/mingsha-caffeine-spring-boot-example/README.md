# Mingsha Caffeine Spring Boot Example

## 简介

本示例演示如何使用 Mingsha Caffeine Spring Boot Starter 集成 Caffeine 本地缓存，实现高性能缓存能力。

## 功能特性

- 集成 Caffeine 本地缓存
- 支持 Spring Cache 注解
- 缓存自动配置
- 缓存统计与监控

## 技术栈

- Spring Boot 3.x
- Caffeine
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 克隆项目

```bash
git clone <your-repo-url>
cd mingsha-spring-boot-project/mingsha-spring-boot-examples/mingsha-caffeine-spring-boot-example
```

### 2. 添加依赖

已在 `pom.xml` 中集成：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-caffeine-spring-boot-starter</artifactId>
</dependency>
```

### 3. 启动应用

```bash
mvn spring-boot:run
```

## 用法示例

- 访问 http://localhost:8080/ 进行接口测试
- 查看缓存命中率和统计信息

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.cache.type` | String | caffeine | 缓存类型 |
| `spring.cache.caffeine.spec` | String | - | Caffeine 缓存规格 |

## API接口

- 标准 Spring Cache 注解接口

## 代码结构

```
mingsha-caffeine-spring-boot-example/
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