# Mingsha Tomcat Spring Boot Starter

## 简介

Mingsha Tomcat Spring Boot Starter 提供了 Tomcat 服务器与 Spring Boot 的集成，支持嵌入式 Web 容器配置与优化。

## 功能特性

- 集成嵌入式 Tomcat
- 支持端口、线程池等参数配置
- 支持 HTTPS、GZIP 压缩等
- 健康检查与监控
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- Tomcat 10+
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-tomcat-spring-boot-starter</artifactId>
</dependency>
```

### 2. 配置

在 `application.yml` 中添加配置：

```yaml
server:
  port: 8080
  tomcat:
    max-threads: 200
    min-spare-threads: 10
    uri-encoding: UTF-8
    max-http-header-size: 8192
    connection-timeout: 20000
    basedir: /tmp/tomcat
    accesslog:
      enabled: true
      directory: logs
      pattern: '%h %l %u %t "%r" %s %b'
```

## 用法示例

无需额外代码，Spring Boot 自动集成。

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `server.port` | Integer | 8080 | 服务端口 |
| `server.tomcat.max-threads` | Integer | 200 | 最大线程数 |
| `server.tomcat.min-spare-threads` | Integer | 10 | 最小空闲线程数 |

## API接口

- 标准 HTTP 服务接口

## 代码结构

```
mingsha-tomcat-spring-boot-starter/
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