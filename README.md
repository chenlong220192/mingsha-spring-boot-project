# Mingsha Spring Boot Project

## 模块总览

| 模块类型         | 模块名 | 说明           | 文档 |
|------------------|----------------|--------------------|------|
| **Starter**      | mingsha-mysql-spring-boot-starter         | MySQL 启动器         | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-mysql-spring-boot-starter/README.md) |
|                  | mingsha-druid-spring-boot-starter         | Druid 连接池启动器   | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-druid-spring-boot-starter/README.md) |
|                  | mingsha-postgresql-spring-boot-starter    | PostgreSQL 启动器    | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-postgresql-spring-boot-starter/README.md) |
|                  | mingsha-kafka-spring-boot-starter         | Kafka 启动器         | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-kafka-spring-boot-starter/README.md) |
|                  | mingsha-solr-spring-boot-starter          | Solr 启动器          | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-solr-spring-boot-starter/README.md) |
|                  | mingsha-mongodb-spring-boot-starter       | MongoDB 启动器       | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-mongodb-spring-boot-starter/README.md) |
|                  | mingsha-aop-spring-boot-starter           | AOP 启动器           | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-aop-spring-boot-starter/README.md) |
|                  | mingsha-ldap-spring-boot-starter          | LDAP 启动器          | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-ldap-spring-boot-starter/README.md) |
|                  | mingsha-web-spring-boot-starter           | Web 基础能力         | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-web-spring-boot-starter/README.md) |
|                  | mingsha-websocket-spring-boot-starter     | WebSocket 启动器     | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-websocket-spring-boot-starter/README.md) |
|                  | mingsha-zookeeper-spring-boot-starter     | Zookeeper 启动器     | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-zookeeper-spring-boot-starter/README.md) |
|                  | mingsha-elasticsearch-spring-boot-starter | Elasticsearch 启动器 | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-elasticsearch-spring-boot-starter/README.md) |
|                  | mingsha-mail-spring-boot-starter          | 邮件发送             | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-mail-spring-boot-starter/README.md) |
|                  | mingsha-tomcat-spring-boot-starter        | Tomcat 内嵌容器      | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-tomcat-spring-boot-starter/README.md) |
|                  | mingsha-caffeine-spring-boot-starter      | Caffeine 本地缓存    | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-caffeine-spring-boot-starter/README.md) |
|                  | mingsha-redis-spring-boot-starter         | Redis 启动器         | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-redis-spring-boot-starter/README.md) |
|                  | mingsha-rabbitmq-spring-boot-starter      | RabbitMQ 启动器      | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-rabbitmq-spring-boot-starter/README.md) |
|                  | mingsha-actuator-spring-boot-starter      | 监控与健康检查       | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-actuator-spring-boot-starter/README.md) |
|                  | mingsha-test-spring-boot-starter          | 测试工具             | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-test-spring-boot-starter/README.md) |
|                  | mingsha-shardingsphere-spring-boot-starter| 分库分表             | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-shardingsphere-spring-boot-starter/README.md) |
|                  | mingsha-rocketmq-spring-boot-starter      | RocketMQ 启动器      | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-rocketmq-spring-boot-starter/README.md) |
|                  | mingsha-mybatis-spring-boot-starter       | MyBatis 启动器       | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-mybatis-spring-boot-starter/README.md) |
|                  | mingsha-logging-spring-boot-starter       | 日志增强             | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-logging-spring-boot-starter/README.md) |
|                  | mingsha-spring-boot-starter               | 基础 starter         | [README.md](mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-spring-boot-starter/README.md) |
| **Autoconfigure**| mingsha-mysql-spring-boot-autoconfigure   | MySQL 自动配置       | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-mysql-spring-boot-autoconfigure/README.md) |
|                  | mingsha-druid-spring-boot-autoconfigure   | Druid 自动配置       | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-druid-spring-boot-autoconfigure/README.md) |
|                  | mingsha-postgresql-spring-boot-autoconfigure | PostgreSQL 自动配置 | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-postgresql-spring-boot-autoconfigure/README.md) |
|                  | mingsha-kafka-spring-boot-autoconfigure   | Kafka 自动配置       | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-kafka-spring-boot-autoconfigure/README.md) |
|                  | mingsha-solr-spring-boot-autoconfigure    | Solr 自动配置        | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-solr-spring-boot-autoconfigure/README.md) |
|                  | mingsha-mongodb-spring-boot-autoconfigure | MongoDB 自动配置     | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-mongodb-spring-boot-autoconfigure/README.md) |
|                  | mingsha-aop-spring-boot-autoconfigure     | AOP 自动配置         | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-aop-spring-boot-autoconfigure/README.md) |
|                  | mingsha-ldap-spring-boot-autoconfigure    | LDAP 自动配置        | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-ldap-spring-boot-autoconfigure/README.md) |
|                  | mingsha-websocket-spring-boot-autoconfigure | WebSocket 自动配置  | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-websocket-spring-boot-autoconfigure/README.md) |
|                  | mingsha-zookeeper-spring-boot-autoconfigure | Zookeeper 自动配置  | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-zookeeper-spring-boot-autoconfigure/README.md) |
|                  | mingsha-elasticsearch-spring-boot-autoconfigure | Elasticsearch 自动配置 | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-elasticsearch-spring-boot-autoconfigure/README.md) |
|                  | mingsha-mail-spring-boot-autoconfigure    | 邮件发送自动配置     | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-mail-spring-boot-autoconfigure/README.md) |
|                  | mingsha-tomcat-spring-boot-autoconfigure  | Tomcat 自动配置      | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-tomcat-spring-boot-autoconfigure/README.md) |
|                  | mingsha-caffeine-spring-boot-autoconfigure | Caffeine 自动配置   | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-caffeine-spring-boot-autoconfigure/README.md) |
|                  | mingsha-redis-spring-boot-autoconfigure   | Redis 自动配置       | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-redis-spring-boot-autoconfigure/README.md) |
|                  | mingsha-rabbitmq-spring-boot-autoconfigure | RabbitMQ 自动配置   | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-rabbitmq-spring-boot-autoconfigure/README.md) |
|                  | mingsha-actuator-spring-boot-autoconfigure | 监控与健康检查自动配置 | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-actuator-spring-boot-autoconfigure/README.md) |
|                  | mingsha-shardingsphere-spring-boot-autoconfigure | 分库分表自动配置   | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-shardingsphere-spring-boot-autoconfigure/README.md) |
|                  | mingsha-rocketmq-spring-boot-autoconfigure | RocketMQ 自动配置   | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-rocketmq-spring-boot-autoconfigure/README.md) |
|                  | mingsha-mybatis-spring-boot-autoconfigure | MyBatis 自动配置     | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-mybatis-spring-boot-autoconfigure/README.md) |
|                  | mingsha-logging-spring-boot-autoconfigure | 日志增强自动配置     | [README.md](mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-logging-spring-boot-autoconfigure/README.md) |
| **Examples**     | mingsha-mybatis-h2-spring-boot-example    | MyBatis + H2 示例    | [README.md](mingsha-spring-boot-examples/mingsha-mybatis-h2-spring-boot-example/README.md) |
|                  | mingsha-mybatis-mysql-spring-boot-example | MyBatis + MySQL 示例 | [README.md](mingsha-spring-boot-examples/mingsha-mybatis-mysql-spring-boot-example/README.md) |
|                  | mingsha-mybatis-postgresql-spring-boot-example | MyBatis + PostgreSQL 示例 | [README.md](mingsha-spring-boot-examples/mingsha-mybatis-postgresql-spring-boot-example/README.md) |
|                  | mingsha-kafka-spring-boot-example         | Kafka 示例           | [README.md](mingsha-spring-boot-examples/mingsha-kafka-spring-boot-example/README.md) |
|                  | mingsha-solr-spring-boot-example          | Solr 示例            | [README.md](mingsha-spring-boot-examples/mingsha-solr-spring-boot-example/README.md) |
|                  | mingsha-mongodb-spring-boot-example       | MongoDB 示例         | [README.md](mingsha-spring-boot-examples/mingsha-mongodb-spring-boot-example/README.md) |
|                  | mingsha-aop-spring-boot-example           | AOP 示例             | [README.md](mingsha-spring-boot-examples/mingsha-aop-spring-boot-example/README.md) |
|                  | mingsha-ldap-spring-boot-example          | LDAP 示例            | [README.md](mingsha-spring-boot-examples/mingsha-ldap-spring-boot-example/README.md) |
|                  | mingsha-zookeeper-spring-boot-example     | Zookeeper 示例       | [README.md](mingsha-spring-boot-examples/mingsha-zookeeper-spring-boot-example/README.md) |
|                  | mingsha-websocket-spring-boot-example     | WebSocket 示例       | [README.md](mingsha-spring-boot-examples/mingsha-websocket-spring-boot-example/README.md) |
|                  | mingsha-tomcat-spring-boot-example        | Tomcat 示例          | [README.md](mingsha-spring-boot-examples/mingsha-tomcat-spring-boot-example/README.md) |
|                  | mingsha-shardingsphere-spring-boot-example| 分库分表示例         | [README.md](mingsha-spring-boot-examples/mingsha-shardingsphere-spring-boot-example/README.md) |
|                  | mingsha-rocketmq-spring-boot-example      | RocketMQ 示例        | [README.md](mingsha-spring-boot-examples/mingsha-rocketmq-spring-boot-example/README.md) |
|                  | mingsha-redis-spring-boot-example         | Redis 示例           | [README.md](mingsha-spring-boot-examples/mingsha-redis-spring-boot-example/README.md) |
|                  | mingsha-rabbitmq-spring-boot-example      | RabbitMQ 示例        | [README.md](mingsha-spring-boot-examples/mingsha-rabbitmq-spring-boot-example/README.md) |
|                  | mingsha-mail-spring-boot-example          | 邮件发送示例         | [README.md](mingsha-spring-boot-examples/mingsha-mail-spring-boot-example/README.md) |
|                  | mingsha-logging-spring-boot-example       | 日志增强示例         | [README.md](mingsha-spring-boot-examples/mingsha-logging-spring-boot-example/README.md) |
|                  | mingsha-elasticsearch-spring-boot-example | Elasticsearch 示例   | [README.md](mingsha-spring-boot-examples/mingsha-elasticsearch-spring-boot-example/README.md) |
|                  | mingsha-caffeine-spring-boot-example      | Caffeine 示例        | [README.md](mingsha-spring-boot-examples/mingsha-caffeine-spring-boot-example/README.md) |
|                  | mingsha-actuator-spring-boot-example      | 监控与健康检查示例   | [README.md](mingsha-spring-boot-examples/mingsha-actuator-spring-boot-example/README.md) |
|                  | mingsha-druid-spring-boot-example         | Druid 示例           | [README.md](mingsha-spring-boot-examples/mingsha-druid-spring-boot-example/README.md) |


---

## 项目简介

Mingsha Spring Boot Project 致力于为企业级 Java 应用提供一站式、模块化、开箱即用的 Spring Boot 扩展能力。涵盖数据库、缓存、消息、搜索、监控、AOP、Web、日志、测试等主流场景，全部模块均支持自动配置、可插拔、易集成，助力开发者高效构建高质量微服务系统。

---

## 项目结构

```
mingsha-spring-boot-project/
├── mingsha-spring-boot/                    # 主源码聚合
│   ├── mingsha-spring-boot-starters/       # 各类 starter 启动器
│   ├── mingsha-spring-boot-autoconfigures/ # 各类自动配置
│   ├── mingsha-spring-boot-parent/         # 统一 parent
│   └── mingsha-spring-boot-dependencies/   # BOM 依赖管理
├── mingsha-spring-boot-examples/           # 各类场景示例
├── pom.xml                                 # Maven 对象模型
├── bin/                                    # 脚本工具
├── config/                                 # 代码规范等配置
├── Makefile                                # 一键构建/测试/格式化
├── Jenkinsfile                             # pipeline 4 Build
├── Jenkinsfile.sonar                       # pipeline 4 SonarQube
└── README.md                               # 项目说明
```

---

## 环境要求

- JDK 17 及以上
- Maven 3.6 及以上
- Spring Boot 3.5.x
- 推荐使用 Linux/macOS/WSL 环境

---

## 快速开始

1. **克隆项目**
   ```bash
   git clone <your-repo-url>
   cd mingsha-spring-boot-project
   ```

2. **一键构建**
   ```bash
   make build
   ```

3. **运行测试**
   ```bash
   make test
   ```

4. **代码格式化**
   ```bash
   make format
   ```

5. **生成元数据**
   ```bash
   make metadata
   ```

6. **更多命令**
   ```bash
   make help
   ```

---

## 使用介绍

以 MySQL Starter 为例，其他 Starter 用法类似：

1. **引入 BOM 依赖管理**（在你的 Spring Boot 项目的 pom.xml 中）
   ```xml
   <dependencyManagement>
     <dependencies>
       <dependency>
         <groupId>site.mingsha.boot</groupId>
         <artifactId>mingsha-spring-boot-dependencies</artifactId>
         <version>1.0.0</version>
         <type>pom</type>
         <scope>import</scope>
       </dependency>
     </dependencies>
   </dependencyManagement>
   ```

2. **添加具体 Starter 依赖**
   ```xml
   <dependency>
     <groupId>site.mingsha.boot</groupId>
     <artifactId>mingsha-mysql-spring-boot-starter</artifactId>
   </dependency>
   ```

3. **配置属性**（application.yml 示例）
   ```yaml
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/yourdb
       username: root
       password: yourpassword
   ```

4. **自动装配与使用**
   - 启动类无需特殊注解，Spring Boot 会自动装配相关 Bean。
   - 直接注入 DataSource、JdbcTemplate、Repository 等即可使用。

5. **更多用法**
   - 详见各 Starter/Example 子模块的 README.md，包含详细配置、API、进阶用法和测试示例。

---

## 许可证

本项目采用 MIT License，详见 [LICENSE](./LICENSE)。
