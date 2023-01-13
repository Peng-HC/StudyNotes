package com.phc.dao;

import com.phc.pojo.Student;
import com.phc.pojo.Teacher;
import com.phc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @FileName MyTest.java
 * @Description 测试类
 * @Author phc
 * @date 2023/1/13 11:23
 * @Version 1.0
 */
public class MyTest {
    @Test
    public void getTeacherById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacherById(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void getStudentTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.getStudent();
        for(Student student:students) {
            System.out.println(student);
        }
    }

    @Test
    public void getStudentTest2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.getStudent2();
        for(Student student:students) {
            System.out.println(student);
        }
    }
}
