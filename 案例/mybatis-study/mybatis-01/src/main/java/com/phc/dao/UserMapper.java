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
public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);

    //增加(insert)一个用户
    int addUser(User user);

    //修改用户属性
    int updateUser(User user);

    //根据ID删除用户
    int deleteUser(int id);
}
