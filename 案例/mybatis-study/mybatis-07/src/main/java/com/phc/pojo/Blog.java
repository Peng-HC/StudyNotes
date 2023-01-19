package com.phc.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @FileName Blog.java
 * @Description blog表
 * @Author phc
 * @date 2023/1/19 16:04
 * @Version 1.0
 */
@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime; //属性名和字段名不一致
    private int views;
}
