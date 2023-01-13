package com.phc.dao;

import com.phc.pojo.Student;

import java.util.List;

/**
 * @FileName StudentMapper.i
 * @Description 学生类接口
 * @Author phc
 * @date 2023/1/13 11:06
 * @Version 1.0
 */
public interface StudentMapper {
    //查询所有的学生的信息,以及对应的老师信息
    //SELECT s.id,s.name,t.name from student s,teacher t where s.tid=t.id;
    public List<Student> getStudent();

    //根据结果集查询
    public List<Student> getStudent2();
}
