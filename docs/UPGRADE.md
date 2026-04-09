# 升级文档 (2026.04.09)

## 版本信息
- **版本号**: 2026.04.09-01
- **升级日期**: 2026-04-09
- **升级内容**: Spring Boot 4.0.5 及所有依赖升级到最新

## 主要升级

### Spring Boot 4.0.5
- **旧版本**: 3.5.11
- **新版本**: 4.0.5
- **重大变化**: Spring Boot 4.0 是重大版本升级，需要注意 API 变化

## 升级的依赖

### 核心框架
| 依赖项 | 旧版本 | 新版本 |
|--------|--------|--------|
| Spring Boot | 3.5.11 | 4.0.5 |
| mingsha-kernel | 2026.04.09-01 | 2026.04.09-01 |

### 数据库相关
| 依赖项 | 旧版本 | 新版本 |
|--------|--------|--------|
| Druid | 1.2.24 | 1.2.25 |
| ShardingSphere | 5.4.1 | 5.5.1 |

### 分布式协调
| 依赖项 | 旧版本 | 新版本 |
|--------|--------|--------|
| Curator | 5.8.0 | 5.9.0 |

### 搜索引擎
| 依赖项 | 旧版本 | 新版本 |
|--------|--------|--------|
| Elasticsearch | 8.13.0 | 8.17.5 |

### 监控
| 依赖项 | 旧版本 | 新版本 |
|--------|--------|--------|
| Micrometer | 1.12.5 | 1.13.2 |
| Micrometer Prometheus | 1.12.5 | 1.13.2 |

### 日志
| 依赖项 | 旧版本 | 新版本 |
|--------|--------|--------|
| Logback | 1.4.14 | 1.5.16 |
| SLF4J | 2.0.13 | 2.0.16 |

### JSON 处理
| 依赖项 | 旧版本 | 新版本 |
|--------|--------|--------|
| Jackson | 2.17.1 | 2.18.2 |
| Fastjson2 | 2.0.49 | 2.0.52 |

### 工具类
| 依赖项 | 旧版本 | 新版本 |
|--------|--------|--------|
| Commons Lang3 | 3.14.0 | 3.17.0 |
| Commons IO | 2.15.1 | 2.16.1 |
| Guava | 33.2.0-jre | 33.4.0-jre |

### 验证
| 依赖项 | 旧版本 | 新版本 |
|--------|--------|--------|
| Hibernate Validator | 8.0.1.Final | 8.0.2.Final |

## Spring Boot 4.0 迁移注意事项

### Java 版本要求
- Spring Boot 4.0 需要 **Java 17** 或更高版本

### 主要变更
1. Jakarta EE 9+ 支持
2. 新的日志系统集成
3. 性能优化和 GraalVM 原生支持改进

### 升级步骤

```bash
# 1. 更新代码
git pull origin develop

# 2. 先安装 mingsha-kernel
cd ../mingsha-kernel
mvn clean install -DskipTests

# 3. 编译当前项目
cd ../mingsha-spring-boot-project
mvn clean compile -DskipTests

# 4. 运行测试
mvn test
```

### 回滚方案

如需回滚到之前版本：

```bash
git revert <commit-hash>
```

## 测试验证
- [x] 项目编译通过
- [x] 依赖冲突检查通过
- [ ] 单元测试通过
- [ ] 集成测试通过

## 相关链接

- [Spring Boot 4.0 官方文档](https://spring.io/projects/spring-boot)
- [GitHub 仓库](https://github.com/chenlong220192/mingsha-spring-boot-project)
