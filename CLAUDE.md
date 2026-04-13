# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Mingsha Spring Boot Project is a multi-module Maven library providing pluggable Spring Boot 4.0 auto-configuration starters for enterprise Java applications. Each starter wraps a third-party library with Spring Boot auto-configuration so consumers only need to add a starter dependency and configure `application.yml` — no Java config required.

## Build Commands

Uses Maven wrapper (`./mvnw`) with a Makefile wrapper:

```bash
make build          # Clean install (includes tests)
make test           # Run unit tests only
make format         # Apply Spring Java formatting
make checkstyle     # Run checkstyle (enforced on every install)
make metadata       # Generate spring-configuration-metadata.json
make clean          # Clean build artifacts
make verify         # Full Maven verify (clean + all checks)
make install        # Install to local Maven repo
make package        # Package (skip tests)

# Parallel build (faster on multi-core):
make build MAVEN_THREADS=4

# Skip tests:
make build SKIP_TEST=true
```

**Prerequisites:** JDK 17+ required (Spring Boot 4.0), Maven 3.6+, `mingsha-kernel` must be pre-installed in the local Maven repo before building this project.

**Single test:** Use `-Dtest=ClassName#methodName` via Maven directly:
```bash
./mvnw test -pl module/path -Dtest=MyTest
```

## Architecture

### Module Hierarchy

```
mingsha-spring-boot-project/
├── mingsha-spring-boot/               # All library source code
│   ├── mingsha-spring-boot-parent/    # Unified parent POM (plugin versions, resource filtering)
│   ├── mingsha-spring-boot-dependencies/ # BOM (all dependency versions)
│   ├── mingsha-spring-boot-starters/ # One thin starter per technology
│   └── mingsha-spring-boot-autoconfigures/ # One autoconfig per technology
└── mingsha-spring-boot-examples/      # Working example applications
```

### Starter Pattern

Every feature follows a two-layer pattern:

1. **`mingsha-*-spring-boot-starter`** (thin): Declares dependencies on the Spring Boot starter for the library plus the `mingsha-*-spring-boot-autoconfigure` module. Contains no Java source.

2. **`mingsha-*-spring-boot-autoconfigure`** (real code): Contains the `@Configuration` class, `*Properties` class, and `META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports` file. Java source lives under `site.mingsha.boot.starter.*`.

Example — Redis:
- Starter: `mingsha-spring-boot/mingsha-spring-boot-starters/mingsha-redis-spring-boot-starter/pom.xml` — just 3 deps
- Autoconfig: `mingsha-spring-boot/mingsha-spring-boot-autoconfigures/mingsha-redis-spring-boot-autoconfigure/src/main/java/site/mingsha/boot/starter/redis/autoconfigure/`

### Version Management

All versions are centralized in `mingsha-spring-boot/mingsha-spring-boot-dependencies/pom.xml` under `<properties>`. Starter and autoconfig POMs reference versions from there via the BOM imported in `mingsha-spring-boot-parent`.

To bump all versions consistently, use:
```bash
make set-version NEW_VERSION=x.y.z
```
which runs `bin/set-version.sh`.

### Checkstyle

Rules are in `config/checkstyle.xml`. Key conventions enforced:
- Max line length: 240 chars
- 4-space indent, tabWidth=4
- `AvoidStarImport`, `MagicNumber` (allows -1, 0, 1, 2)
- `ImportOrder`: java, javax, org, com (separated groups)
- Javadoc required on types, methods, and fields

### CI/CD

- `Jenkinsfile` — builds, archives JARs, sends email on success/failure
- `Jenkinsfile.sonar` — SonarQube analysis pipeline
- Jenkins uses `jdk17` tool, runs `./mvnw clean package -DskipTests`

## Key Patterns

- `*Properties` classes are annotated with `@ConfigurationProperties` and enabled via `@EnableConfigurationProperties` in the auto-config class.
- Auto-config classes are registered via `META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports` (Spring Boot 3.x+ convention, not `spring.factories`).
- All example modules are under `mingsha-spring-boot-examples/` and each is a standalone runnable Spring Boot app.

## Migration Notes (Spring Boot 3.x → 4.x)

This project is actively being upgraded to Spring Boot 4.0. The `docs/UPGRADE.md` tracks the migration progress and known breaking changes (primarily `javax.*` → `jakarta.*`).
