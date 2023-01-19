package com.phc.pojo;

import lombok.Data;

import java.util.List;

/**
 * @FileName Teacher.java
 * @Description 教师实体类
 * @Author phc
 * @date 2023/1/13 10:59
 * @Version 1.0
 */
@Data
public class Teacher {
    private int id;
    private String name;
    //一个老师拥有多个学生
    private List<Student> students;
}
