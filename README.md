# JavaWeb学习笔记

推荐笔记：[JavaWeb学习笔记(全)(狂神)_程序猿tu的博客-CSDN博客_web笔记](https://blog.csdn.net/qq_41171409/article/details/123553501)

推荐视频：[javaweb-01：web的基本概念_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV12J411M7Sj?p=1)

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
   > 1. 闪退问题：需要配置兼容性
   > 3. 乱码问题：配置文件中设置
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
>    </web-app>
>    
>    <!--maven默认使用的webapp版本为2.3-->
>    <!--<!DOCTYPE web-app PUBLIC-->
>    <!-- "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"-->
>    <!-- "http://java.sun.com/dtd/web-app_2_3.dtd" >-->
>    
>    <!--<web-app>-->
>    <!--  <display-name>Archetype Created Web Application</display-name>-->
>    <!--</web-app>-->
>
> 4. 在子项目的`main`文件夹下为`webapp`模板文件新建文件夹`src`和`resource`
>
>    父子项目完整结构
>
>    ![](pictures/servlet/父子项目完整结构.png)

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

#### 10.6.2 ServletContext应用

##### 1. 获取`web.xml`的初始化参数

可以在`doPost`中拿到在`web.xml`配置的初始化参数

> 1. `javaweb-01-servlet\servlet-02\src\main\webapp\WEB-INF\web.xml`
>
>    ```xml
>    <!--配置一些web应用初始化参数-->
>    <context-param>
>        <param-name>url</param-name>
>        <param-value>jdbc:mysql://localhost:3306/mybatis</param-value>
>    </context-param>
>    
>    <!--注册servlet-->
>    <servlet>
>        <servlet-name>getInitParameters</servlet-name>
>        <servlet-class>com.phc.servlet.GetInitParameters</servlet-class>
>    </servlet>
>    <!--map映射-->
>    <servlet-mapping>
>        <servlet-name>getInitParameters</servlet-name>
>        <url-pattern>/getInitParameters</url-pattern>
>    </servlet-mapping>
>
> 2. `javaweb-01-servlet\servlet-02\src\main\java\com\phc\servlet\GetInitParameters.java`
>
>    ```java
>    package com.phc.servlet;
>                                                                
>    import javax.servlet.ServletContext;
>    import javax.servlet.ServletException;
>    import javax.servlet.http.HttpServlet;
>    import javax.servlet.http.HttpServletRequest;
>    import javax.servlet.http.HttpServletResponse;
>    import java.io.IOException;
>    import java.io.PrintWriter;
>                                                                
>    /**
>     * @FileName GetInitParameters.class
>     * @Description 获取web.xml的初始化参数
>     * @Author phc
>     * @date 2022/12/2 9:42
>     * @Version 1.0
>     */
>    public class GetInitParameters extends HttpServlet {
>        @Override
>        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>            // Alt+Enter 快捷键可以创建变量
>            ServletContext servletContext = this.getServletContext();
>            String url = servletContext.getInitParameter("url");
>            resp.getWriter().println("url:"+url);
>        }
>                                                                
>        @Override
>        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>            doGet(req, resp);
>        }
>    }
>    ```
>
>    3. 结果：
>
>    ![](pictures/servlet/servletContext/获取web.xml的初始化参数.png)

##### 2. 请求转发

一个web资源服务器B（中介）收到客户端A请求服务器C的资源后，B会向C发出请求，拿到C的资源后，再将资源返回给A，这个过程就叫做请求转发。

> 1. `javaweb-01-servlet\servlet-02\src\main\webapp\WEB-INF\web.xml`
>
>    ```xml
>    <!--请求转发的servlet-->
>    <servlet>
>        <servlet-name>testRequestDispatcher</servlet-name>
>        <servlet-class>com.phc.servlet.testRequestDispatcher</servlet-class>
>    </servlet>
>    <servlet-mapping>
>        <servlet-name>testRequestDispatcher</servlet-name>
>        <url-pattern>/testRequestDispatcher</url-pattern>
>    </servlet-mapping>
>    ```
>
>    2. `javaweb-01-servlet\servlet-02\src\main\java\com\phc\servlet\testRequestDispatcher.java`
>
>    ```java
>     package com.phc.servlet;
> 
>    import javax.servlet.RequestDispatcher;
>       import javax.servlet.ServletContext;
>    import javax.servlet.ServletException;
>    import javax.servlet.http.HttpServlet;
>    import javax.servlet.http.HttpServletRequest;
>    import javax.servlet.http.HttpServletResponse;
>    import java.io.IOException;
>    import java.io.PrintWriter;
> 
>    /**
>        * @FileName testRequestDispatcher.class
>     * @Description 请求转发
>     * @Author phc
>     * @date 2022/12/2 10:01
>     * @Version 1.0
>     */
>    public class testRequestDispatcher extends HttpServlet {
>        @Override
>        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>            resp.setCharacterEncoding("GBK");
>            resp.getWriter().println("进入了请求转发页面,正在跳转到其他页面...");
>            System.out.println("进入了请求转发页面,正在跳转到其他页面...");
>            ServletContext servletContext = this.getServletContext();
>            // 转发的地址(相对于当前项目)
>            String dispatcherUrl = "/getInitParameters";
>            // RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(dispatcherUrl); // 转发的请求路径
>            // requestDispatcher.forward(req,resp); // 调用forward实现请求转发
>            servletContext.getRequestDispatcher(dispatcherUrl).forward(req,resp);
> 
>        }
>    
>        @Override
>           protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>            doGet(req, resp);
>        }
>    }
> 
>    ```
>    
> 2. 结果
>
>    ![](pictures/servlet/servletContext/请求转发.png)

##### 3. 请求转发与重定向的区别

**面试题：请你聊聊重定向和转发的区别？**

- 相同点
  - 页面都会实现跳转
- 相同点
  - 请求转发，URL地址拦不会变；状态码：307
  - 重定向，URL地址拦会发生变化；状态码：302

![](pictures/servlet/servletContext/请求转发与重定向的区别1.png)

##### 4. 读取资源文件

> 1. 新建文件`db.properties`
>
>    在java目录下新建db.properties
>
>    或者在resource目录下新建db.properties（推荐）
>
>    ```properties
>    username=root
>    password=123456
>    ```
>
> 2. `javaweb-01-servlet\servlet-02\src\main\java\com\phc\servlet\readProperties.java`
>
>    ```java
>    package com.phc.servlet;
>    
>    import javax.servlet.ServletException;
>    import javax.servlet.http.HttpServlet;
>    import javax.servlet.http.HttpServletRequest;
>    import javax.servlet.http.HttpServletResponse;
>    import java.io.IOException;
>    import java.io.InputStream;
>    import java.util.Properties;
>    
>    /**
>     * @FileName readProperties.class
>     * @Description 读取db.properties配置文件
>     * @Author phc
>     * @date 2022/12/2 10:33
>     * @Version 1.0
>     */
>    public class readProperties extends HttpServlet {
>        @Override
>        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>            InputStream resourceAsStream = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
>            Properties prop = new Properties();
>            prop.load(resourceAsStream);
>            String username=prop.getProperty("username");
>            String pwd=prop.getProperty("password");
>            resp.getWriter().println("username:"+username);
>            resp.getWriter().println("password:"+pwd);
>        }
>    
>        @Override
>        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>            doGet(req, resp);
>        }
>    }
>    ```
>
>    ![](pictures/servlet/servletContext/读取db.properties配置文件.png)
>
>    发现：都被打包到同一个路径下：`classes` 我们俗称这个路径为classpath
>
> 3. `javaweb-01-servlet\servlet-02\src\main\webapp\WEB-INF\web.xml`
>
>    ```xml
>    <!--获取配置文件db.properties内容-->
>    <servlet>
>        <servlet-name>readProperties</servlet-name>
>        <servlet-class>com.phc.servlet.readProperties</servlet-class>
>    </servlet>
>    <servlet-mapping>
>        <servlet-name>readProperties</servlet-name>
>        <url-pattern>/readProperties</url-pattern>
>    </servlet-mapping>
>    ```
>
> 4. 结果
>
>    ![](pictures/servlet/servletContext/读取到的db.properties配置文件.png)

### 10.7 HttpServletResponse

web服务器接收到客户端的http请求，针对这个请求，分别创建一个代表请求的`HttpServletRequest`对象，一个代表响应的`HttpServletResponse`

（1）如果要获取客户端请求过来的参数：找`HttpServletRequest`
（2）如果要给客户端响应一些信息：找`HttpServletResponse`

#### 10.7.1 该类中方法的简单分类

> 1. 负责向浏览器发送数据的方法
>
>    ```java
>    public ServletOutputStream getOutputStream() throws IOException;
>    public PrintWriter getWriter() throws IOException;
>    ```
>
> 2. 负责向浏览器发送响应头的方法
>
>    ```java
>    public void setCharacterEncoding(String charset);
>    public void setContentLength(int len);
>    public void setContentLengthLong(long len);
>    public void setContentType(String type);
>    public void setDateHeader(String name, long date);
>    public void addDateHeader(String name, long date);
>    public void setHeader(String name, String value);
>    public void addHeader(String name, String value);
>    public void setIntHeader(String name, int value);
>    public void addIntHeader(String name, int value);
>    ```
>
> 3. 响应的状态码(常见)
>
>    ```java
>    /**
>         * Status code (200) indicating the request succeeded normally.
>         */
>    public static final int SC_OK = 200;
>    /**
>         * Status code (302) indicating that the resource has temporarily
>         * moved to another location, but that future references should
>         * still use the original URI to access the resource.
>         *
>         * This definition is being retained for backwards compatibility.
>         * SC_FOUND is now the preferred definition.
>         */
>    public static final int SC_MOVED_TEMPORARILY = 302;
>    /**
>         * Status code (404) indicating that the requested resource is not
>         * available.
>         */
>    public static final int SC_NOT_FOUND = 404;
>    /**
>         * Status code (500) indicating an error inside the HTTP server
>         * which prevented it from fulfilling the request.
>         */
>    public static final int SC_INTERNAL_SERVER_ERROR = 500;
>    /**
>         * Status code (502) indicating that the HTTP server received an
>         * invalid response from a server it consulted when acting as a
>         * proxy or gateway.
>         */
>    public static final int SC_BAD_GATEWAY = 502;
>                                           
>    //...
>    ```

#### 10.7.2 该类的常见应用

> 1. 向浏览器输出消息
>
> 2. 下载文件
>
>    （1）获取下载文件的路径
>    （2）下载的文件名是啥？
>    （3）设置想办法让浏览器能都支持我们下载的东西 文件名是中文的时候，可以设置`URLEncoder.encode(fileName, “UTF-8”)`，否则有可能乱码
>    （4）获取下载文件的输入流
>    （5）创建缓冲区
>    （6）获取OutputStrem对象
>    （7）将FileOutputStream流写入到buffer缓冲区，使用OutputStream将缓冲区中的数据输出到客户端
>
>    （8）刷新后关闭各种流对象
>
> 3. 验证码实现

#### 10.7.3 Response下载文件

> 1. `javaweb-01-servlet\response-01\src\main\java\com\phc\servlet\FileServlet.java`
>
>    ```java
>    package com.phc.servlet;
>                
>    import javax.servlet.ServletException;
>    import javax.servlet.ServletOutputStream;
>    import javax.servlet.http.HttpServlet;
>    import javax.servlet.http.HttpServletRequest;
>    import javax.servlet.http.HttpServletResponse;
>    import java.io.FileInputStream;
>    import java.io.IOException;
>    import java.net.URLEncoder;
>                
>    /**
>     * @FileName FileServlet.class
>     * @Description Response类下载文件
>     * @Author phc
>     * @date 2022/12/2 11:25
>     * @Version 1.0
>     */
>    public class FileServlet extends HttpServlet {
>        @Override
>        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>            // 1.获取下载文件的路径
>            String realPath="E:\\learn_programming_language\\Java\\7-JavaWeb\\javaweb-01-servlet\\response-01\\src\\main\\resources\\东南大学校门.jpg";
>            // 2.下载的文件名是啥？
>            String fileName=realPath.substring(realPath.lastIndexOf("\\")+1);
>            // 3.设置想办法让浏览器能都支持我们下载的东西 文件名是中文的时候,可以设置URLEncoder.encode(fileName, “UTF-8”),否则有可能乱码
>            resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
>            // 4.获取下载文件的输入流
>            FileInputStream in = new FileInputStream(realPath);
>            // 5.创建缓冲区
>            int len=0;
>            byte[] buffer = new byte[1024];
>            // 6.获取OutputStrem对象
>            ServletOutputStream out = resp.getOutputStream();
>            // 7.将FileOutputStream流写入到buffer缓冲区，使用OutputStream将缓冲区中的数据输出到客户端
>            while((len=in.read(buffer))>0) {
>                out.write(buffer,0,len);
>            }
>            // 8.刷新后关闭各种流对象
>            out.flush();
>            out.close();
>            in.close();
>        }
>                
>        @Override
>        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>            doGet(req, resp);
>        }
>    }
>    ```
>
>    2. `javaweb-01-servlet\response-01\src\main\webapp\WEB-INF\web.xml`
>
>    ```xml
>     <!--注册servlet-->
>    <servlet>
>        <servlet-name>downloadFile</servlet-name>
>        <servlet-class>com.phc.servlet.FileServlet</servlet-class>
>    </servlet>
>    <servlet-mapping>
>        <servlet-name>downloadFile</servlet-name>
>        <url-pattern>/downloadFile</url-pattern>
>    </servlet-mapping>
>    ```
> 
> 3. 文件结构
>
>       ![](pictures/servlet/HttpServletResponse/需要下载的资源文件.png)
>
> 4. 网页结果
>
>    ![](pictures/servlet/HttpServletResponse/自动下载资源文件.png)

#### 10.7.4 Response验证码实现

> 验证码怎么来的？
>
> - 前端实现
> - 后端实现，需要用到java图片类，生成一个图片
>
> 1. `javaweb-01-servlet\response-01\src\main\java\com\phc\servlet\ImageServlet.java`
>
>    ```java
>    package com.phc.servlet;
>                
>    import javax.imageio.ImageIO;
>    import javax.servlet.ServletException;
>    import javax.servlet.http.HttpServlet;
>    import javax.servlet.http.HttpServletRequest;
>    import javax.servlet.http.HttpServletResponse;
>    import java.awt.*;
>    import java.awt.image.BufferedImage;
>    import java.io.IOException;
>    import java.util.Random;
>                
>    /**
>     * @FileName ImageServlet
>     * @Description 模拟图片验证码的生成
>     * @Author phc
>     * @date 2022/12/2 14:50
>     * @Version 1.0
>     */
>    public class ImageServlet extends HttpServlet {
>        @Override
>        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>            // 让浏览器5秒自动刷新一次
>            resp.setHeader("refresh","3");
>            // 在内存中创建一个图片
>            BufferedImage bufferedImage = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
>            // 得到图片(相当于画笔)
>            Graphics2D paint = (Graphics2D)bufferedImage.getGraphics();
>            // 设置背景颜色为蓝色
>            paint.setColor(Color.BLUE);
>            paint.fillRect(0,0,100,30);
>            // 给背景写数字验证码
>            paint.setColor(Color.WHITE);
>            paint.setFont(new Font(null,Font.BOLD,20));
>            paint.drawString(generateRandomNums(),0,20);
>            // 告诉浏览器用图片的方式打开
>            resp.setContentType("image/jpeg");
>            // 网站存在缓存，不让浏览器缓存
>            resp.setDateHeader("Expires",0);
>            resp.addHeader("Cache-Control","no-cache");
>            resp.setHeader("Pragma","no-cache");
>                
>            ImageIO.write(bufferedImage,"jpeg",resp.getOutputStream());
>        }
>                
>        // 生成随机数
>        private String generateRandomNums() {
>            Random random=new Random();
>            String num=random.nextInt(99999999)+"";
>            StringBuilder stringBuilder = new StringBuilder();
>            // 如果数字不足8个，则补0
>            for (int i=0;i<8-num.length();i++) {
>                stringBuilder.append("0");
>            }
>            return stringBuilder.toString()+num;
>        }
>                
>        @Override
>        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>            doGet(req, resp);
>        }
>    }
>    ```
>
>    2. `javaweb-01-servlet\response-01\src\main\webapp\WEB-INF\web.xml`
>
>    ```xml
>     <!--图片验证码-->
>    <servlet>
>        <servlet-name>verificationCode</servlet-name>
>        <servlet-class>com.phc.servlet.ImageServlet</servlet-class>
>    </servlet>
>    <servlet-mapping>
>        <servlet-name>verificationCode</servlet-name>
>        <url-pattern>/verificationCode  </url-pattern>
>    </servlet-mapping>
>    ```
> 
>    3. 网页结果
>
>    ![](pictures/servlet/HttpServletResponse/验证码的生成.png)
>
> 4. 

#### 10.7.5 Response重定向

一个web资源收到客户端A请求后，B会通知A客户端去访问另外一个web资源C（这将会改变A访问的url），这个过程就叫做重定向。常见场景：**用户登录、注册**

```java
void sendRedirect(String var1) throws IOException;
```

> 1. `javaweb-01-servlet\response-01\src\main\java\com\phc\servlet\SendRedirectServlet.java`
>
>    ```java
>    package com.phc.servlet;
>    
>    import javax.servlet.ServletException;
>    import javax.servlet.http.HttpServlet;
>    import javax.servlet.http.HttpServletRequest;
>    import javax.servlet.http.HttpServletResponse;
>    import java.io.IOException;
>    
>    /**
>     * @FileName SendRedirectServlet.class
>     * @Description 重定向
>     * @Author phc
>     * @date 2022/12/3 9:38
>     * @Version 1.0
>     */
>    public class SendRedirectServlet extends HttpServlet {
>        @Override
>        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>            System.out.println("正在进行重定向...\n跳转页面中...");
>            String newUrl="verificationCode";
>            resp.sendRedirect(newUrl);
>        }
>    
>        @Override
>        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>            doGet(req, resp);
>        }
>    }
>    ```
>
> 2. `javaweb-01-servlet\response-01\src\main\webapp\WEB-INF\web.xml`
>
>    ```xml
>    <!--重定向-->
>    <servlet>
>        <servlet-name>redirect</servlet-name>
>        <servlet-class>com.phc.servlet.SendRedirectServlet</servlet-class>
>    </servlet>
>    <servlet-mapping>
>        <servlet-name>redirect</servlet-name>
>        <url-pattern>/redirect</url-pattern>
>    </servlet-mapping>
>    ```
>
> 3. 页面显示
>
>    ![](pictures/servlet/HttpServletResponse/重定向的页面url发生了改变.png)

##### 模拟登录

1. 文件结构

   ![](pictures/servlet/HttpServletResponse/登录页面文件结构.png)

2. `javaweb-01-servlet\response-01\src\main\webapp\index.jsp`

   登录信息表单收集页面

   ```jsp
   <html>
   <body>
   <h2>Hello World!</h2>
   
   <%--防止页面显示格式出现乱码--%>
   <%@ page contentType="text/html;charset=UTF-8" language="java" %>
   <%--这里提交的路径，需要寻找项目的路径--%>
   <%--${pageContext.request.contextPath}代表当前的项目--%>
   <form action="${pageContext.request.contextPath}/login" method="get">
       用户名:<input type="text" name="username" /> <br />
       密码:<input type="password" name="pwd" /> <br />
       <input type="submit" />
   </form>
   </body>
   </html>
   ```

3. `javaweb-01-servlet\response-01\src\main\webapp\WEB-INF\web.xml`

   表单处理映射配置

   ```xml
   <!--登录-->
   <!--将页面表单提交过来的登录信息交给LoginServlet.java处理-->
   <servlet>
       <servlet-name>login_handler</servlet-name>
       <servlet-class>com.phc.servlet.LoginServlet</servlet-class>
   </servlet>
   <servlet-mapping>
       <servlet-name>login_handler</servlet-name>
       <url-pattern>/login</url-pattern>
   </servlet-mapping>
   ```

4. `javaweb-01-servlet\response-01\src\main\java\com\phc\servlet\LoginServlet.java`

   表单处理页面

   ```java
   package com.phc.servlet;
   
   import javax.servlet.ServletException;
   import javax.servlet.http.HttpServlet;
   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;
   import java.io.IOException;
   
   /**
    * @FileName LoginServlet.java
    * @Description 登录信息处理
    * @Author phc
    * @date 2022/12/3 10:04
    * @Version 1.0
    */
   public class LoginServlet extends HttpServlet {
       @Override
       protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           System.out.println("登录页面信息处理中...");
           String username = req.getParameter("username");
           String pwd = req.getParameter("pwd");
   
           System.out.println(username+":"+pwd);
           //重定向的时候，一定要注意路径问题，否则可能会404
           String newUrl="login_success.jsp";
           resp.sendRedirect(newUrl);
       }
   
       @Override
       protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           doGet(req, resp);
       }
   }
   ```

5. `javaweb-01-servlet\response-01\src\main\webapp\login_success.jsp`

   登录成功页面

   ```jsp
   <%--
     Created by IntelliJ IDEA.
     User: PengHC
     Date: 2022/12/3
     Time: 10:16
     To change this template use File | Settings | File Templates.
   --%>
   <%@ page contentType="text/html;charset=UTF-8" language="java" %>
   <html>
   <head>
       <title>登录成功</title>
   </head>
       <h1>恭喜你,登录成功!</h1>
   <body>
   </body>
   </html>
   ```

6. 结果

   （1）登录表单信息收集

   ![](pictures/servlet/HttpServletResponse/登录表单信息收集.png)

   （2）重定向至登录成功页面

   ![](pictures/servlet/HttpServletResponse/重定向至登录成功页面.png)



## 10.8 HttpServletRequest

`HttpServletRequest`代表客户端的请求，用户通过`http`协议访问服务器，`HTTP`请求中的所有信息会被封装到`HttpServletRequest`中，通过`HttpServletRequest`这个方法，可以获取客户端的所有信息

#### 10.8.1 request实现请求转发（推荐）

> 1. `javaweb-01-servlet\request-01\src\main\webapp\index.jsp`
>
>    提交表单页面
>
>    ```jsp
>    <%--
>      Created by IntelliJ IDEA.
>      User: PengH
>      Date: 2022/12/4
>      Time: 9:34
>      To change this template use File | Settings | File Templates.
>    --%>
>    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
>    <html>
>    <head>
>        <title>登录</title>
>    </head>
>    <body>
>    <%--<div style="text-align: center">--%>
>    <div>
>        <%--以post方式提交表单到我们的login请求--%>
>        <form action="login" methods="post">
>            用户名:<input type="text" name="username" /> <br />
>            密码:<input type="password" name="pwd" /> <br />
>            爱好:
>            <input type="checkbox" name="hobbies" value="唱歌">唱歌 <br />
>            <input type="checkbox" name="hobbies" value="跳舞">跳舞 <br />
>            <input type="checkbox" name="hobbies" value="rap">rap <br />
>            <input type="checkbox" name="hobbies" value="篮球">篮球 <br />
>            <input type="checkbox" name="hobbies" value="javaweb">javaweb <br />
>            <input type="submit" />
>        </form>
>    </div>
>    </body>
>    </html>
>    ```
>
> 2. `javaweb-01-servlet\request-01\src\main\webapp\login_success.jsp`
>
>    登录成功页面
>
>    ```jsp
>    <%--
>      Created by IntelliJ IDEA.
>      User: PengH
>      Date: 2022/12/4
>      Time: 9:49
>      To change this template use File | Settings | File Templates.
>    --%>
>    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
>    <html>
>    <head>
>        <title>登录成功</title>
>    </head>
>    <body>
>    <h1>恭喜你,登录成功!</h1>
>    </body>
>    </html>
>    ```
>
> 3. `javaweb-01-servlet\request-01\src\main\java\com\phc\servlet\LoginServlet.java`
>
>    后端：表单处理和request实现请求转发
>
>    ```java
>    package com.phc.servlet;
>    import javax.servlet.ServletException;
>    import javax.servlet.http.HttpServlet;
>    import javax.servlet.http.HttpServletRequest;
>    import javax.servlet.http.HttpServletResponse;
>    import java.io.IOException;
>    import java.util.Arrays;
>    
>    /**
>        * @FileName LoginServlet.java
>        * @Description 使用请求转发完成登录操作
>        * @Author phc
>        * @date 2022/12/4 9:35
>        * @Version 1.0
>        */
>    public class LoginServlet extends HttpServlet {
>        @Override
>        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>            // 设置请求和响应编码,防止输出乱码
>            resp.setCharacterEncoding("utf-8");
>            req.setCharacterEncoding("utf-8");
>            String username = req.getParameter("username");
>            String password = req.getParameter("pwd");
>            // req.getParameterValues返回一个数组
>            String[] hobbies = req.getParameterValues("hobbies");
>            System.out.println("--------------------------------");
>            System.out.println(username+":"+password);
>            System.out.println("爱好:\n"+ Arrays.toString(hobbies));
>            System.out.println("--------------------------------");
>            // 通过请求转发
>            String new_url="/login_success.jsp";
>            req.getRequestDispatcher(new_url).forward(req,resp);
>            //        resp.sendRedirect(new_url);
>        }
>        @Override
>        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>            doGet(req, resp);
>        }
>    }
>
> 4. `javaweb-01-servlet\request-01\src\main\webapp\WEB-INF\web.xml`
>
>      页面配置
>
>    ```xml
>    <?xml version="1.0" encoding="UTF-8"?>
>    <!--tomcat 9.0.69使用的webapp版本为4.0-->
>    <!--web.xml是配置我们web的核心应用-->
>    <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
>             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
>             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
>                                 http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
>             version="4.0"
>             metadata-complete="true">
>    
>        <display-name>Welcome to Tomcat</display-name>
>        <description>
>            Welcome to Tomcat
>        </description>
>        <servlet>
>            <servlet-name>loginServlet</servlet-name>
>            <servlet-class>com.phc.servlet.LoginServlet</servlet-class>
>        </servlet>
>        <servlet-mapping>
>            <servlet-name>loginServlet</servlet-name>
>            <url-pattern>/login</url-pattern>
>        </servlet-mapping>
>    </web-app>
>    ```
>
> 5. 页面显示效果
>
>    ![](pictures/servlet/HttpServletRequest/request请求转发登录.png)

## 10.9 Cookie

### 10.9.1 如何建立有效会话
**会话：**用户打开一个浏览器，点击了很多超链接，访问了多个web资源，关闭浏览器，这个过程可以称之为会话。

**有状态会话：**一个同学曾经来过教室，下次再来的教室的时候，我们会知道这个同学，曾经来过，称之为有状态会话。

1. 例子：你怎么证明你是西开的学生？

   你 西开

   （1）发票：西开给你开发票
   （2）学校登记：西开标记你过来了
   类比：一个网站，怎么证明你来过？

   客户端 服务器

   （1）服务端给客户端一个 信件，客户端下次访问服务端带上信件就可以；cookie
   （2）服务器登记你过来了，下次你来的时候我来匹配你。session

2. 拓展：

   http是一个无状态的协议

   什么是无状态：就是说这次请求和上一次请求没有任何关系，互不认识。这种无状态的好处是快速。坏处是假如我们想要把www.zhihu.com/login.html和www.zhihu.com/index.html关联起来，必须使用某些手段和工具

### 10.9.2 会话保持的两种技术

**cookie**

- 客户端技术（响应，请求）

**session**

- 服务端技术，利用这个技术，我们可以保存用户的会话信息，我们可以把信息或者数据放在session中。

常见场景：

- 网站登录之后，你下次不用再登录了，第二次访问直接就上去了。

### 10.9.3 Cookie详解

> 1. 从请求中拿到`cookie`信息
>
> 2. 服务器响应给客户端`cookie`
>
>    ```java
>    Cookie[] cookies = req.getCookies();//获取cookie
>    cookie.getName();//获取cookie中的key
>    cookie.getValue();//获取cookie中的value
>    Cookie cookie = new Cookie("lastLoginTime", "" + System.currentTimeMillis());//新建一个cookie
>    cookie.setMaxAge(24*60*60);//设置cookie的有效期
>    resp.addCookie(cookie);//响应给客户端一个cookie
>    ```
>
>    **cookie：一般会保存在本地的用户目录下/AppData下**
>
>    
>
> 3. 一个网站cookie是否存在上限
>
>    >  一个cookie只能保存一个信息
>    > 一个web站点可以给浏览器发送多个cookie，每个web站点最多存放20个cookie（ 不同的浏览器会有所不同）
>    > cookie大小有限制4kb
>    > 浏览器上限是300个cookie
>
> 4. 删除cookie的方法
>
>    > 不设置有效期，关闭浏览器，自动失效
>    > 设置有效期时间为0

### 10.9.4 Demo实例

#### 1. 保存用户上一次的访问时间和中文字符

> 1. 文件结构
>
>    ![](pictures/Cookie/文件结构.png)
>
> 2. `javaweb-session-cookie\cookie_demo\src\main\webapp\WEB-INF\web.xml`
>
>    ```xml
>    <servlet>
>        <servlet-name>getLastLoginTime</servlet-name>
>        <servlet-class>com.phc.servlet.Demo01</servlet-class>
>    </servlet>
>    <servlet-mapping>
>        <servlet-name>getLastLoginTime</servlet-name>
>        <url-pattern>/getLastLoginTime</url-pattern>
>    </servlet-mapping>
>    ```
>
> 3. `javaweb-session-cookie\cookie_demo\src\main\java\com\phc\servlet\Demo01.java`
>
>    ```java
>    package com.phc.servlet;
>    
>    import javax.servlet.ServletException;
>    import javax.servlet.http.Cookie;
>    import javax.servlet.http.HttpServlet;
>    import javax.servlet.http.HttpServletRequest;
>    import javax.servlet.http.HttpServletResponse;
>    import java.io.IOException;
>    import java.io.PrintWriter;
>    import java.net.URLDecoder;
>    import java.net.URLEncoder;
>    import java.util.Date;
>    
>    /**
>     * @FileName Demo01.java
>     * @Description 保存用户上一次的访问时间和中文字符
>     * @Author phc
>     * @date 2022/12/9 10:21
>     * @Version 1.0
>     */
>    public class Demo01 extends HttpServlet {
>        @Override
>        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>            // 解决中文乱码
>            req.setCharacterEncoding("utf-8");
>            resp.setCharacterEncoding("utf-8");
>            resp.setHeader("Content-type","text/html;charset=utf-8");
>    
>            PrintWriter out = resp.getWriter();
>            // cookie 服务器从客户端中获取
>            Cookie[] cookies = req.getCookies(); // 这里返回一个数组,说明请求中可能含有多个cookie
>    
>            // 判断cookie是否为空
>            if(cookies!=null) {
>                //cookie存在
>                for(int i=0;i<cookies.length;i++) {
>                    Cookie cookie = cookies[i];
>                    // 获取cookie的键
>                    if(cookie.getName().equals("lastLoginTime")) {
>                        // 获取cookie的值
>                        String time = cookie.getValue();
>                        // 将字符串时间转换成日期标准格式
>                        Date date = new Date(Long.parseLong(time));
>                        out.write("你上次访问的时间:"+date.toString()+"\n");
>                    }else if(cookie.getName().equals("name")){
>                        //中文字符解码
>                        String name = URLDecoder.decode(cookie.getValue());
>                        out.write("姓名:"+name+"\n");
>                    }else {
>                        String key = cookie.getName();
>                        String value = cookie.getValue();
>                        out.write(key+":"+value+"\n");
>                    }
>                }
>            }else {
>                //cookie不存在
>                out.write("这是你第一次访问本站");
>            }
>            // 服务器给客户端响应一个cookie
>            Cookie cookie1 = new Cookie("lastLoginTime", System.currentTimeMillis()+"");// 键值对
>            // 向cookie中传入中文,需要先进行编码,在取出时进行解码
>            Cookie cookie2 = new Cookie("name", URLEncoder.encode("小超"));
>            // 设置cookie的有效期为1天
>            cookie1.setMaxAge(24*60*60);
>            cookie2.setMaxAge(24*60*60);
>            resp.addCookie(cookie1);
>            resp.addCookie(cookie2);
>        }
>    
>        @Override
>        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>            doGet(req, resp);
>        }
>    }
>    ```
>
> 4. 页面显示效果
>
>    ![](pictures/Cookie/Demo01.png)

#### 2. 设置cookie有效期为0,达到删除相应cookie的目的

> 1. `javaweb-session-cookie\cookie_demo\src\main\webapp\WEB-INF\web.xml`
>
>    ```xml
>    <servlet>
>        <servlet-name>deleteCookie</servlet-name>
>        <servlet-class>com.phc.servlet.Demo02</servlet-class>
>    </servlet>
>    <servlet-mapping>
>        <servlet-name>deleteCookie</servlet-name>
>        <url-pattern>/deleteNameCookie</url-pattern>
>    </servlet-mapping>
>    ```
>
> 2. `javaweb-session-cookie\cookie_demo\src\main\java\com\phc\servlet\Demo02.java`
>
>    ```java
>    package com.phc.servlet;
>                            
>    import javax.servlet.ServletException;
>    import javax.servlet.http.Cookie;
>    import javax.servlet.http.HttpServlet;
>    import javax.servlet.http.HttpServletRequest;
>    import javax.servlet.http.HttpServletResponse;
>    import java.io.IOException;
>                            
>    /**
>     * @FileName Demo02.java
>     * @Description 设置cookie有效期为0,达到删除相应cookie的目的
>     * @Author phc
>     * @date 2022/12/9 11:15
>     * @Version 1.0
>     */
>    public class Demo02 extends HttpServlet {
>        @Override
>        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>            //设置键为需要删除的cookie,达到覆盖之前cookie为name的目的
>            Cookie deleteNameCookie = new Cookie("name", "");
>            //设置cookie有效期为0,则cookie自动失效,并删除
>            deleteNameCookie.setMaxAge(0);
>            resp.addCookie(deleteNameCookie);
>        }
>                            
>        @Override
>        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>            doGet(req, resp);
>        }
>    }
>    ```

### 10.10 Session（重点）

#### 10.10.1 什么是session

>（1）服务器会给每一个用户（浏览器）创建一个session对象；
>
>（2）一个session独占一个浏览器，只要浏览器没有关闭，session就存在；
>
>（3）用户登录之后，整个网站它都可以访问。eg：保存用户的信息；保存购物车的信息

#### 10.10.2 实例

> 1. 文件结构
>
>    ![](pictures/session/文件结构.png)
>
> 2. `javaweb-session-cookie\session_demo\src\main\java\com\phc\servlet\Demo01.java`
>
>    （1）在session中存放name值
>
>    ```java
>    package com.phc.servlet;
>    
>    import javax.servlet.ServletException;
>    import javax.servlet.http.*;
>    import java.io.IOException;
>    
>    /**
>     * @FileName Demo01.java
>     * @Description 在session中存放name值
>     * @Author phc
>     * @date 2022/12/11 9:13
>     * @Version 1.0
>     */
>    public class Demo01 extends HttpServlet {
>        @Override
>        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>            // 解决页面中文乱码问题
>            req.setCharacterEncoding("utf-8");
>            resp.setCharacterEncoding("utf-8");
>            resp.setContentType("text/html;charset=utf-8");
>    
>            // 得到session
>            HttpSession session = req.getSession();
>            // 给session中存东西
>            session.setAttribute("name","小超");
>            // 获取sessionID
>            String sessionId = session.getId();
>    
>            // 判断session是不是新创建的
>            if(session.isNew()) {
>                resp.getWriter().write("session创建成功,sessionID:"+sessionId);
>            } else {
>                resp.getWriter().write("session已经在服务器中存在了,sessionID:"+sessionId);
>            }
>            // session创建的时候做了什么事情
>            //        Cookie cookie = new Cookie("JESSIONID", sessionId);
>            //        resp.addCookie(cookie);
>        }
>        @Override
>        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
>            doGet(req, resp);
>        }
>    }
>    ```
>
>    （2）取出session中存放的name值
>
>    ```java
>    // 得到session
>    HttpSession session = req.getSession();
>    // 取出name值
>    String name = (String)session.getAttribute("name");
>    resp.getWriter().write("name:"+name);
>    ```
>
>    （3）手动注销会话session
>
>    ```java
>    HttpSession session = req.getSession();
>    session.removeAttribute("name"); //移除name属性
>    session.invalidate();   //注销当前会话
>    ```
>
> 3. `javaweb-session-cookie\session_demo\src\main\webapp\WEB-INF\web.xml`
>
>    ```xml
>    <!--在session中创建name属性-->
>    <servlet>
>        <servlet-name>demo01</servlet-name>
>        <servlet-class>com.phc.servlet.Demo01</servlet-class>
>    </servlet>
>    <servlet-mapping>
>        <servlet-name>demo01</servlet-name>
>        <url-pattern>/demo01</url-pattern>
>    </servlet-mapping>
>    
>    <!--在session中获取name属性-->
>    <servlet>
>        <servlet-name>demo02</servlet-name>
>        <servlet-class>com.phc.servlet.Demo02</servlet-class>
>    </servlet>
>    <servlet-mapping>
>        <servlet-name>demo02</servlet-name>
>        <url-pattern>/demo02</url-pattern>
>    </servlet-mapping>
>    
>    <!--注销当前session会话-->
>    <servlet>
>        <servlet-name>demo03</servlet-name>
>        <servlet-class>com.phc.servlet.Demo03</servlet-class>
>    </servlet>
>    <servlet-mapping>
>        <servlet-name>demo03</servlet-name>
>        <url-pattern>/demo03</url-pattern>
>    </servlet-mapping>
>    
>    <!--在web配置端设置session失效时间-->
>    <session-config>
>        <!--失效时间以分钟为单位-->
>        <session-timeout>1</session-timeout>
>    </session-config>
>    ```
>
> 4. 页面显示结果：
>
>    ![](pictures/session/页面显示结果demo01.png)
>
>    ![页面显示结果demo02](pictures/session/页面显示结果demo02.png)

#### 10.10.3 session和cookie的区别

> 1. cookie是把用户的数据写给浏览器，浏览器保存（可以保存多个）；
> 2. session是把用户的数据写到用户独占的session中，服务器端保存（保存重要的信息，避免服务器的资源浪费）；
> 3. session由服务器创建
>
> ![](pictures/session/session和cookie的区别1.png)
>
> ![session和cookie的区别2](pictures/session/session和cookie的区别2.png)
>
> session使用场景：
>
> - 保存一个登录用户的信息
> - 购物车信息
> - 在整个网站中经常会使用的数据，我们会将它保存在session中

### 10.11 JSP

> 1. java server pages ：Java服务页端面，也和servlet一样，用于动态Web技术！
>
> 2. 最大的特点
>
>    （1）写JSP就像在写HTML
>
>    （2）区别：
>
>    * HTML只给用户提供静态的数据
>    * JSP页面中可以嵌入Java代码，为用户提供动态数据
>
> ![](pictures/JSP/jsp原理.png)

#### 10.11.1 JSP原理

> 思路：jsp到底怎么执行的？
>
> - 代码层面看不出啥（jsp）
>
> - 服务器内部工作
>
>   tomcat中有一个work目录
>
>   ![](pictures/JSP/被编译成一个java程序.png)
>
>   idea使用tomcat的时候会在idea的tomcat中生成一个work目录
>
>   ![](pictures/JSP/IDEA的tomcat工作空间.png)
>
>   发现jsp页面被转变成了java程序
>
>   ```path
>   C:\Users\PengH\AppData\Local\JetBrains\IntelliJIdea2021.3\tomcat\c9b1a7e0-7b78-460b-9642-3ced6045f66f\work\Catalina\localhost\session_demo_war\org\apache\jsp
>   ```
>
>   ![IDEA下编译的java程序](pictures/JSP/IDEA下编译的java程序.png)
>
>   **浏览器向服务器发送请求，不管访问什么资源，其实都是在访问servlet**
>
>   jsp最终也会被转换为一个java类
>
>   jsp本质上就是一个servlet
>
>   ```java
>   // 初始化
>   public void _jspInit() {
>   }
>   //销毁
>   public void _jspDestroy() {
>   }
>   //jspService
>   public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response) {
>       ...
>   }
>   ```
>
>     1. 全局pom.xml中导入jar包jasper-runtime
>
>      ```xml
>     <!--向pom.xml中导入jar包jasper-runtime-->
>      <!-- https://mvnrepository.com/artifact/tomcat/jasper-runtime -->
>      <dependency>
>          <groupId>tomcat</groupId>
>          <artifactId>jasper-runtime</artifactId>
>          <version>5.5.23</version>
>      </dependency>
>      ```
> 
>   2. java程序中导入HttpJspBase包
>
>           ```java
>       import org.apache.jasper.runtime.HttpJspBase;
>      ```
>
>   3. 查看HttpJspBase类
> 
>      ```java
>       public abstract class HttpJspBase extends HttpServlet implements HttpJspPage {
>               protected HttpJspBase() {
>         }
>          ...
>       }
>      ```
> 

#### 10.11.2 index_jsp.java源码分析

1. **在jsp页面中只要是java代码就会原封不动的输出，若是html页面，则通过out.write（）输出**

   ![](pictures/JSP/html页面通过out输出.png)

2. 内置的一些对象

   ```java
   // 这些对象我们可以在jsp页面中直接使用
   final javax.servlet.jsp.PageContext pageContext;	//页面上下文
   javax.servlet.http.HttpSession session = null;	//session
   final javax.servlet.ServletContext application;	//applicationContext
   final javax.servlet.ServletConfig config;	//config
   javax.servlet.jsp.JspWriter out = null;	//out打印
   final java.lang.Object page = this;	//当前页面
   javax.servlet.jsp.JspWriter _jspx_out = null;
   javax.servlet.jsp.PageContext _jspx_page_context = null;
   final javax.servlet.http.HttpServletRequest request;	//请求
   final javax.servlet.http.HttpServletResponse response;	//响应
   ```

   

3. 输出页面前所做的事情

   ```java
   //初始化
   response.setContentType("text/html;charset=UTF-8");
   pageContext = _jspxFactory.getPageContext(this, request, response,
                                             null, true, 8192, true);
   _jspx_page_context = pageContext;
   application = pageContext.getServletContext();
   config = pageContext.getServletConfig();
   session = pageContext.getSession();
   out = pageContext.getOut();
   _jspx_out = out;
   ```

4. 实例测试

   （1）`javaweb-session-cookie\session_demo\src\main\webapp\hello.jsp`

   ```jsp
   <%--
     Created by IntelliJ IDEA.
     User: PengHC
     Date: 2022/12/14
     Time: 10:58
     To change this template use File | Settings | File Templates.
   --%>
   <%@ page contentType="text/html;charset=UTF-8" language="java" %>
   <html>
   <head>
       <title>你好</title>
   </head>
   <body>
   <%--输入java代码--%>
   <%
       String name="小超";
   %>
   <h1>name:<%= name %></h1>
   </body>
   </html>
   
   ```

   （2）hello.jsp先转换成java后编译成class文件的结果：

   ```java
   /*
    * Generated by the Jasper component of Apache Tomcat
    * Version: Apache Tomcat/9.0.69
    * Generated at: 2022-12-14 03:09:05 UTC
    * Note: The last modified time of this file was set to
    *       the last modified time of the source file after
    *       generation to assist with modification tracking.
    */
   package org.apache.jsp;
   
   import javax.servlet.*;
   import javax.servlet.http.*;
   import javax.servlet.jsp.*;
   
   public final class hello_jsp extends org.apache.jasper.runtime.HttpJspBase
       implements org.apache.jasper.runtime.JspSourceDependent,
                    org.apache.jasper.runtime.JspSourceImports {
   
     private static final javax.servlet.jsp.JspFactory _jspxFactory =
             javax.servlet.jsp.JspFactory.getDefaultFactory();
   
     private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;
   
     private static final java.util.Set<java.lang.String> _jspx_imports_packages;
   
     private static final java.util.Set<java.lang.String> _jspx_imports_classes;
   
     static {
       _jspx_imports_packages = new java.util.HashSet<>();
       _jspx_imports_packages.add("javax.servlet");
       _jspx_imports_packages.add("javax.servlet.http");
       _jspx_imports_packages.add("javax.servlet.jsp");
       _jspx_imports_classes = null;
     }
   
     private volatile javax.el.ExpressionFactory _el_expressionfactory;
     private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;
   
     public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
       return _jspx_dependants;
     }
   
     public java.util.Set<java.lang.String> getPackageImports() {
       return _jspx_imports_packages;
     }
   
     public java.util.Set<java.lang.String> getClassImports() {
       return _jspx_imports_classes;
     }
   
     public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
       if (_el_expressionfactory == null) {
         synchronized (this) {
           if (_el_expressionfactory == null) {
             _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
           }
         }
       }
       return _el_expressionfactory;
     }
   
     public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
       if (_jsp_instancemanager == null) {
         synchronized (this) {
           if (_jsp_instancemanager == null) {
             _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
           }
         }
       }
       return _jsp_instancemanager;
     }
   
     public void _jspInit() {
     }
   
     public void _jspDestroy() {
     }
   
     public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
         throws java.io.IOException, javax.servlet.ServletException {
   
       if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
         final java.lang.String _jspx_method = request.getMethod();
         if ("OPTIONS".equals(_jspx_method)) {
           response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
           return;
         }
         if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
           response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
           response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS");
           return;
         }
       }
   
       final javax.servlet.jsp.PageContext pageContext;
       javax.servlet.http.HttpSession session = null;
       final javax.servlet.ServletContext application;
       final javax.servlet.ServletConfig config;
       javax.servlet.jsp.JspWriter out = null;
       final java.lang.Object page = this;
       javax.servlet.jsp.JspWriter _jspx_out = null;
       javax.servlet.jsp.PageContext _jspx_page_context = null;
   
   
       try {
         response.setContentType("text/html;charset=UTF-8");
         pageContext = _jspxFactory.getPageContext(this, request, response,
         			null, true, 8192, true);
         _jspx_page_context = pageContext;
         application = pageContext.getServletContext();
         config = pageContext.getServletConfig();
         session = pageContext.getSession();
         out = pageContext.getOut();
         _jspx_out = out;
   
         out.write("\r\n");
         out.write("\r\n");
         out.write("<html>\r\n");
         out.write("<head>\r\n");
         out.write("    <title>你好</title>\r\n");
         out.write("</head>\r\n");
         out.write("<body>\r\n");
         out.write("\r\n");
         out.write('\r');
         out.write('\n');
   
       String name="小超";
   
         out.write("\r\n");
         out.write("\r\n");
         out.write("name:");
         out.print( name );
         out.write("\r\n");
         out.write("</body>\r\n");
         out.write("</html>\r\n");
       } catch (java.lang.Throwable t) {
         if (!(t instanceof javax.servlet.jsp.SkipPageException)){
           out = _jspx_out;
           if (out != null && out.getBufferSize() != 0)
             try {
               if (response.isCommitted()) {
                 out.flush();
               } else {
                 out.clearBuffer();
               }
             } catch (java.io.IOException e) {}
           if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
           else throw new ServletException(t);
         }
       } finally {
         _jspxFactory.releasePageContext(_jspx_page_context);
       }
     }
   }
   ```

#### 10.11.3 jsp基础语法和指令

> 任何语言都有自己的语法，java有，jsp作为java技术的一种应用，它拥有一些自己扩充的语法（了解，知道即可），java所有语法都支持。
>
> 1. 新建一个`maven`模板项目`javaweb-jsp`
>
> 2. 文件结构
>
>    ![](pictures/JSP/页面结构.png)
>
> 3. `pom.xml`导入依赖包
>
>    ```xml
>    <dependencies>
>        <!--servlet依赖-->
>        <dependency>
>            <groupId>javax.servlet</groupId>
>            <artifactId>javax.servlet-api</artifactId>
>            <version>4.0.1</version>
>            <!--取消作用域-->
>            <!--<scope>provided</scope>-->
>        </dependency>
>       
>        <!--向pom.xml中导入jar包jasper-runtime-->
>        <!-- https://mvnrepository.com/artifact/tomcat/jasper-runtime -->
>        <dependency>
>            <groupId>tomcat</groupId>
>            <artifactId>jasper-runtime</artifactId>
>            <version>5.5.23</version>
>        </dependency>
>       
>        <!--jsp依赖-->
>        <dependency>
>            <groupId>javax.servlet.jsp</groupId>
>            <artifactId>javax.servlet.jsp-api</artifactId>
>            <version>2.3.3</version>
>        </dependency>
>       
>        <!--jsp表达式的依赖-->
>        <!-- https://mvnrepository.com/artifact/javax.servlet.jsp.jstl/jstl-api -->
>        <dependency>
>            <groupId>javax.servlet.jsp.jstl</groupId>
>            <artifactId>jstl-api</artifactId>
>            <version>1.2</version>
>        </dependency>
>       
>        <!--standard标签库-->
>        <dependency>
>            <groupId>taglibs</groupId>
>            <artifactId>standard</artifactId>
>            <version>1.1.2</version>
>        </dependency>
>    </dependencies>
>    ```

##### 1. jsp表达式和jsp脚本片段

```jsp
<%--
  Created by IntelliJ IDEA.
  User: PengH
  Date: 2022/12/18
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>标题</title>
</head>
<body>

<h1>你好,JSP</h1>
<%--这是一个注释--%>

<%--
JSP表达式
作用:用来将程序输出到客户端
格式:<%= 变量或者表达式>
--%>
北京时间:<%= new java.util.Date()%>
<hr />

<%--jsp脚本片段--%>
<%
    int sum=0;
    for(int i=0;i<=100;i++) {
        sum+=i;
    }
    out.println("0-100求和后的值为:"+sum);
%>

<%--jsp与html标签相互嵌套--%>
<%
    for(int i=0;i<5;i++) {
%>
<p><%=(i+1)%>.我是嵌套进jsp的html标签</p>
<%
    }
%>

</body>
</html>
```

![](pictures/JSP/jsp表达式和jsp脚本片段.png)

##### 2. jsp全局声明

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP全局声明</title>
</head>
<body>

<%!
    static {
        System.out.println("servlet loading...");
    }
    private String global_var = "PHC";
    public void print() {
        System.out.println("进入了print方法体");
    }
%>

<%
    // 调用print方法
    print();
%>

<%--这是JSP的注释--%>
<!--这是HTML标签的注释-->

</body>
</html>
```

jsp声明，会被编译到jsp生成java代码的类中！其他的，就会被生成到_jspService方法中！

![](pictures/JSP/jsp声明1.png)

![jsp声明2](pictures/JSP/jsp声明2.png)

在jsp，嵌入java代码即可

```jsp
<%%>
<%=%>
<%!%>
<%--注释--%>
```

jsp注释和html注释的区别

```jsp
<%--这是JSP的注释--%>
<!--这是HTML标签的注释-->
```

![](pictures/JSP/jsp注释和html注释的区别.png)

发现：jsp的注释，不会在客户端显示，html会！

##### 3. JSP指令

错误页面定制

`javaweb-jsp\src\main\webapp\WEB-INF\web.xml`

```xml
<error-page>
    <location>/error/switch_to_404.jsp</location>
    <error-code>404</error-code>
</error-page>
<error-page>
    <location>/error/switch_to_500.jsp</location>
    <error-code>500</error-code>
</error-page>
```

（1）服务器500错误

`javaweb-jsp\src\main\webapp\Demo02.jsp`

   ```jsp
   <%@ page contentType="text/html;charset=UTF-8" language="java" %>
   <html>
   <head>
       <title>JSP指令</title>
   </head>
   <body>
   
   <%
       // 会报告500错误(服务器端出错)
       int error = 1/0;
   %>
   
   </body>
   </html>
   ```

`javaweb-jsp\src\main\webapp\error\switch_to_500.jsp`

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>服务器崩溃</title>
</head>
<body>
<img src="./img/error_500.png" alt="页面500">
</body>
</html>
```

![](pictures/JSP/服务器500错误.png)

（2）页面找不到404错误

![](pictures/JSP/页面找不到404.png)

#### 10.11.4 引用公共页面

1. `Footer.jsp`

   ```jsp
   <%@ page contentType="text/html;charset=UTF-8" language="java" %>
   <html>
   <head>
       <title>页面尾部</title>
   </head>
   <body>
   <h1>我是Footer</h1>
   </body>
   </html>
   ```

2. `Header.jsp`

   ```jsp
   <%@ page contentType="text/html;charset=UTF-8" language="java" %>
   <html>
   <head>
       <title>页面头部</title>
   </head>
   <body>
   <h1>我是Header</h1>
   </body>
   </html>
   ```

3. `javaweb-jsp\src\main\webapp\Demo03.jsp`

   ```jsp
   <%@ page contentType="text/html;charset=UTF-8" language="java" %>
   <html>
   <head>
       <title>使用公共页面</title>
   </head>
   
   <body>
   <%--
   %@include会将两个页面合二为一,需要注意页面合并后的冲突(比如两个页面都定义了int i = 10,这种会报错)
   --%>
   <%@include file="common_pages/Header.jsp"%>
   <h1>网页主体</h1>
   <%@include file="common_pages/Footer.jsp"%>
   
   
   <%--jsp标签
   jsp:include 拼接页面,本质还是三个独立的文件,推荐使用这种,这种不会出现上面的int i=10冲突的情况,因为本质还是三个页面
   --%>
   <jsp:include page="../common_pages/Header.jsp" />
   <h1>网页主体</h1>
   <jsp:include page="../common_pages/Footer.jsp"></jsp:include>
   
   </body>
   </html>
   ```

   ![](pictures/JSP/引用公共页面.png)

   分析一下源码

   ![](pictures/JSP/引用公共页面源码1.png)

   ![引用公共页面源码2](pictures/JSP/引用公共页面源码2.png)

4. 
