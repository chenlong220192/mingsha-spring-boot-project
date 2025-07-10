# Mingsha LDAP Spring Boot Example

## 简介

本示例演示如何使用 Mingsha LDAP Spring Boot Starter 集成 LDAP，实现目录服务的认证与查询。

## 功能特性

- 集成 LDAP 目录服务
- 支持用户认证与查询
- 支持 Spring Security LDAP
- 健康检查与监控

## 技术栈

- Spring Boot 3.x
- LDAP
- Spring Security LDAP
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 克隆项目

```bash
git clone <your-repo-url>
cd mingsha-spring-boot-project/mingsha-spring-boot-examples/mingsha-ldap-spring-boot-example
```

### 2. 添加依赖

已在 `pom.xml` 中集成：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-ldap-spring-boot-starter</artifactId>
</dependency>
```

### 3. 启动应用

```bash
mvn spring-boot:run
```

## 用法示例

- 用户认证与目录查询
- 查看认证日志

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.ldap.urls` | String | ldap://localhost:389 | LDAP 服务器地址 |
| `spring.ldap.base` | String | dc=example,dc=com | 基础 DN |
| `spring.ldap.username` | String | - | 管理员用户名 |
| `spring.ldap.password` | String | - | 管理员密码 |

## API接口

- 标准 LdapTemplate、Spring Security LDAP 接口

## 代码结构

```
mingsha-ldap-spring-boot-example/
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