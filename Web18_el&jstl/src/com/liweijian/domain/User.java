package com.liweijian.domain;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 22:43 2017/12/3 0003
 */
public class User {
    private int id;
    private String name;
    private String password;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
