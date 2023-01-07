# Mybatis学习笔记

推荐笔记：[【狂神说】Mybatis学习笔记（全）](https://blog.csdn.net/weixin_52200256/article/details/126611600)

推荐视频：[【狂神说Java】Mybatis最新完整教程IDEA版通俗易懂_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1NE411Q7Nx/?spm_id_from=333.337.search-card.all.click&vd_source=3e10f7e5d3cf396ddb49835c00d21a43)

## 一、简介

![](pictures/1-简介/Mybatis图标.png)

### 1.1 什么是Mybatis

（1）MyBatis 是一款优秀的持久层框架

（2）它支持自定义 SQL、存储过程以及高级映射

（3）MyBatis 免除了几乎所有的 JDBC 代码以及设置参数和获取结果集

（4）MyBatis 可以通过简单的 XML 或注解来配置和映射原始类型、接口和 Java POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。

（5）Mybatis现迁移到GitHub

### 1.2 如何获得Mybatis

1. Maven仓库：https://mvnrepository.com/

   ```xml
   <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
   <dependency>
       <groupId>org.mybatis</groupId>
       <artifactId>mybatis</artifactId>
       <version>3.5.6</version>
   </dependency>
   ```

2. GitHub：https://github.com/mybatis/mybatis-3

3. 官方文档：https://mybatis.org/mybatis-3/zh/index.html

### 1.3 持久化与持久层

#### 1.3.1 持久化

> 1. 数据持久化
>    - 持久化就是将程序的数据在持久状态和瞬时状态转化的过程
>    - 内存：**断电即失**
>    - 数据库（jdbc）,io文件持久化
>    - 生活结合：冰箱冷藏
> 2. 为什么需要持久化
>    - 有一些对象，不能让他丢掉，需要永久保存下来
>    - 内存太贵

#### 1.3.2 持久层

> Dao层，Service层，Controller层…
>
> - 完成持久化工作的代码块
> - 层与层之间的界限是十分明显的

### 1.4 为什么需要Mybatis

1. 帮助程序员将数据存入到数据库中

2. 方便

3. 传统的jdbc代码太复杂了，简化代码，形成框架。----自动化

4. 不使用MyBatis也可以，更容易上手

5. 优点

   > （1）简单易学：本身就很小且简单。没有任何第三方依赖，最简单安装只要两个jar文件+配置几个sql映射文件。易于学习，易于使用。通过文档和源代码，可以比较完全的掌握它的设计思路和实现。
   >
   > （2）灵活：mybatis不会对应用程序或者数据库的现有设计强加任何影响。 sql写在xml里，便于统一管理和优化。通过sql语句可以满足操作数据库的所有需求。
   >
   > （3）解除sql与程序代码的耦合：通过提供DAO层，将业务逻辑和数据访问逻辑分离，使系统的设计更清晰，更易维护，更易单元测试。sql和代码的分离，提高了可维护性。
   >
   > （4）提供映射标签，支持对象与数据库的orm字段关系映射。
   >
   > （5）提供对象关系映射标签，支持对象关系组建维护。
   >
   > （6）提供xml标签，支持编写动态sql。

## 二、第一个Mybatis程序

  思路：搭建环境—>导入Mybatis—>编写代码---->测试

### 2.1 搭建环境

#### 2.1.1 创建数据库

新建myBatis数据库创建user表添加数据（这里使用Navicat）

```sql
CREATE DATABASE IF NOT EXISTS `mybatis`;
USE `mybatis`;

CREATE TABLE IF NOT EXISTS `user` (
	`id` INT(20) NOT NULL,
	`name` VARCHAR(30) DEFAULT NULL,
	`pwd` VARCHAR(30) DEFAULT NULL,
	PRIMARY KEY(`id`)
)ENGINE=INNODB CHARACTER SET=utf8mb4;

INSERT INTO `user` (`id`,`name`,`pwd`) VALUES
(1,"小兰","123"),
(2,"柯南","12345"),
(3,"小明","123456")
```

#### 2.1.2 新建项目

1. 新建一个普通的Maven项目

2. 删除src目录

   ![](pictures/2-第一个Mybatis程序/父项目文件结构.png)

3. 导入maven依赖

   `mybatis-study\pom.xml`

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
       <modelVersion>4.0.0</modelVersion>
   
       <!--父工程-->
       <groupId>com.phc</groupId>
       <artifactId>mybatis-study</artifactId>
       <version>1.0-SNAPSHOT</version>
   
       <!--导入依赖-->
       <dependencies>
           <!--mysql驱动-->
           <dependency>
               <groupId>mysql</groupId>
               <artifactId>mysql-connector-java</artifactId>
               <version>8.0.30</version>
           </dependency>
           <!--mybatis依赖包-->
           <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
           <dependency>
               <groupId>org.mybatis</groupId>
               <artifactId>mybatis</artifactId>
               <version>3.5.6</version>
           </dependency>
           <!--junit测试包-->
           <dependency>
               <groupId>junit</groupId>
               <artifactId>junit</artifactId>
               <version>4.13.2</version>
           </dependency>
       </dependencies>
   </project>
   ```

### 2.2 创建普通的maven模块

#### 2.2.1 编写mybatis的核心配置文件

`mybatis-study\mybatis-01\src\main\resources\mybatis-config.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!--mybatis核心配置文件-->
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=false&amp;useUnicode=true&amp;characterEncoding=UTF-8"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    </environments>
    <!--每一个Mapper.xml都需要在MyBatis核心配置文件中注册-->
    <mappers>
        <mapper resource="com/qjd/dao/UserMapper.xml"/>
    </mappers>
</configuration>
```

#### 2.2.2 编写mybatis的工具类

`mybatis-study\mybatis-01\src\main\java\com\phc\utils\MybatisUtils.java`

```java
package com.phc.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @FileName MybatisUtils.java
 * @Description 创建sqlSessionFactory,获得sqlSession
 * @Author phc
 * @date 2023/1/7 11:13
 * @Version 1.0
 */
//sqlSessionFactory ---> sqlSession
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            //这是使用mybatis的第一步:获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
    // SqlSession 提供了在数据库执行 SQL 命令所需的所有方法
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
```

### 2.3 编写代码

#### 2.3.1 实体类

`mybatis-study\mybatis-01\src\main\java\com\phc\pojo\User.java`

```java
package com.phc.pojo;
/**
 * @FileName User.java
 * @Description 实体类,实现数据库mybatis的User表
 * @Author phc
 * @date 2023/1/7 15:35
 * @Version 1.0
 */
public class User {
    private int id;
    private String name;
    private String pwd;
    //构造函数
    public User() {
    }
    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }
    //getter与setter方法
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", pwd='" + pwd + '\'' +
            '}';
    }
}
```

#### 2.3.2 Dao接口

`mybatis-study\mybatis-01\src\main\java\com\phc\dao\UserDao.java`

```java
package com.phc.dao;
import com.phc.pojo.User;
import java.util.List;
/**
 * @FileName UserDao.java
 * @Description UserDao接口
 * @Author phc
 * @date 2023/1/7 15:40
 * @Version 1.0
 */
public interface UserDao {
    List<User> getUserList();
}
```

#### 2.3.3 `Mapper`配置文件

`mybatis-study\mybatis-01\src\main\java\com\phc\dao\UserMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!--namespace:绑定一个Dao/Mapper接口,这里是绑定UserDao接口-->
<mapper namespace="com.phc.dao.UserDao">
    <!--select查询语句,id对应namespace中接口里的方法名,resultType对应返回值的类型-->
    <select id="getUserList" resultType="com.phc.pojo.User">
        select * from mybatis.user
    </select>
</mapper>
```

### 2.4 测试

`mybatis-study\mybatis-01\src\test\java\com\phc\dao\UserDaoTest.java`

```java
package com.phc.dao;

import com.phc.pojo.User;
import com.phc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @FileName UserDaoTest.java
 * @Description 测试第一个mybatis代码
 * @Author phc
 * @date 2023/1/7 15:47
 * @Version 1.0
 */
public class UserDaoTest {
    @Test
    public void test() {
        //1.获取SqlSessionFactory对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一:getMapper(推荐)
        //2.执行sql
        UserDao userDaoMapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDaoMapper.getUserList();
//        //方式二:selectList(不推荐)
//        List<User> userList = sqlSession.selectList("com.phc.dao.UserDao.getUserList");
        for(User user:userList) {
            System.out.println(user);
        }
        //3.关闭SqlSession
        sqlSession.close();
    }
}
```

1. 文件结构

   ![](pictures/2-第一个Mybatis程序/第一个mybatis的文件结构.png)

2. 执行结果

   ![](pictures/2-第一个Mybatis程序/执行成功!.png)

### 2.5 错误分析

#### 2.5.1 错误一

1. 错误描述：`org.apache.ibatis.binding.BindingException: Type interface com.phc.dao.UserDao is not known to the MapperRegistry.`

2. 问题原因：每一个`Mapper.xml`都需要在`MyBatis`核心配置文件中注册才能生效！

3. 问题解决：

   在核心配置文件（`mybatis-config.xml`）中注册Mappers

   `mybatis-study\mybatis-01\src\main\resources\mybatis-config.xml`

   ```xml
   <!--每一个Mapper.xml都需要在MyBatis核心配置文件中注册-->
   <mappers>
       <mapper resource="com/phc/dao/UserMapper.xml"/>
   </mappers>
   ```

#### 2.5.2 错误二

1. 错误描述：`org.apache.ibatis.builder.BuilderException: Error parsing SQL Mapper Configuration. Cause: java.io.IOException: Could not find resource com/phc/dao/UserMapper.xml`

2. 问题原因：`maven`导出资源是时默认只会导出`resources`文件夹下的资源文件，要导出`java`文件夹下的资源文件，需要在`pom`文件中声明！

3. 问题解决：

   `mybatis-study\pom.xml`

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
           </resource>
           <resource>
               <directory>src/main/java</directory>
               <includes>
                   <include>**/*.properties</include>
                   <include>**/*.xml</include>
               </includes>
           </resource>
       </resources>
   </build>
   ```

#### 2.5.3 还可能存在的问题

1. `Mapper`配置文件没有注册（错误一）
2. 绑定接口错误
3. 方法名不对
4. 返回类型不对
5. maven导出资源问题（错误二）

## 三、CRUD

增删改查

```xml
<!--namespace:绑定一个Dao/Mapper接口,这里是绑定UserMapper接口-->
<mapper namespace="com.phc.dao.UserMapper">
```

1. namespace

   namespace中的包名要和接口中的包名一致：uesrDao–>userMapper

2. select（查询）

   ```xml
   <!--parameterType:方法参数类型-->
   <select id="getUserById" parameterType="int" resultType="com.phc.pojo.User" >
       select * from mybatis.user where id=#{id};
   </select>
   ```

   选择查询语句：

   - id就是对应的namespace中的方法名
   - resultType就是Sql语句执行的返回值
   - parameterType就是参数类型

3. 增（create）删（delete）改（update）

   **注意：增删改需要提交事务才能对数据库进行操作**

   > （1）编写接口
   >
   > `mybatis-study\mybatis-01\src\main\java\com\phc\dao\UserMapper.java`
   >
   > ```java
   > package com.phc.dao;
   > import com.phc.pojo.User;
   > import java.util.List;
   > /**
   >  * @FileName UserDao.java
   >  * @Description UserDao接口
   >  * @Author phc
   >  * @date 2023/1/7 15:40
   >  * @Version 1.0
   >  */
   > public interface UserMapper {
   >     //查询全部用户
   >     List<User> getUserList();
   > 
   >     //根据ID查询用户
   >     User getUserById(int id);
   > 
   >     //增加(insert)一个用户
   >     int addUser(User user);
   > 
   >     //修改用户属性
   >     int updateUser(User user);
   > 
   >     //根据ID删除用户
   >     int deleteUser(int id);
   > }
   > ```
   >
   > （2）写对应Mapper中的sql语句
   >
   > `mybatis-study\mybatis-01\src\main\java\com\phc\dao\UserMapper.xml`
   >
   > ```xml
   > <!--parameterType:方法参数类型-->
   > <select id="getUserById" parameterType="int" resultType="com.phc.pojo.User" >
   >     select * from mybatis.user where id=#{id};
   > </select>
   > 
   > <!--增:sql为insert时标签也需要为insert-->
   > <insert id="addUser" parameterType="com.phc.pojo.User">
   >     <!--对象中的属性可以直接取出来-->
   >     insert into mybatis.user(id,name,pwd) values (#{id},#{name},#{pwd});
   > </insert>
   > 
   > <!--改-->
   > <update id="updateUser" parameterType="com.phc.pojo.User" >
   >     update mybatis.user set name=#{name},pwd=#{pwd} where id=#{id};
   > </update>
   > 
   > <!--删-->
   > <delete id="deleteUser" parameterType="int" >
   >     delete from mybatis.user where id=#{id};
   > </delete>
   > ```
   >
   > （3）测试
   >
   > `mybatis-study\mybatis-01\src\test\java\com\phc\dao\UserDaoTest.java`
   >
   > ```java
   > @Test
   > public void getUserByIdTest() {
   >     //获取SqlSessionFactory对象
   >     SqlSession sqlSession = MybatisUtils.getSqlSession();
   >     //拿到UserMapper类
   >     UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
   >     //执行UserMapper类中的方法
   >     User user = userMapper.getUserById(2);
   >     System.out.println(user);
   >     sqlSession.close();
   > }
   > 
   > //增删改查需要提交事务,不提交事务即使不报错也不能将修改后的值插入到数据库的表中
   > @Test
   > public void addUserTest() {
   >     SqlSession sqlSession = MybatisUtils.getSqlSession();
   >     UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
   >     int affectRows = userMapper.addUser(new User(5,"小黄","1111"));
   >     if(affectRows>0) {
   >         System.out.println("插入成功!影响了"+affectRows+"行");
   >     } else {
   >         System.out.println("插入失败!");
   >     }
   >     //提交事务
   >     sqlSession.commit();
   >     sqlSession.close();
   > }
   > 
   > @Test
   > public void updateUserTest() {
   >     SqlSession sqlSession = MybatisUtils.getSqlSession();
   >     UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
   >     int affectRows = userMapper.updateUser(new User(3, "phc", "666"));
   >     if(affectRows>0) {
   >         System.out.println("修改成功!影响了"+affectRows+"行");
   >     } else {
   >         System.out.println("修改失败!");
   >     }
   >     sqlSession.commit();
   >     sqlSession.close();
   > }
   > 
   > @Test
   > public void deleteUserTest() {
   >     SqlSession sqlSession = MybatisUtils.getSqlSession();
   >     UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
   >     int deleteUserById = 5;
   >     int affectRows = userMapper.deleteUser(deleteUserById);
   >     if(affectRows>0) {
   >         System.out.println("删除成功!影响了"+affectRows+"行,删除的用户ID为"+deleteUserById);
   >     } else {
   >         System.out.println("删除ID为"+deleteUserById+"的用户失败!");
   >     }
   >     sqlSession.commit();
   >     sqlSession.close();
   > }
   > ```

   

   
