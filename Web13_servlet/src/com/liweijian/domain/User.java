package com.liweijian.domain;

/**
 * @Author:Liweijian
 * @Description: 实体类 -- bean
 * @Date:Create in 20:45 2017/11/10 0010
 */
public class User {

    private int id;
    private String username;
    private String password;
    private String emain;

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmain(String emain) {
        this.emain = emain;
    }



    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmain() {
        return emain;
    }

    @Override
    public String toString() {
        return getUsername() + "," + "welcome";
    }
}
