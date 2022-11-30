# JavaWeb学习笔记

推荐笔记：[JavaWeb学习笔记(全)(狂神)_程序猿tu的博客-CSDN博客_web笔记](https://blog.csdn.net/qq_41171409/article/details/123553501)

## 一、web的基本概念

### 1.1 前言

> web开发：
>
> * web，网页的意思
>
> * 静态web
>
>   html、css
>   提供给所有人看的数据始终不会发生变化！
>
> * 动态web
>   * 淘宝，几乎是所有的网站。
>   * 提供给所有人看的数据始终会发生变化，每个人在不同的时间，不同的地点看到的信息各不相同。
>   * 技术栈：servlet/JSP，ASP，PHP
>
>
> 在java中，动态web资源开发的技术统称为JavaWeb

### 1.2 web应用程序

> web应用程序：可以提供浏览器访问的程序
>
> - a.html 、b.html … 多个web资源，这些web资源可以被外界访问，对外界提供服务。
> - 你能访问到的任何一个页面或者资源，都存在于这个世界的某一个角落的计算机上。
> - URL
> - 这个统一的web资源会被放在同一个文件夹下，web应用程序--->tomcat:服务器
> - 一个web应用由多部分组成（静态web，动态web）
>   - html,css,js
>   - jsp,servlet
>   - java程序
>   - jar包
> - web应用编写完毕后，若想提供给外界访问，需要一个服务器来统一管理。

### 1.3 静态web

> - `*.htm,*.html`这些都是网页的后缀，如果服务器上一直存在这些东西，我们就可以直接进行读取。
> - 静态web存在缺点
>   - web页面无法动态更新，所有用户看到都是同一个页面
>     - 轮播图，点击特效：伪动态
>     - JavaScript【实际开发中，它用的最多】
>     - VBScript
>   - 它无法和数据库交互（数据无法持久化，用户无法交互）

### 1.4动态web

> 页面会动态展示：web的页面展示的效果因人而异
>
> 缺点：
>
> - 假如服务器的动态资源出现了错误，我们需要重新编写我们的后台程序，重新发布。
> - 停机维护
>
> 优点：
>
> - web页面可以动态更新，所有用户都可以看到不同的页面
> - **它可以与数据库交互（数据持久化）**

### 1.5 服务器响应客户端请求的流程

![](pictures/服务器响应客户端请求的流程.png)

## 二、web服务器讲解

### 2.1 技术讲解
> **ASP**
>
> - 微软：国内最早流行的就是ASP
> - 在html中嵌入了VB的脚本，ASP+COM
> - 在ASP开发中，基本一个页面都是几千行的业务代码，页面极其乱
> - 维护成本高
> - C#
> - IIS
>
> **PHP**
>
> - PHP开发速度很快，功能很强大，跨平台，代码很简单
> - 无法承载大访问量的情况（局限性）
>
> **JSP/Servlet:**
>
> B/S:浏览器和服务器
>
> C/S:客户端和服务器
>
> - sun公司主推的B/S架构
> - 基于java语言的（所有的发送四，或者一些开源的组件，都是用java写的）
> - 可以承载三高（高并发、高可用、高性能）问题带来的影响
> - 语法像ASP

### 2.2 web服务器

> 服务器是一种**被动**的操作，用来处理用户的一些请求和给用户一些响应信息。
>
> 1. IIS
>
>    微软的 windows中自带的
>
> 2. Tomcat
>
>    ![tomcat图标](pictures/tomcat图标.png)
>
>    （1）介绍：Tomcat是Apache 软件基金会（Apache Software Foundation）的Jakarta 项目中的一个核心项目，最新的Servlet 和JSP 规范总是能在Tomcat 中得到体现。因为Tomcat 技术先进、性能稳定，而且免费，因而深受Java 爱好者的喜爱并得到了部分软件开发商的认可，成为目前比较流行的Web 应用服务器。
>
>    Tomcat 服务器是一个免费的开放源代码的Web 应用服务器，属于轻量级应用服务器，在中小型系统和并发访问用户不是很多的场合下被普遍使用，是开发和调试JSP 程序的首选。对于一个java初学web的人来说，它是最佳的选择。
>
>    诀窍是，当配置正确时，Apache 为HTML页面服务，而Tomcat 实际上运行JSP 页面和Servlet。
>
>    工作3-5年之后，可以尝试手写tomcat服务器。
>
>    （2）下载tomcat流程：
>
>    1. 安装 or 解压
>    2. 了解配置文件及目录结构
>    3. 这个东西的作用

## 三、tomcat详解

### 3.1 安装tomcat

说明：tomcat版本为9.0.69

1. 下载官网：https://tomcat.apache.org/

   ![](pictures/tomcat9.0.69_windows版本下载.png)

2. 解压到`D:\Environment`文件夹中

   ![](pictures/解压.png)

3. tomcat启动和配置

   （1）文件夹作用：

   ![](pictures/tomcat文件夹内文件作用.png)

   （2）**启动，关闭tomcat**

   ![](pictures/tomcat配置/启动_关闭tomcat.png)

   （3）访问测试：http://localhost:8080/

   * 本地访问

   ![](pictures/tomcat配置/tomcat启动页面.png)

   可能遇到的问题：

   > 1. java环境变量没有配置
> 2. 闪退问题：需要配置兼容性
   > 3. 乱码问题：配置文件中设置

4. 

### 3.2 tomcat配置



![服务器核心配置文件](pictures/tomcat配置/服务器核心配置文件.png)

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

高难度面试题：

请你谈谈网站是如何进行访问的?

1. 输入一个域名；回车
2. 检查本机的配置文件`C:\Windows\System32\drivers\etc\hosts`下有没有这个域名的映射
   （1）有：直接返回对应的ip地址,这个地址中，有我们需要放的web程序，可以直接访问
   （2）没有：去DNS服务器找，找到的话就返回，找不到就返回找不到

### 3.3 发布一个web网站

> 1. 将自己写的网站，放到服务器（tomcat）中指定的web应用的文件夹（webapps）下
>
>    ![](pictures/创建网站/我的网站1.png)
>
>    ![我的网站2](pictures/创建网站/我的网站2.png)
>
> 2. 打开网站进行访问
>
>    ```bash
>    localhost:8080/phc/
>    ```
>
>    ![](pictures/我的网站3.png)
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

## 四、Http

### 4.1 什么是Http

1. 超文本传输协议（Hyper Text Transfer Protocol，HTTP）是一个简单的请求-响应协议，它通常运行在TCP之上。
   * 文本：html,字符串…
   * 超文本：图片，音乐，视频，定位，地图…
   * 端口号：80

2. HTTPS：安全的

   * 端口号：443
3. 两个时代
   - http1.0
     - HTTP/1.0 : 客户端可以与web服务器连接后，只能获得一个web资源，断开连接
   - http2.0
     - HTTP/1.1：客户端可以与web服务器连接后，可以获得多个web资源。

### 4.2 Http请求

客户端——>发送请求（Request）——>服务器

百度：

```bash
Request URL: https://www.baidu.com/    请求地址
Request Method: GET     get方法/post方法
Status Code: 200 OK     状态码：200
Remote Address: 14.215.177.38:443	远程请求地址
```

```bash
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9
Cache-Control: no-cache
Connection: keep-alive
Cookie: BIDUPSID=E915D8DAC0FCA4159DF81414176EBD43; PSTM=1618281055; BAIDUID=E915D8DAC0FCA415F0B2ABB582D30135:FG=1; __yjs_duid=1_042d578ea86bfb698f35ffbf7e97f5ff1619488718760; BAIDUID_BFESS=E915D8DAC0FCA415F0B2ABB582D30135:FG=1; COOKIE_SESSION=16414_3_8_4_7_1_1_0_7_1_0_0_16416_0_3_0_1625410778_1625394325_1625410775%7C9%2379260_3_1625394323%7C2; BD_LAST_QID=9581266030928333830
Host: www.baidu.com
```

1. 请求行

   * 请求行中的请求方式：GET
   * 请求方式：**GET,POST,**HEAD,DELETE,PUT,TRACT…
     get：请求能够携带的参数比较少，大小有限制，会在浏览器的URL地址拦显示数据内容，不安全，但是高效
     post：请求能都携带的参数没有限制，大小没有限制，不会再在浏览器的URL地址拦显示数据内容，安全，但是不高效。

2. 消息头

   ```bash
   Accept: 高速浏览器，它所支持的类型
   Accept-Encoding: 支持哪种编码格式  GBK  UTF-8 GB2312  ISO8859-1
   Accept-Language: 告诉浏览器，它的语言环境
   Cache-Control: 缓存控制
   Connection: 告诉浏览器，请求完成是断开还是保持连接
   Host:主机
   ```
   

### 4.3 Http响应

服务器——>响应——>客户端

百度：

```bash
Cache-Control: private                 缓存控制
Connection: keep-alive                 连接保持
Content-Encoding: gzip                 编码
Content-Type: text/html;charset=utf-8  类型
```

1. 响应体

   ```bash
   Accept: 高速浏览器，它所支持的类型
   Accept-Encoding: 支持哪种编码格式  GBK  UTF-8 GB2312  ISO8859-1
   Accept-Language: 告诉浏览器，它的语言环境
   Cache-Control: 缓存控制
   Connection: 告诉浏览器，请求完成是断开还是保持连接
   Host:主机
   Refresh:高速客户端，多久刷新一次
   Location:让网页重新定位
   ```

2. 响应状态码

   ```bash
   200：请求响应成功
   
   3xx：请求重定向
   重定向：你重新到我给你的新位置去
   
   4xx：找不到资源 404
   资源不存在
   
   5xx：服务器代码错误 500 502（网关错误）
   ```

3. 常见面试题

   当你的浏览器中地址拦输入地址并回车的一瞬间到页面能够展示回来，经历了什么？

## 五、maven环境搭建

我们为什么要学习这个技术？

1. 在javaweb开发中，需要使用大量的jar，我们手动去导入

2. 如何能够让一个东西自动帮我导入和配置这个jar包

   由此，Maven诞生了！

### 5.1 Maven项目架构管理工具

作用：就是方便导入jar包的

Maven的核心思想：**约定大于配置**（即有约束，不要去违反）

Maven会规定好你该如何取编写我们的java代码，必须要按照这个规范来。

### 5.2 下载安装Maven

官网：https://maven.apache.org/

**[请注意IDEA编译器与Maven版本匹配问题](https://libin9ioak.blog.csdn.net/article/details/117571120?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2~default~CTRLIST~Rate-1-117571120-blog-124024228.pc_relevant_3mothn_strategy_recovery&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2~default~CTRLIST~Rate-1-117571120-blog-124024228.pc_relevant_3mothn_strategy_recovery&utm_relevant_index=2)**

我的IDEA版本为：2021.3.3，兼容`maven 3.8.1`及之前的所用版本。这里我选择下载兼容性很强的**`maven 3.6.3`**

1. 下载

   [maven-3.6.3下载地址](https://archive.apache.org/dist/maven/maven-3/3.6.3/binaries/)

   ![](pictures/maven下载安装与配置/maven3.6.3下载.png)

   下载完成后，解压即可。这里我将`apache-maven-3.6.3`放在了`D:\Environment`文件夹下

   ![](pictures/maven下载安装与配置/解压地址.png)

   友情建议：电脑上的所有环境都放到一个文件夹下，方便管理
   

### 5.3 maven环境变量配置

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

  ![](pictures/maven下载安装与配置/系统环境变量.png)

- 在系统的Path中配置 `%MAVEN_HOME%\bin`

  ![](pictures/maven下载安装与配置/Path变量.png)

* maven环境配置成功的标志

  打开cmd，进入命令行，输入`mvn -version`

  ![](pictures/maven下载安装与配置/查看mvn版本.png)


### 5.4 修改`settings.xml`配置文件

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
>    ![](pictures/maven下载安装与配置/修改阿里镜像源.png)
>
> 2. 创建并修改本地仓库存放位置
>
>    （1）在`apache-maven-3.6.3`文件夹下创建本地仓库`maven-repo`
>
>    ![](pictures/maven下载安装与配置/创建本地仓库maven-repo.png)
>
>    （2）修改`settings.xml`文件的仓库地址
>
>    ```xml
>    <localRepository>D:\Environment\apache-maven-3.6.3\maven-repo</localRepository>
>    ```
>
>    ![](pictures/maven下载安装与配置/修改本地仓库默认地址.png)

## 六、IDEA安装教程

> 1. 教程：[IntelliJ IDEA安装教程（超详细）](https://lddwarehouse.blog.csdn.net/article/details/121928344?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2~default~CTRLIST~PayColumn-1-121928344-blog-115612756.pc_relevant_3mothn_strategy_recovery&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2~default~CTRLIST~PayColumn-1-121928344-blog-115612756.pc_relevant_3mothn_strategy_recovery&utm_relevant_index=1)
> 2. `JDK`安装：`D:\Java\jdk-16.0.2`
> 3. `IDEA`安装：`D:\Java\IntelliJ IDEA_2021.3.3`
>
> 后期的Java程序我将使用`IDEA`编译器

## 七、在IDEA中使用maven

说明：

（1）IDEA版本：2021.3.3

（2）maven版本：3.6.3

### 7.1 启动IDEA

### 7.2 设置创建maven新项目的全局配置

![](pictures/在IDEA中使用maven/设置新项目的全局配置.png)

![](pictures/在IDEA中使用maven/新项目创建的全局设置.png)

### 7.3 使用webapp模板创建一个`maven`项目

![](pictures/在IDEA中使用maven/1.png)

![2](pictures/在IDEA中使用maven/2.png)

![3](pictures/在IDEA中使用maven/3.png)

  ![](pictures/在IDEA中使用maven/4.png)

### 7.4 等待项目初始化完毕

等待一段时间，idea正在自动构建项目

![5](pictures/在IDEA中使用maven/5.png)

此时可以看到本地仓库`D:\Environment\apache-maven-3.6.3\maven-repo`多了很多文件夹

![](pictures/在IDEA中使用maven/maven-repo多了很多文件夹.png)

### 7.5 IDEA中的maven设置

IDEA项目创建成功后，看一眼Maven的配置。进入IDEA的`File>Settings`查看maven设置

![](pictures/在IDEA中使用maven/6.png)

![](pictures/在IDEA中使用maven/7.png)

![8](pictures/在IDEA中使用maven/8.png)

### 7.6 使用webapp模板配置后生成的目录结构

![](pictures/在IDEA中使用maven/使用webapp模板配置后生成的目录结构.png)

### 7.7 不使用模板创建一个普通的`maven`项目

![](pictures/在IDEA中使用maven/2-1.png)

![2-2](pictures/在IDEA中使用maven/2-2.png)

### 7.8 不使用模板配置后生成的目录结构（干净的maven文件）

![](pictures/在IDEA中使用maven/2-3.png)

### 7.9 在`main`文件夹下为webapp模板文件新建文件夹

1. 新建java文件夹

2. 新建resources文件夹

   ![](pictures/在IDEA中使用maven/2-4.png)

注：src文件夹下的test文件夹可以稍后用到再创建，影响不大

## 八、在IDEA中配置tomcat

说明：

（1）IDEA版本：2021.3.3

（2）tomcat版本：9.0.69

### 8.1 添加项目配置选项

![](pictures/在IDEA中使用tomcat/1.png)

### 8.2 选择本地tomcat服务器

![2](pictures/在IDEA中使用tomcat/2.png)

### 8.3 配置本地tomcat服务器

注：**将tomcat 10.0.27全部更换为9.0.69**

![3](pictures/在IDEA中使用tomcat/3.png)

![](pictures/在IDEA中使用tomcat/将tomcat 10.0.27全部更换为9.0.69.png)

为什么会有这个警告问题：我们访问一个网站，需要指定一个文件夹的路径，比如`localhost:8080/javaweb_01_maven_war`

### 8.4 添加一个artifact

![4](pictures/在IDEA中使用tomcat/4.png)

### 8.5 对artifact配置的一些解释

1. 可以写，也可以不写。
2. 如果不写的话默认访向路径为localhost:8080
3. 假如写了一个/javaweb_01_maven_war，则访问路径为：localhost:8080/javaweb_01_maven_war
4. 这个过程叫做:虚拟路径映射

![](pictures/在IDEA中使用tomcat/5.png)

### 8.6 启动tomcat服务器

![](pictures/在IDEA中使用tomcat/6.png)

### 8.7 POM文件讲解

pom.xml是maven的**核心配置文件**

![](pictures/在IDEA中使用tomcat/7.png)

`pom.xml`代码

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

### 8.8 IDEA展示当前maven项目依赖的关系

![](pictures/在IDEA中使用tomcat/8.png)

## 九、解决配置环境中遇到的问题

### 9.1 启动tomcat控制台乱码问题

![](pictures/环境配置过程中出现的问题/启动tomcat服务器出现乱码.png)

修改`D:\Environment\apache-tomcat-9.0.69\conf`下的`logging.properties`中的参数

```bash
# java.util.logging.ConsoleHandler.encoding = UTF-8
java.util.logging.ConsoleHandler.encoding = GBK
```

![](pictures/环境配置过程中出现的问题/tomcat启动时控制台乱码问题.png)

重启服务器即可

![](pictures/环境配置过程中出现的问题/tomcat服务器启动时乱码问题解决.png)

### 9.2 无法导入maven项目

1. 报错内容：unable to import maven project:see logs for detailWs
2. 解决方法：降低`maven`版本，最好是使用兼容性很强的`maven 3.6.3`

### 9.3 创建maven项目时每次都要重复配置maven

1. 即使重新配置maven项目成功，构建maven项目时也可能会出现如下错误提示

   ```bash
   Cannot resolve plugin org.apache.maven.plugins:maven-clean-plugin:2.5
   ```

2. 解决方法：参考上述 [在IDEA中使用maven/设置创建maven新项目的全局配置] 步骤即可在IDEA中的全局默认配置中完成配置

### 9.4 maven默认web项目中的web.xml版本太旧问题

1. maven默认使用的webapp版本为2.3

   ![](pictures/环境配置过程中出现的问题/webapp过于老旧.png)

2. 而`tomcat 9.0.69`使用的`webapp`版本为4.0

   （1）tomcat中webapp的配置文件所在目录

   ![tomcat中webapp的配置文件目录](pictures/环境配置过程中出现的问题/tomcat中webapp的配置文件目录.png)

   （2）`web.xml`文件中的webapp版本为4.0

   ![](pictures/环境配置过程中出现的问题/tomcat使用的webapp版本为4.0.png)

   

3. 将maven默认使用的webapp_2.3版本替换为`tomcat 9.0.69`使用的`webapp_4.0`版本

   替换的文件位置：`javaweb-01-maven[javaweb项目名称]\src\main\webapp\WEB-INF\web.xml`

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <!--
    Licensed to the Apache Software Foundation (ASF) under one or more
     contributor license agreements.  See the NOTICE file distributed with
     this work for additional information regarding copyright ownership.
     The ASF licenses this file to You under the Apache License, Version 2.0
     (the "License"); you may not use this file except in compliance with
     the License.  You may obtain a copy of the License at
   
         http://www.apache.org/licenses/LICENSE-2.0
   
     Unless required by applicable law or agreed to in writing, software
     distributed under the License is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     See the License for the specific language governing permissions and
     limitations under the License.
   -->
   <!--tomcat 9.0.69使用的webapp版本为4.0-->
   <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                         http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
            version="4.0"
            metadata-complete="true">
   
     <display-name>Welcome to Tomcat</display-name>
     <description>
       Welcome to Tomcat
     </description>
   
   </web-app>
   
   
   <!--maven默认使用的webapp版本为2.3-->
   <!--<!DOCTYPE web-app PUBLIC-->
   <!-- "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"-->
   <!-- "http://java.sun.com/dtd/web-app_2_3.dtd" >-->
   
   <!--<web-app>-->
   <!--  <display-name>Archetype Created Web Application</display-name>-->
   <!--</web-app>-->
   ```

   

### 9.5 maven仓库的使用(导jar包)

1. maven仓库地址：https://mvnrepository.com/

   ![](pictures/环境配置过程中出现的问题/maven远程仓库.png)

2. 选择使用人数较多的api版本

   ![](pictures/环境配置过程中出现的问题/选择使用人数较多的api.png)

3. 自动导入依赖的jar包

   ![](pictures/环境配置过程中出现的问题/自动导入依赖的jar包.png)

## 十、Servlet

### 10.1 servlet简介

> servlet就是sun公司开发动态web的一门技术
> sun在这些api中提供一个接口叫做：servlet，如果你想开发一个servlet程序，只需要完成两个小步骤：
> （1）编写一个类，实现servlet接口
> （2）把开发好的java类部署到web服务器中
> **把实现了servlet接口的java程序叫做servlet**

### 10.2 HelloServlet

#### 10.2.1 创建父项目和子项目

> 1. 建立一个普通的maven项目`javaweb-01-servlet`，删除`src`目录
>
>    ![](pictures/servlet/删除src目录1.png)
>
>    ![](pictures/servlet/删除src目录2.png)
>
> 2. 然后在此项目中，新建一个`module`（javaweb maven项目）
>
>    （1）在主项目中新建module
>
>    ![](pictures/servlet/在主项目中新建module.png)
>
>    （2）使用模板构建新的javeweb模块
>
>    ![](pictures/servlet/使用模板构建新的javeweb模块.png)
>
>    （3）新建模块名
>
>    ![](pictures/servlet/新建模块名.png)
>
>    （4）自动导入前期配置好的maven环境和设置
>
>    ![](pictures/servlet/自动导入前期配置好的maven环境和设置.png)
>
> 3. 将子项目中maven默认使用的webapp_2.3版本替换为`tomcat 9.0.69`使用的`webapp_4.0`版本
>
>    替换的文件位置：`javaweb-01-servlet\servlet-01\src\main\webapp\WEB-INF\web.xml`
>
>    ```xml
>    <?xml version="1.0" encoding="UTF-8"?>
>    <!--
>     Licensed to the Apache Software Foundation (ASF) under one or more
>      contributor license agreements.  See the NOTICE file distributed with
>      this work for additional information regarding copyright ownership.
>      The ASF licenses this file to You under the Apache License, Version 2.0
>      (the "License"); you may not use this file except in compliance with
>      the License.  You may obtain a copy of the License at
>          
>          http://www.apache.org/licenses/LICENSE-2.0
>          
>      Unless required by applicable law or agreed to in writing, software
>      distributed under the License is distributed on an "AS IS" BASIS,
>      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
>      See the License for the specific language governing permissions and
>      limitations under the License.
>    -->
>    <!--tomcat 9.0.69使用的webapp版本为4.0-->
>    <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
>             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
>             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
>                          http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
>             version="4.0"
>             metadata-complete="true">
>          
>      <display-name>Welcome to Tomcat</display-name>
>      <description>
>        Welcome to Tomcat
>      </description>
>          
>    </web-app>
>    
>    
>    <!--maven默认使用的webapp版本为2.3-->
>    <!--<!DOCTYPE web-app PUBLIC-->
>    <!-- "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"-->
>    <!-- "http://java.sun.com/dtd/web-app_2_3.dtd" >-->
>    
>    <!--<web-app>-->
>    <!--  <display-name>Archetype Created Web Application</display-name>-->
>    <!--</web-app>-->
>    ```
>
> 4. 在子项目的`main`文件夹下为`webapp`模板文件新建文件夹`src`和`resource`
>
> 5. 父子项目完整结构
>
>    ![](pictures/servlet/父子项目完整结构.png)
>
> 6. 

#### 10.2.2 关于maven父子工程的理解

1. 父项目的`pom.xml`中会有`<modules>`标签

   ```xml
   <modules>
       <module>servlet-01</module>
   </modules>
   ```

2. 子项目的`pom.xml`中会有`<parent>`标签

   ```xml
   <parent>
       <artifactId>javaweb-01-servlet</artifactId>
       <groupId>com.phc</groupId>
       <version>1.0-SNAPSHOT</version>
   </parent>
   ```

3. 父项目中的jar包子项目可以直接使用

   ```java
   son extends father
   ```

### 10.3 编写一个servlet程序

#### 10.3.1 向pom.xml中导入jar包javax.servlet

![](pictures/servlet/向pom.xml中导入jar包javax.servlet.png)

在主项目maven配置文件中`pom.xml`导入依赖jar包`javax.servlet`

```xml
<!--向pom.xml中导入jar包javax.servlet-->
<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
<dependencies>
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>4.0.1</version>
        <!--取消作用域-->
        <!--<scope>provided</scope>-->
    </dependency>
</dependencies>
```

![](pictures/servlet/在主项目配置文件pom.xml中添加jar包依赖.png)

#### 10.3.2 继承`HttpServlet`

1. 在子项目`servlet-01\src\main\java`文件夹下新建`com.phc.servlet`文件夹，并在`com.phc.servlet`文件夹中新建`Class`类`HelloServlet`

2. 在`HelloServlet`类中导入`HttpServlet`包

   ```java
   import javax.servlet.http.HttpServlet;
   ```

3. 在`HelloServlet`类中重写`HttpServlet`类的`doGet`和`doPost`方法（在`IDEA`中按住`ctrl+o`可以调出重写的方法，选择即可）

   ![](pictures/servlet/HttpServlet中需要重写的两个方法.png)

   

   ```java
   package com.phc.servlet;
   import javax.servlet.ServletException;
   import javax.servlet.http.HttpServlet;
   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;
   import java.io.IOException;
   import java.io.PrintWriter;
   
   /**
    * @FileName HelloServlet
    * @Description Servlet程序
    * @Author phc
    * @date 2022/11/30 17:13
    * @Version 1.0
    */
   public class HelloServlet extends HttpServlet{
       // Ctrl+O键可以调出重写的方法
   
       // 由于get和post只是请求实现的不同方式，所以可以互相调用，业务逻辑都一样
       @Override
       protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           System.out.println("--------------------进入了doGet方法--------------------");
           resp.setContentType("text/html");
           resp.setCharacterEncoding("utf-8");
           PrintWriter out = resp.getWriter(); // 获得响应流
           // 编写html标签
           out.println("<html>");
           out.println("<head>");
           out.println("<title>Hello World!</title>");
           out.println("</head>");
           out.println("<body>");
           out.println("<h1>你好，Servlet！</h1>");
           out.println("</body>");
           out.println("</html>");
       }
   
       @Override
       protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           // 调用doGet方法
           doGet(req,resp);
       }
   }
   ```

   

4. `HelloServlet`类继承流图

   ![](pictures/servlet/HttpServlet类继承流图.png)

5. 

#### 10.3.3 编写servlet的映射

**说明：**为什么需要映射？因为我们写的是java程序，但是要通过浏览器访问，而浏览器需要连接web服务器，所以我们需要在web服务中注册我们写的servlet，还需要给他一个浏览器能够访问的路径。

在子项目`servlet-01`的`servlet-01\src\main\webapp\WEB-INF\web.xml`文件中添加`servlet`注册和mapping映射

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!--tomcat 9.0.69使用的webapp版本为4.0-->
<!--web.xml是配置我们web的核心应用-->
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0"
         metadata-complete="true">
  <display-name>Welcome to Tomcat</display-name>
  <description>
    Welcome to Tomcat
  </description>
    
  <!--注册servlet-->
  <servlet>
    <servlet-name>helloServlet</servlet-name>
  <!--写HelloServlet类所在的相对地址(以java为根目录)-->
    <servlet-class>com.phc.servlet.HelloServlet</servlet-class>
  </servlet>
  <!--一个servlet对应一个Mapping映射-->
  <servlet-mapping>
    <servlet-name>helloServlet</servlet-name>
  <!--写浏览器中访问的文件夹地址,这里是localhost:8080/hello-->
    <url-pattern>/hello</url-pattern>
  </servlet-mapping>
</web-app>
```

#### 10.3.4 配置tomcat

![](pictures/servlet/配置tomcat.png)

![](pictures/servlet/配置tomcat2.png)

![配置tomcat3](pictures/servlet/配置tomcat3.png)

![配置tomcat4](pictures/servlet/配置tomcat4.png)

#### 10.3.5 运行

![](pictures/servlet/运行.png)

（1）静态web资源路径：localhost:8080/servlet_01_war

![运行1](pictures/servlet/运行1.png)

（2）动态web资源路径：localhost:8080/servlet_01_war/hello

![运行2](pictures/servlet/运行2.png)

### 10.4 servlet原理

servlet是由web服务器调用，web服务器在收到浏览器请求之后，会执行如下操作

![](pictures/servlet/servlet原理图.png)

### 10.5 mapping映射问题

在项目的页面配置文件`servlet-01\src\main\webapp\WEB-INF\web.xml`中进行修改

1. 一个servlet指定一个映射路径

   ```xml
   <servlet-mapping>
       <servlet-name>helloServlet</servlet-name>
       <!--写浏览器中访问的文件夹地址,这里是localhost:8080/hello-->
       <url-pattern>/hello</url-pattern>
   </servlet-mapping>
   ```

2. 一个servlet指定多个映射路径

   ```xml
   <servlet-mapping>
       <servlet-name>helloServlet</servlet-name>
       <!--写浏览器中访问的文件夹地址,这里是localhost:8080/hello-->
       <url-pattern>/hello</url-pattern>
   </servlet-mapping>
   
   <!--一个servlet可以指定多个映射路径-->
   <servlet-mapping>
       <servlet-name>helloServlet</servlet-name>
       <url-pattern>/hello2</url-pattern>
   </servlet-mapping>
   ```

3. 一个servlet可以指定通用映射路径

   ```xml
   <!--一个servlet可以指定通用映射路径-->
   <servlet-mapping>
       <servlet-name>helloServlet</servlet-name>
       <url-pattern>/hello/*</url-pattern>
   </servlet-mapping>
   ```

   ![](pictures/servlet/一个servlet可以指定通用映射路径.png)

4. 注意下面这样重启服务就不会默认进入到index.jsp页面了**(不推荐使用)**

   ```xml
   <servlet-mapping>
       <servlet-name>helloServlet</servlet-name>
       <url-pattern>/*</url-pattern>
   </servlet-mapping>
   ```

5. 指定一些后缀或者前缀等等

   ```xml
   <!--  可以自定义后缀实现请求映射
     注意点：*前面不能加项目映射的路径，比如 /hello/*.do 是不可以的
     但是 /hello/hi.do 是可以访问servlet的
     -->
   <servlet-mapping>
       <servlet-name>helloServlet</servlet-name>
       <url-pattern>*.do</url-pattern>
   </servlet-mapping>
   ```

6. 优先级问题

   制定了固有的映射路径优先级最高，如果找不到就会走默认的处理请求

   ```java
   package com.phc.servlet;
   
   import javax.servlet.ServletException;
   import javax.servlet.http.HttpServlet;
   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;
   import java.io.IOException;
   import java.io.PrintWriter;
   
   /**
    * @FileName ErrorServlet.class
    * @Description 网页错误处理
    * @Author phc
    * @date 2022/11/30 20:23
    * @Version 1.0
    */
   public class ErrorServlet extends HttpServlet {
       @Override
       protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           // 设置页面输出格式为html
           resp.setContentType("text/html");
           // 设置页面输出字符类型为utf-8
           resp.setCharacterEncoding("utf-8");
           PrintWriter out = resp.getWriter();
           out.println("<h1>404，页面找不到了！<h1>");
       }
   
       @Override
       protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           doGet(req, resp);
       }
   }
   ```

   ```xml
   <!--处理页面无法找到的错误提示404-->
   <servlet>
       <servlet-name>errorServlet</servlet-name>
       <servlet-class>com.phc.servlet.ErrorServlet</servlet-class>
   </servlet>
   <servlet-mapping>
       <servlet-name>errorServlet</servlet-name>
       <!--当用户输入随意地址时则显示404页面-->
       <url-pattern>/*</url-pattern>
   </servlet-mapping>
   ```

   ![](pictures/servlet/显示错误页面.png)

7. 

### 10.6 ServletContext对象

web容器在启动的时候，它会为每个web程序都创建一个对应的servletContext对象，它代表了当前的web应用。

#### 10.6.1 共享数据

描述：在一个servlet中保存的数据，可以在另外一个servlet中拿到

![](pictures/servlet/servletContext/共享数据.png)

1. 项目结构

   ![](pictures/servlet/servletContext/servlet-02项目结构.png)

2. 放置数据

   ```java
   package com.phc.servlet;
   
   import javax.servlet.ServletContext;
   import javax.servlet.ServletException;
   import javax.servlet.http.HttpServlet;
   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;
   import java.io.IOException;
   import java.io.PrintWriter;
   
   /**
    * @FileName GetDataServlet.class
    * @Description 获取数据:使用ServletContext拿到共享的数据
    * @Author phc
    * @date 2022/11/30 21:51
    * @Version 1.0
    */
   public class GetDataServlet extends HttpServlet {
       @Override
       protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           // 获取ServletContext对象
           ServletContext servletContext = this.getServletContext();
           String username = (String)servletContext.getAttribute("username");
           String passwords = (String)servletContext.getAttribute("passwords");
           int age = (int)servletContext.getAttribute("age");
           char sex = (char)servletContext.getAttribute("sex");
   
           resp.setCharacterEncoding("GBK");
           PrintWriter out = resp.getWriter();
           out.println("姓名:"+username);
           out.println("年龄:"+age);
           out.println("性别:"+sex);
           out.println("密码:"+passwords);
       }
   
       @Override
       protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           doGet(req, resp);
       }
   }
   ```

3. 获取数据

   ```java
   package com.phc.servlet;
   
   import javax.servlet.ServletContext;
   import javax.servlet.ServletException;
   import javax.servlet.http.HttpServlet;
   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;
   import java.io.IOException;
   import java.io.PrintWriter;
   
   /**
    * @FileName PutDataServlet.class
    * @Description 共享数据:使用ServletContext对象放置数据
    * @Author phc
    * @date 2022/11/30 21:40
    * @Version 1.0
    */
   public class PutDataServlet extends HttpServlet {
       @Override
       protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           // ServletContext servlet上下文
           ServletContext servletContext = this.getServletContext();
           String username="phc";
           int age=18;
           char sex='M';
           String passwords="123456";
           // 以键值对的形式将数据存储在servletContext中
           servletContext.setAttribute("username",username);
           servletContext.setAttribute("passwords",passwords);
           servletContext.setAttribute("age",age);
           servletContext.setAttribute("sex",sex);
   
           resp.setCharacterEncoding("GBK");
           PrintWriter out = resp.getWriter();
           out.println("---------------数据存储成功!---------------");
       }
   
       @Override
       protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           doGet(req, resp);
       }
   }
   ```

4. 修改web.xml配置文件添加页面映射

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <!--tomcat 9.0.69使用的webapp版本为4.0-->
   <!--web.xml是配置我们web的核心应用-->
   <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                                http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
            version="4.0"
            metadata-complete="true">
   
       <display-name>Welcome to Tomcat</display-name>
       <description>
           Welcome to Tomcat
       </description>
   
       <!--注册servlet-->
       <servlet>
           <servlet-name>putData</servlet-name>
           <servlet-class>com.phc.servlet.PutDataServlet</servlet-class>
       </servlet>
       <servlet-mapping>
           <servlet-name>putData</servlet-name>
           <url-pattern>/putData</url-pattern>
       </servlet-mapping>
   
       <!--注册servlet-->
       <servlet>
           <servlet-name>getData</servlet-name>
           <servlet-class>com.phc.servlet.GetDataServlet</servlet-class>
       </servlet>
       <servlet-mapping>
           <servlet-name>getData</servlet-name>
           <url-pattern>/getData</url-pattern>
       </servlet-mapping>
   
   </web-app>
   ```

5. 将子项目servlet-02打包成war包

   这里需要注意的是：
   （1）需要刷新maven才可以看到servlet-02的war包
   （2）记得删除之前的servlet-01的war包，再创建servlet-02的war包。否则IDEA会打包两个war包，浪费资源

   ![](pictures/servlet/servletContext/注意点.png)

6. 运行结果

   （1）访问首页`localhost:8080/servlet_02_war)`

   ![](pictures/servlet/servletContext/首页.png)

   （2）先访问`localhost:8080/servlet_02_war/putData`来输入共享数据

   ![](pictures/servlet/servletContext/输入共享数据.png)

   （3）再访问`localhost:8080/servlet_02_war/getData`获取共享数据

   ![](pictures/servlet/servletContext/获取共享数据.png)

7. 
