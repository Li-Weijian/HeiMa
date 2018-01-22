package com.liweijian.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.annotation.Retention;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:08 2018/1/18 0018
 */

//将容器注册到对象
@Component("user")
public class User {

    //给字段注入值
    @Value("Tom")
    private String name;
    @Value("18")
    private Integer age;
    @Resource(name = "car")
    private Car car;
    private List list;   //list 和 set 注入方式相同
    private Map map;
    private Properties properties;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                ", list=" + list +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }


    public User(String name, Integer age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void initMethod(){
        System.out.println("我初始化啦~~");
    }

    public void destoryMethod(){
        System.out.println("我销毁啦~~");
    }
}
