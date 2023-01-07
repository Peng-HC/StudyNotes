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
    public void getUserListTest() {
        //1.获取SqlSessionFactory对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一:getMapper(推荐)
        //2.执行sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
//        //方式二:selectList(不推荐)
//        List<User> userList = sqlSession.selectList("com.phc.dao.UserDao.getUserList");
        for(User user:userList) {
            System.out.println(user);
        }
        //3.关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserByIdTest() {
        //获取SqlSessionFactory对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //拿到UserMapper类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //执行UserMapper类中的方法
        User user = userMapper.getUserById(2);
        System.out.println(user);
        sqlSession.close();
    }

    //增删改查需要提交事务,不提交事务即使不报错也不能将修改后的值插入到数据库的表中
    @Test
    public void addUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int affectRows = userMapper.addUser(new User(5,"小黄","1111"));
        if(affectRows>0) {
            System.out.println("插入成功!影响了"+affectRows+"行");
        } else {
            System.out.println("插入失败!");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int affectRows = userMapper.updateUser(new User(3, "phc", "666"));
        if(affectRows>0) {
            System.out.println("修改成功!影响了"+affectRows+"行");
        } else {
            System.out.println("修改失败!");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int deleteUserById = 5;
        int affectRows = userMapper.deleteUser(deleteUserById);
        if(affectRows>0) {
            System.out.println("删除成功!影响了"+affectRows+"行,删除的用户ID为"+deleteUserById);
        } else {
            System.out.println("删除ID为"+deleteUserById+"的用户失败!");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
