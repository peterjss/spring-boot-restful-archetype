# spring-boot-restful-blank

[![jdk](https://img.shields.io/badge/jdk-8u181-green.svg)](https://www.oracle.com/technetwork/java/index.html)
[![spring-cloud](https://img.shields.io/badge/spring--cloud-Finchley.SR1-green.svg)](https://projects.spring.io/spring-cloud/)
[![spring-io](https://img.shields.io/badge/spring--io-Cairo--SR4-green.svg)](http://platform.spring.io/platform/)

App目录结构:
* parent
  - pom.xml
* server
  - src/main/java/${package}/server/
    - config
    - dao
    - entity
    - dto
    - service
    - openapi
    - utils
  - src/main/resource


Install：
maven环境

1.在项目根目录下运行：

```
mvn archetype:create-from-project
```
2.切换到target/generated-sources/archetype/下,运行下面命令进行打包

```
mvn install
```
3.根据archetype创建项目

```
mvn archetype:generate -DarchetypeCatalog=local
```

选择项目此模板即可。
