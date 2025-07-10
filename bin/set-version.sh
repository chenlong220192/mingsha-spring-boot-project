#! /bin/bash

#======================================================================
#
# author: mingsha
# date: 2025-07-10
#======================================================================

# bin目录绝对路径
BIN_PATH=$(cd `dirname $0`; pwd)
# 进入bin目录
cd `dirname $0`
# 返回到上一级项目根目录路径
cd ..
# `pwd` 执行系统命令并获得结果
BASE_PATH=`pwd`

NEW_VERSION=$1

if [ -z "$NEW_VERSION" ]; then
    echo "Error: Please provide a version number"
    echo "Usage: $0 <version>"
    echo "Example: $0 1.0.0"
    exit 1
fi

echo "Setting project to new version: ${NEW_VERSION}"

# 更新根目录 pom.xml 中的 revision
echo "Updating root pom.xml..."
cat ${BASE_PATH}/pom.xml\
    | sed "s/<revision>[^<]*<\/revision>/<revision>${NEW_VERSION}<\/revision>/1" > ${BASE_PATH}/pom.xml.newVersion\
    && mv ${BASE_PATH}/pom.xml.newVersion ${BASE_PATH}/pom.xml

# 更新父模块 pom.xml 中的 revision
echo "Updating parent pom.xml..."
PARENT_POM_PATH="${BASE_PATH}/mingsha-spring-boot/mingsha-spring-boot-parent/pom.xml"
if [ -f "$PARENT_POM_PATH" ]; then
    cat ${PARENT_POM_PATH}\
        | sed "s/<revision>[^<]*<\/revision>/<revision>${NEW_VERSION}<\/revision>/1" > ${PARENT_POM_PATH}.newVersion\
        && mv ${PARENT_POM_PATH}.newVersion ${PARENT_POM_PATH}
    echo "Parent pom.xml updated successfully"
else
    echo "Warning: Parent pom.xml not found at ${PARENT_POM_PATH}"
fi

echo "Version update completed. NEW_VERSION: ${NEW_VERSION}"
echo "Please run 'mvn clean install' to rebuild the project with the new version"
