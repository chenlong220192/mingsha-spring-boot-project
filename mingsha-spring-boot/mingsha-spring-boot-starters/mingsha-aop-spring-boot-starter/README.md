# Mingsha AOP Spring Boot Starter

## 简介

Mingsha AOP Spring Boot Starter 提供了 AOP（面向切面编程）与 Spring Boot 的集成，支持切面、拦截器、日志等功能。

## 功能特性

- 集成 Spring AOP
- 支持自定义切面、拦截器
- 支持方法日志、权限校验等
- 健康检查与监控
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- Spring AOP
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-aop-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

无需特殊配置，Spring Boot 自动集成。

## 用法示例

```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Before("execution(* com.example.service.*.*(..))")
    public void beforeMethod() {
        System.out.println("方法调用前日志");
    }
}
```

## 配置说明

无需特殊配置。

## API接口

- 通过自定义切面实现方法拦截

## 代码结构

```
mingsha-aop-spring-boot-starter/
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