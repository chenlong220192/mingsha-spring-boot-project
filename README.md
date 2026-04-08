# Mingsha Spring Boot Project

> One-stop, modular, and ready-to-use Spring Boot extensions for enterprise-level Java applications.

[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0-green.svg)](https://spring.io/projects/spring-boot)

## Overview

Mingsha Spring Boot Project provides comprehensive Spring Boot extensions for enterprise applications. It covers databases, caching, messaging, search, monitoring, AOP, web, logging, testing, and other mainstream scenarios. All modules support auto-configuration and are pluggable.

## Modules

### Starters

| Module | Description |
|--------|-------------|
| mingsha-mysql-spring-boot-starter | MySQL starter |
| mingsha-druid-spring-boot-starter | Druid connection pool starter |
| mingsha-postgresql-spring-boot-starter | PostgreSQL starter |
| mingsha-mongodb-spring-boot-starter | MongoDB starter |
| mingsha-redis-spring-boot-starter | Redis starter |
| mingsha-kafka-spring-boot-starter | Kafka starter |
| mingsha-rabbitmq-spring-boot-starter | RabbitMQ starter |
| mingsha-rocketmq-spring-boot-starter | RocketMQ starter |
| mingsha-solr-spring-boot-starter | Solr starter |
| mingsha-elasticsearch-spring-boot-starter | Elasticsearch starter |
| mingsha-ldap-spring-boot-starter | LDAP starter |
| mingsha-web-spring-boot-starter | Web capabilities starter |
| mingsha-websocket-spring-boot-starter | WebSocket starter |
| mingsha-aop-spring-boot-starter | AOP starter |
| mingsha-tomcat-spring-boot-starter | Embedded Tomcat starter |
| mingsha-caffeine-spring-boot-starter | Caffeine cache starter |
| mingsha-actuator-spring-boot-starter | Actuator & health check starter |
| mingsha-test-spring-boot-starter | Testing utilities starter |
| mingsha-shardingsphere-spring-boot-starter | Database sharding starter |
| mingsha-logging-spring-boot-starter | Logging enhancement starter |
| mingsha-spring-boot-starter | Base starter |

### Autoconfigures

All starters have corresponding autoconfigures for fine-grained control.

### Examples

Working examples for each module demonstrating real-world usage.

---

## Project Structure

```
mingsha-spring-boot-project/
├── mingsha-spring-boot/                    # Main source aggregation
│   ├── mingsha-spring-boot-starters/       # Starters
│   ├── mingsha-spring-boot-autoconfigures/ # Auto-configurations
│   ├── mingsha-spring-boot-parent/         # Unified parent POM
│   └── mingsha-spring-boot-dependencies/   # BOM dependency management
├── mingsha-spring-boot-examples/           # Usage examples
├── pom.xml                                 # Maven POM
├── bin/                                    # Scripts
├── config/                                 # Code standards config
├── Makefile                                # Build/test/format
├── Jenkinsfile                             # CI/CD pipeline
└── Jenkinsfile.sonar                      # SonarQube pipeline
```

---

## Requirements

- JDK 17 or higher (for Spring Boot 4.x)
- Maven 3.6+
- Linux/macOS/WSL recommended

---

## Quick Start

### Build

```bash
# Build all modules
make build

# Run tests
make test

# Format code
make format

# Generate metadata
make metadata

# Show all commands
make help
```

### Usage

1. **Add BOM to your pom.xml**
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

2. **Add Starter dependency**
```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-mysql-spring-boot-starter</artifactId>
</dependency>
```

3. **Configure application**
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/yourdb
    username: root
    password: yourpassword
```

4. **Auto-configuration**
   - No special annotations needed
   - Spring Boot auto-configures beans automatically
   - Just inject DataSource, JdbcTemplate, Repository, etc.

---

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Ensure code passes all tests
5. Submit a Pull Request

---

## License

This project is licensed under MIT License. See [LICENSE](./LICENSE).

---

## ⚠️ Migration Notes (Spring Boot 3.x → 4.x)

This project is being upgraded to Spring Boot 4.0.

Breaking changes include:
- **Jakarta EE migration** (javax.* → jakarta.*)
- **Spring Security 6.x changes**
- **Spring Data changes**
- **Third-party library compatibility**

Full compatibility is a work in progress.
