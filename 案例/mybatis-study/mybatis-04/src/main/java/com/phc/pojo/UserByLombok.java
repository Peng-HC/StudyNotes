package com.phc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @FileName UserByLombok.java
 * @Description Lombok插件测试
 * @Author phc
 * @date 2023/1/13 9:50
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserByLombok {
    private int id;
    private String name;
    private String pwd;
}
