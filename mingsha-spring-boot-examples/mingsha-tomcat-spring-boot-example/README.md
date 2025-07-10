# Mingsha Tomcat Spring Boot Example

## 简介

本示例演示如何使用 Mingsha Tomcat Spring Boot Starter 集成 Tomcat，实现内嵌式 Web 服务器的配置与优化。

## 功能特性

- 集成 Tomcat 内嵌服务器
- 支持端口、线程池、连接数等参数配置
- 支持 HTTPS、压缩、访问日志等
- 健康检查与监控

## 技术栈

- Spring Boot 3.x
- Tomcat
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 克隆项目

```bash
git clone <your-repo-url>
cd mingsha-spring-boot-project/mingsha-spring-boot-examples/mingsha-tomcat-spring-boot-example
```

### 2. 添加依赖

已在 `pom.xml` 中集成：

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-tomcat-spring-boot-starter</artifactId>
</dependency>
```

### 3. 启动应用

```bash
mvn spring-boot:run
```

## 用法示例

- 访问 http://localhost:8080/ 进行接口测试
- 查看 Tomcat 相关配置和日志

## 配置说明

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `server.port` | Integer | 8080 | 服务端口 |
| `server.tomcat.max-threads` | Integer | 200 | 最大工作线程数 |
| `server.tomcat.max-connections` | Integer | 10000 | 最大连接数 |
| `server.tomcat.uri-encoding` | String | UTF-8 | URI 编码 |

## API接口

- 标准 Spring Boot Web Controller 接口

## 代码结构

```
mingsha-tomcat-spring-boot-example/
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