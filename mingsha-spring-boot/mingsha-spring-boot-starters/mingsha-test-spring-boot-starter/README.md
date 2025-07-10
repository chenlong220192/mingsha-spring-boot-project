# Mingsha Test Spring Boot Starter

## 简介

Mingsha Test Spring Boot Starter 提供了 Spring Boot 项目的测试支持，集成常用测试依赖和工具，简化单元测试和集成测试开发。

## 功能特性

- 集成 JUnit 5、Spring Boot Test
- 支持 MockMvc、RestAssured 等测试工具
- 支持数据库测试、MockBean、测试配置隔离
- 完整的配置元数据支持

## 技术栈

- Spring Boot 3.x
- JUnit 5
- Mockito
- MockMvc
- JDK 17+
- Maven 3.6+

## 快速开始

### 1. 添加依赖

```xml
<dependency>
    <groupId>site.mingsha.boot</groupId>
    <artifactId>mingsha-test-spring-boot-starter</artifactId>
    <scope>test</scope>
</dependency>
```

### 2. 配置

无需特殊配置，Spring Boot 自动集成。

## 用法示例

```java
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class DemoTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHome() throws Exception {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk());
    }
}
```

## 配置说明

无需特殊配置。

## API接口

- 通过 MockMvc、RestAssured 等进行接口测试

## 代码结构

```
mingsha-test-spring-boot-starter/
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