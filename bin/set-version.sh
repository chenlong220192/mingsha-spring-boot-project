#! /bin/shell

#======================================================================
# mvn package script
# default local profile
#
# author: chenlong
# date: 2020-06-03
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

echo "set project to new version: ${NEW_VERSION}"

cat ${BASE_PATH}/pom.xml\
    | sed "s/<revision>[^<]*<\/revision>/<revision>${NEW_VERSION}<\/revision>/1" > ${BASE_PATH}/pom.xml.newVersion\
    && mv ${BASE_PATH}/pom.xml.newVersion ${BASE_PATH}/pom.xml

echo "set project to new version Done. NEW_VERSION: ${NEW_VERSION}"
