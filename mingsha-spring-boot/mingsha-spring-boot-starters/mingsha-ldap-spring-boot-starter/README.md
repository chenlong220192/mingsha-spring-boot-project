# Mingsha LDAP Spring Boot Starter

## 简介

Mingsha LDAP Spring Boot Starter 提供了 LDAP 目录服务与 Spring Boot 的集成，支持用户认证、组织管理等功能。

## 功能特性

- LDAP 与 Spring Boot 自动集成
- 支持用户认证与授权
- 支持组织结构管理
- 健康检查与监控
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- Spring LDAP
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-ldap-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加配置：

```yaml
spring:
  ldap:
    urls: ldap://localhost:389
    base: dc=example,dc=com
    username: cn=admin,dc=example,dc=com
    password: admin
```

## 用法示例

```java
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;

@Service
public class LdapService {
    private final LdapTemplate ldapTemplate;

    public LdapService(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }

    // 示例：查找用户
    public List<String> findAllUsers() {
        return ldapTemplate.search(
            "ou=users",
            "(objectClass=person)",
            (attributes, name) -> name
        );
    }
}
```

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `spring.ldap.urls` | String | - | LDAP 服务器地址 |
| `spring.ldap.base` | String | - | 基础 DN |
| `spring.ldap.username` | String | - | 管理员用户名 |
| `spring.ldap.password` | String | - | 管理员密码 |

## API接口

- 通过 LdapTemplate 进行目录操作

## 代码结构

```
mingsha-ldap-spring-boot-starter/
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