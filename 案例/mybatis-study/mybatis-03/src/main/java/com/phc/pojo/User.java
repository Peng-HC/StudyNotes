package com.phc.pojo;

/**
 * @FileName User.java
 * @Description 实体类,实现数据库mybatis的User表
 * @Author phc
 * @date 2023/1/7 15:35
 * @Version 1.0
 */
//@Alias("userAlias")
public class User {
    private int id;
    private String name;
    private String pwd;

    //构造函数
    public User() {
    }

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }
    //getter与setter方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
