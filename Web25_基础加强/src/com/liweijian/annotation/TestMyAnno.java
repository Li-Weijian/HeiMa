package com.liweijian.annotation;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 13:41 2017/12/19 0019
 */
public class TestMyAnno {


    @SuppressWarnings("all")
    @MyAnno("zhangsan")
    public void show(String name){
        System.out.println("show is running...");
    }

}
