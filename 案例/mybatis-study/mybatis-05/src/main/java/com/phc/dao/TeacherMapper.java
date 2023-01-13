package com.phc.dao;

import com.phc.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @FileName TeacherMapper.i
 * @Description 教师类接口
 * @Author phc
 * @date 2023/1/13 11:06
 * @Version 1.0
 */
public interface TeacherMapper {
    @Select("select * from teacher where id = #{tid}")
    Teacher getTeacherById(@Param("tid") int id);
}
