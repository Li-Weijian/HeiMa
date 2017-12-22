package com.liweijian.domain;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 17:44 2017/12/15 0015
 */
public class User {

    private String id;
    private String username;
    private String password;
    private String emain;

    public void setId(String id) {
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

    public String getId() {
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
}
