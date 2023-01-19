package com.phc.dao;

import com.phc.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @FileName TeacherMapper.i
 * @Description 教师类接口
 * @Author phc
 * @date 2023/1/13 11:06
 * @Version 1.0
 */
public interface TeacherMapper {
    //获取老师
    List<Teacher> getTeachers();

    //获取指定老师下的所有学生及老师自己的信息
    Teacher getTeacherById(@Param("tid") int id);
}
