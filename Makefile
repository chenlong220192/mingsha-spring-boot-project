# Mingsha Spring Boot Project Makefile
# 推荐用法：make help 查看所有命令

SHELL := /bin/bash -o pipefail
export BASE_PATH := $(shell dirname $(realpath $(lastword $(MAKEFILE_LIST))))

SKIP_TEST ?= false
NEW_VERSION ?= 1.0.0
MAVEN_THREADS ?= 1
MAVEN_OPTS ?= -Xmx1g -XX:MaxPermSize=256m

# 彩色输出变量
GREEN  := \033[32m
RED    := \033[31m
YELLOW := \033[33m
BLUE   := \033[34m
RESET  := \033[0m

.PHONY: help all clean compile test package install verify deploy set-version checkstyle format dependency-tree metadata

help:
	@echo -e "$(BLUE)Mingsha Spring Boot Project - Makefile 命令一览$(RESET)"
	@echo -e "  $(YELLOW)make build$(RESET)           # 构建（含测试）"
	@echo -e "  $(YELLOW)make test$(RESET)            # 仅运行测试"
	@echo -e "  $(YELLOW)make format$(RESET)          # 代码格式化"
	@echo -e "  $(YELLOW)make metadata$(RESET)        # 生成 spring-configuration-metadata.json"
	@echo -e "  $(YELLOW)make clean$(RESET)           # 清理"
	@echo -e "  $(YELLOW)make checkstyle$(RESET)      # 代码风格检查"
	@echo -e "  $(YELLOW)make dependency-tree$(RESET) # 依赖树"
	@echo -e "  $(YELLOW)make set-version NEW_VERSION=1.2.3$(RESET) # 设定版本"
	@echo -e "  $(YELLOW)make deploy$(RESET)          # 发布到远程仓库"
	@echo -e "  $(YELLOW)make verify$(RESET)          # 全量校验"
	@echo -e "  $(YELLOW)make install$(RESET)         # 安装到本地仓库"
	@echo -e "  $(YELLOW)make package$(RESET)         # 打包"
	@echo -e "参数：SKIP_TEST=true/false MAVEN_THREADS=4"

all: build

build:
	@echo -e "$(BLUE)🚀 开始构建...$(RESET)"
	$(BASE_PATH)/mvnw --batch-mode --errors -f ${BASE_PATH}/pom.xml clean install -D maven.test.skip=$(SKIP_TEST) -T $(MAVEN_THREADS)
	@if [ $$? -eq 0 ]; then \
		echo -e "$(GREEN)✔ 构建成功$(RESET)"; \
	else \
		echo -e "$(RED)✖ 构建失败$(RESET)"; \
	fi

test:
	@echo -e "$(BLUE)🧪 运行测试...$(RESET)"
	$(BASE_PATH)/mvnw --batch-mode --errors -f ${BASE_PATH}/pom.xml test -T $(MAVEN_THREADS)
	@if [ $$? -eq 0 ]; then \
		echo -e "$(GREEN)✔ 测试通过$(RESET)"; \
	else \
		echo -e "$(RED)✖ 测试失败$(RESET)"; \
	fi

format:
	@echo -e "$(BLUE)🎨 代码格式化...$(RESET)"
	$(BASE_PATH)/mvnw --batch-mode --errors -f ${BASE_PATH}/pom.xml spring-javaformat:apply
	@if [ $$? -eq 0 ]; then \
		echo -e "$(GREEN)✔ 格式化完成$(RESET)"; \
	else \
		echo -e "$(RED)✖ 格式化失败$(RESET)"; \
	fi

metadata:
	@echo -e "$(BLUE)📦 生成元数据...$(RESET)"
	$(BASE_PATH)/mvnw --batch-mode --errors -f ${BASE_PATH}/pom.xml process-classes
	@if [ $$? -eq 0 ]; then \
		echo -e "$(GREEN)✔ 元数据生成完成$(RESET)"; \
	else \
		echo -e "$(RED)✖ 元数据生成失败$(RESET)"; \
	fi

clean:
	@echo -e "$(BLUE)🧹 清理项目...$(RESET)"
	$(BASE_PATH)/mvnw --batch-mode --errors -f ${BASE_PATH}/pom.xml clean
	@if [ $$? -eq 0 ]; then \
		echo -e "$(GREEN)✔ 清理完成$(RESET)"; \
	else \
		echo -e "$(RED)✖ 清理失败$(RESET)"; \
	fi

checkstyle:
	@echo -e "$(BLUE)🔍 代码风格检查...$(RESET)"
	$(BASE_PATH)/mvnw --batch-mode --errors -f ${BASE_PATH}/pom.xml checkstyle:check
	@if [ $$? -eq 0 ]; then \
		echo -e "$(GREEN)✔ 检查通过$(RESET)"; \
	else \
		echo -e "$(RED)✖ 检查未通过$(RESET)"; \
	fi

dependency-tree:
	@echo -e "$(BLUE)🌳 生成依赖树...$(RESET)"
	$(BASE_PATH)/mvnw --batch-mode -f ${BASE_PATH}/pom.xml dependency:tree
	@echo -e "$(GREEN)✔ 依赖树生成完成$(RESET)"

set-version:
	@echo -e "$(YELLOW)📝 设置项目版本为: $(NEW_VERSION)$(RESET)"
	sh ${BASE_PATH}/bin/set-version.sh $(NEW_VERSION)
	@echo -e "$(GREEN)✔ 版本设置完成$(RESET)"

package:
	@echo -e "$(BLUE)📦 打包项目...$(RESET)"
	$(BASE_PATH)/mvnw --batch-mode --errors -f ${BASE_PATH}/pom.xml clean package -D maven.test.skip=$(SKIP_TEST) -T $(MAVEN_THREADS)
	@if [ $$? -eq 0 ]; then \
		echo -e "$(GREEN)✔ 打包完成$(RESET)"; \
	else \
		echo -e "$(RED)✖ 打包失败$(RESET)"; \
	fi

install:
	@echo -e "$(BLUE)📥 安装到本地仓库...$(RESET)"
	$(BASE_PATH)/mvnw --batch-mode --errors -f ${BASE_PATH}/pom.xml clean install -D maven.test.skip=$(SKIP_TEST) -T $(MAVEN_THREADS)
	@if [ $$? -eq 0 ]; then \
		echo -e "$(GREEN)✔ 安装完成$(RESET)"; \
	else \
		echo -e "$(RED)✖ 安装失败$(RESET)"; \
	fi

verify:
	@echo -e "$(BLUE)🔎 全量校验...$(RESET)"
	$(BASE_PATH)/mvnw --batch-mode --errors -f ${BASE_PATH}/pom.xml clean verify -T $(MAVEN_THREADS)
	@if [ $$? -eq 0 ]; then \
		echo -e "$(GREEN)✔ 校验通过$(RESET)"; \
	else \
		echo -e "$(RED)✖ 校验失败$(RESET)"; \
	fi

deploy:
	@echo -e "$(BLUE)🚀 发布到远程仓库...$(RESET)"
	$(BASE_PATH)/mvnw --batch-mode --errors -f ${BASE_PATH}/pom.xml deploy -T $(MAVEN_THREADS)
	@if [ $$? -eq 0 ]; then \
		echo -e "$(GREEN)✔ 发布完成$(RESET)"; \
	else \
		echo -e "$(RED)✖ 发布失败$(RESET)"; \
	fi
