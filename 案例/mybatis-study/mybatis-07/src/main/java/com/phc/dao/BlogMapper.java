package com.phc.dao;
import com.phc.pojo.Blog;
/**
 * @FileName BlogMapper.i
 * @Description 实体类Blog的接口
 * @Author phc
 * @date 2023/1/19 16:11
 * @Version 1.0
 */
public interface BlogMapper {
    //插入数据
    int insertData(Blog blog);
}
