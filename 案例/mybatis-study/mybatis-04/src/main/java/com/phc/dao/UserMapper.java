package com.phc.dao;

import com.phc.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @FileName UserMapper.java
 * @Description 使用注解+接口实现CRUD
 * @Author phc
 * @date 2023/1/12 21:03
 * @Version 1.0
 */
public interface UserMapper {
    //增
    @Insert("insert into mybatis.user(id,name,pwd) values (#{id},#{name},#{pwd})")
    int addUser(User user);

    //删
    @Delete("delete from mybatis.user where id=#{uid}")
    int deleteUser(@Param("uid") int id);

    //改
    @Update("update user set name=#{name},pwd=#{pwd} where id=#{id}")
    int updateUser(User user);

    //查
    @Select("select * from mybatis.user")
    List<User> getUsers();
}
