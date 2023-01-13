package com.phc.pojo;

import lombok.Data;

/**
 * @FileName Student.java
 * @Description 学生实体类
 * @Author phc
 * @date 2023/1/13 10:59
 * @Version 1.0
 */
@Data
public class Student {
    private int id;
    private String name;
    //学生需要关联一个老师
    private Teacher teacher;
}
