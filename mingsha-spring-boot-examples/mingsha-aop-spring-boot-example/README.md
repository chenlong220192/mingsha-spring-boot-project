# Mingsha AOP Spring Boot Example

## 简介

本示例演示如何使用 Mingsha AOP Spring Boot Starter 集成 AOP，实现切面编程与横切关注点处理。

## 功能特性

- 集成 Spring AOP
- 支持自定义切面、注解
- 支持日志、权限、事务等横切逻辑
- 健康检查与监控

## 技术栈

- Spring Boot 3.x
- Spring AOP
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 克隆项目

```bash
git clone <your-repo-url>
cd mingsha-spring-boot-project/mingsha-spring-boot-examples/mingsha-aop-spring-boot-example
```

### 2. 添加依赖

已在 `pom.xml` 中集成：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-aop-spring-boot-starter</artifactId>
</dependency>
```

### 3. 启动应用

```bash
mvn spring-boot:run
```

## 用法示例

- 自定义切面实现日志、权限等功能
- 查看切面执行日志

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.aop.auto` | Boolean | true | 是否自动启用 AOP |
| `spring.aop.proxy-target-class` | Boolean | true | 是否使用 CGLIB 代理 |

## API接口

- 标准 @Aspect 注解切面接口

## 代码结构

```
mingsha-aop-spring-boot-example/
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