# Mingsha LDAP Spring Boot Autoconfigure

## 简介

本模块为 LDAP 目录服务提供 Spring Boot 自动装配能力，配合 mingsha-ldap-spring-boot-starter 使用。

- 自动装配 LdapTemplate、LdapContextSource
- 支持 application.yml 方式配置
- 提供 LDAP 认证和目录操作的自动配置

## 快速集成

1. 引入 starter 依赖（推荐通过 starter 集成）：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-ldap-spring-boot-starter</artifactId>
    <version>${revision}</version>
</dependency>
```

2. 配置 application.yml：

```yaml
spring:
  ldap:
    urls: ldap://localhost:389
    base: dc=example,dc=com
    username: cn=admin,dc=example,dc=com
    password: admin
```

3. 直接使用 LdapTemplate 进行 LDAP 操作。

## 官方属性兼容说明

本模块完全兼容Spring Boot官方LDAP配置，所有参数请参考Spring Boot官方文档（https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties.data.spring.ldap)

- 支持所有 `spring.ldap.*` 配置项
- 无需自定义属性类，配置方式与Spring Boot官方一致
- 推荐结合Spring Boot官方自动装配生态使用

