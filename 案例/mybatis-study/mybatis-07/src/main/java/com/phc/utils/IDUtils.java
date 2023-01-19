package com.phc.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * @FileName IDUtils.java
 * @Description 通过UUID生成不一致且具有随机性的ID
 * @Author phc
 * @date 2023/1/19 20:20
 * @Version 1.0
 */
public class IDUtils {
    public static String getId() {
        return UUID.randomUUID().toString().replace("-","");
    }

    @Test
    public void getIdTest() {
        System.out.println(IDUtils.getId());
    }
}
