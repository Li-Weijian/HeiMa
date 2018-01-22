package com.liweijian.bean;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:47 2018/1/18 0018
 */
@Component("car")
public class Car {

    @Value("黄色")
    private String color;
    private String name;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
