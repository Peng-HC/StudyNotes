# IDEA-tomcat-maven环境配置

说明：

1. `JDK`版本： `16.0.2`
2. `IDEA`版本： `2021.3.3`
3. `tomcat`版本：`10.0.27`
4. `maven`版本： `3.6.3`

---

## 一、IDEA安装教程

> 1. 教程：[IntelliJ IDEA安装教程（超详细）](https://lddwarehouse.blog.csdn.net/article/details/121928344?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2~default~CTRLIST~PayColumn-1-121928344-blog-115612756.pc_relevant_3mothn_strategy_recovery&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2~default~CTRLIST~PayColumn-1-121928344-blog-115612756.pc_relevant_3mothn_strategy_recovery&utm_relevant_index=1)
> 2. `JDK`安装：`D:\Java\jdk-16.0.2`
> 3. `IDEA`安装：`D:\Java\IntelliJ IDEA_2021.3.3`
>
> 后期的Java程序我将使用`IDEA`编译器

## 二、tomcat下载与配置

### 2.1 安装tomcat

1. 下载官网：https://tomcat.apache.org/

   ![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\tomcat10.0.27_windows版本下载.png)

2. 解压

   ![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\解压.png)

3. tomcat启动和配置

   （1）文件夹作用：

   ![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\tomcat文件夹内文件作用.png)

   （2）**启动，关闭tomcat**

   ![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\tomcat配置\启动_关闭tomcat.png)

   （3）访问测试：http://localhost:8080/

   * 本地访问

   ![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\tomcat启动页面.png)

   * 远程服务器安装版本（9.0.62）

   ![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\远程服务器安装版本.png)

   可能遇到的问题：

   > 1. java环境变量没有配置
   > 2. 闪退问题：需要配置兼容性
   > 3. 乱码问题：配置文件中设置

### 2.2 tomcat配置

![服务器核心配置文件](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\tomcat配置\服务器核心配置文件.png)

可以配置启动的端口号

- tomcat的默认端口为：8080
- mysql默认端口：3306
- http默认端口：80
- https默认端口：443

可以配置主机的名称

- 默认的主机名为：localhost — 127.0.0.1
- 默认网站应用存放的位置为webapps

```bash
<Host name="localhost"  appBase="webapps" unpackWARs="true" autoDeploy="true">
```

### 2.3 发布一个web网站

> 1. 将自己写的网站，放到服务器（tomcat）中指定的web应用的文件夹（webapps）下
>
>    ![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\我的网站1.png)
>
>    ![我的网站2](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\我的网站2.png)
>
> 2. 打开网站进行访问
>
>    ```bash
>    localhost:8080/phc/
>    ```
>
>    ![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\我的网站3.png)
>
> 3. 网站应该有的结构
>
>    ```
>    webapps : tomcat服务器的web目录
>    	--ROOT
>    	--phc : 网站的目录名
>    		--WEB-INF : 网站的配置文件夹
>    			--classes : java程序
>    			--lib ： web应用所依赖的jar包
>    			--web.xml ： 网站配置文件
>    		--index.html ： 默认的首页
>    		--static
>    			--css
>    				--style.css
>    			--js
>    			--img
>    ```

## 三、maven环境搭建

我们为什么要学习这个技术？

1. 在javaweb开发中，需要使用大量的jar，我们手动去导入

2. 如何能够让一个东西自动帮我导入和配置这个jar包

   由此，Maven诞生了！

### 3.1 Maven项目架构管理工具

作用：就是方便导入jar包的

Maven的核心思想：**约定大于配置**（即有约束，不要去违反）

Maven会规定好你该如何取编写我们的java代码，必须要按照这个规范来。

### 3.2 下载安装Maven

官网：https://maven.apache.org/

**[请注意IDEA编译器与Maven版本匹配问题](https://libin9ioak.blog.csdn.net/article/details/117571120?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2~default~CTRLIST~Rate-1-117571120-blog-124024228.pc_relevant_3mothn_strategy_recovery&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2~default~CTRLIST~Rate-1-117571120-blog-124024228.pc_relevant_3mothn_strategy_recovery&utm_relevant_index=2)**

我的IDEA版本为：2021.3.3，兼容`maven 3.8.1`及之前的所用版本。这里我选择下载兼容性很强的**`maven 3.6.3`**

1. 下载

   [maven-3.6.3下载地址](https://archive.apache.org/dist/maven/maven-3/3.6.3/binaries/)

   ![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\maven下载安装与配置\maven3.6.3下载.png)

   下载完成后，解压即可。这里我将`apache-maven-3.6.3`放在了`D:\Environment`文件夹下

   ![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\maven下载安装与配置\解压地址.png)

   友情建议：电脑上的所有环境都放到一个文件夹下，方便管理

### 3.3 maven环境变量配置

在我们的系统环境变量中

配置如下配置：

- M2_HOME：maven目录下的bin目录（后续学习springboot需要用到）

  ```bash
  D:\Environment\apache-maven-3.6.3\bin
  ```

- MAVEN_HOME：maven的目录

  ```bash
  D:\Environment\apache-maven-3.6.3
  ```

  ![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\maven下载安装与配置\系统环境变量.png)

- 在系统的Path中配置 `%MAVEN_HOME%\bin`

  ![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\maven下载安装与配置\Path变量.png)

* maven环境配置成功的标志

  打开cmd，进入命令行，输入`mvn -version`

  ![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\maven下载安装与配置\查看mvn版本.png)

### 3.4 修改`settings.xml`配置文件

文件所在位置：`apache-maven-3.6.3\conf\settings.xml`

> 1. 修改镜像源
>
>    ```xml
>    <mirror>
>        <id>nexus-aliyun</id>
>        <mirrorOf>*,!jeecg,!jeecg-snapshots</mirrorOf>
>        <name>Nexus aliyun</name>
>        <url>http://maven.aliyun.com/nexus/content/groups/public</url> 
>    </mirror>
>    ```
>
>    ![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\maven下载安装与配置\修改阿里镜像源.png)
>
> 2. 创建并修改本地仓库存放位置
>
>    （1）在`apache-maven-3.6.3`文件夹下创建本地仓库`maven-repo`
>
>    ![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\maven下载安装与配置\创建本地仓库maven-repo.png)
>
>    （2）修改`settings.xml`文件的仓库地址
>
>    ```xml
>    <localRepository>D:\Environment\apache-maven-3.6.3\maven-repo</localRepository>
>    ```
>
>    ![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\maven下载安装与配置\修改本地仓库默认地址.png)

## 四、在IDEA中使用maven

说明：

（1）IDEA版本：2021.3.3

（2）maven版本：3.6.3

### 4.1 启动IDEA

### 4.2 使用webapp模板创建一个`maven`项目

![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用maven\1.png)

![2](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用maven\2.png)

![3](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用maven\3.png)

  ![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用maven\4.png)

### 4.3 等待项目初始化完毕

等待一段时间，idea正在自动构建项目

![5](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用maven\5.png)

此时可以看到本地仓库`D:\Environment\apache-maven-3.6.3\maven-repo`多了很多文件夹

![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用maven\maven-repo多了很多文件夹.png)

### 4.4 IDEA中的maven设置

IDEA项目创建成功后，看一眼Maven的配置。进入IDEA的`File>Settings`查看maven设置

![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用maven\6.png)

![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用maven\7.png)

![8](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用maven\8.png)

### 4.5 设置新项目的全局配置

若构建maven项目时出现错误提示：`Cannot resolve plugin org.apache.maven.plugins:maven-clean-plugin:2.5 `，则采取 [本步骤 设置新项目的全局配置]可以解决问题

**注：这一步骤可能需要提前到 [7.2 创建一个maven项目] 之前**

![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用maven\设置新项目的全局配置.png)

![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用maven\新项目创建的全局设置.png)

### 4.6 使用webapp模板配置后生成的目录结构

![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用maven\使用webapp模板配置后生成的目录结构.png)

### 4.7 不使用模板创建一个普通的`maven`项目

![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用maven\2-1.png)

![2-2](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用maven\2-2.png)

### 4.8 不使用模板配置后生成的目录结构（干净的maven文件）

![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用maven\2-3.png)

### 4.9 在`main`文件夹下为webapp模板文件新建文件夹

1. 新建java文件夹

2. 新建resources文件夹

   ![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用maven\2-4.png)

注：src文件夹下的test文件夹可以稍后用到再创建，影响不大

## 五、在IDEA中配置tomcat

说明：

（1）IDEA版本：2021.3.3

（2）tomcat版本：10.0.27

### 5.1 添加项目配置选项

![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用tomcat\1.png)

### 5.2 选择本地tomcat服务器

![2](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用tomcat\2.png)

### 5.3 配置本地tomcat服务器

![3](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用tomcat\3.png)

为什么会有这个警告问题：我们访问一个网站，需要指定一个文件夹的路径，比如`localhost:8080/javaweb_01_maven_war`

### 5.4 添加一个artifact

![4](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用tomcat\4.png)

### 5.5 对artifact配置的一些解释

1. 可以写，也可以不写。
2. 如果不写的话默认访向路径为localhost:8080
3. 假如写了一个/javaweb_01_maven_war，则访问路径为：localhost:8080/javaweb_01_maven_war
4. 这个过程叫做:虚拟路径映射

![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用tomcat\5.png)

### 5.6 启动tomcat服务器

![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用tomcat\6.png)

### 5.7 POM文件讲解

pom.xml是maven的**核心配置文件**

![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用tomcat\7.png)

POM代码

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!--maven版本和头文件-->
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <!--这里就是我们配置的groupId,artifactId和version信息-->
  <groupId>com.phc</groupId>
  <artifactId>javaweb-01-maven</artifactId>
  <version>1.0-SNAPSHOT</version>
  <!--packaging  项目的方法方式
    jar:jar应用
    war:javaWeb应用
  -->
  <packaging>war</packaging>

  <name>javaweb-01-maven Maven Webapp</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>

  <!--配置-->
  <properties>
    <!--项目的默认构建编码-->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <!--编码版本-->
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>

  <!--项目依赖-->
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <!--项目构建用的东西-->
  <build>
    <finalName>javaweb-01-maven</finalName>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-war-plugin</artifactId>
          <version>3.2.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
      </plugins>
    </pluginManagement>

    <!--在build中配置resources,来防止我们资源导出失败的问题-->
    <resources>
      <resource>
        <directory>src/main/resources</directory>
        <includes>
          <include>**/*.properties</include>
          <include>**/*.xml</include>
        </includes>
        <filtering>false</filtering>
      </resource>
      <resource>
        <directory>src/main/java</directory>
        <includes>
          <include>**/*.properties</include>
          <include>**/*.xml</include>
        </includes>
        <filtering>false</filtering>
      </resource>
    </resources>
  </build>

</project>
```

**maven的高级之初在于它会帮你导入这个jar包所依赖的其他jar包**

maven由于他的约定大于配置，我们之后可能会遇到我们写的配置文件，无法被导出或者生效的问题，解决方案：

```xml
<!--在build中配置resources,来防止我们资源导出失败的问题-->  
<build> 
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>false</filtering>
        </resource>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>false</filtering>
        </resource>
    </resources>
</build>
```

### 5.8 IDEA展示当前maven项目依赖的关系

![](E:\learn_programming_language\Java\7-JavaWeb\笔记\pictures\在IDEA中使用tomcat\8.png)