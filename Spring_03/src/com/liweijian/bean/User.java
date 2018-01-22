package com.liweijian.bean;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:01 2018/1/22 0022
 */
public class User {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
