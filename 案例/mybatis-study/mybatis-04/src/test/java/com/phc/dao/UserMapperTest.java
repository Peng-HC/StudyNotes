package com.phc.dao;

import com.phc.pojo.User;
import com.phc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @FileName UserMapperTest.java
 * @Description 使用注解开发
 * @Author phc
 * @date 2023/1/12 17:30
 * @Version 1.0
 */
public class UserMapperTest {
    //增
    @Test
    public void addUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int affectRows = userMapper.addUser(new User(7, "小黑子", "7777777"));
        if(affectRows>0) {
            System.out.println("添加用户成功!");
        } else {
            System.out.println("添加用户失败!");
        }
        sqlSession.close();
    }
    //删
    @Test
    public void deleteUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int affectRows = userMapper.deleteUser(7);
        if(affectRows>0) {
            System.out.println("删除用户成功!");
        } else {
            System.out.println("删除用户失败!");
        }
        sqlSession.close();
    }
    //改
    @Test
    public void updateUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int affectRows = userMapper.updateUser(new User(7, "小霍", "134134"));
        if(affectRows>0) {
            System.out.println("修改用户成功!");
        } else {
            System.out.println("修改用户失败!");
        }
        sqlSession.close();
    }
    //查
    @Test
    public void getUsersTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getUsers();
        for(User user:users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
