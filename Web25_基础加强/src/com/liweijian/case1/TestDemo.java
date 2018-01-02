package com.liweijian.case1;

import org.junit.Test;

/**
 * @Author:Liweijian
 * @Description: 自定义注解模拟单元测试
 * @Date:Create in 14:12 2017/12/19 0019
 */
public class TestDemo {

    @Test
    public void test1(){
        System.out.println("test1 is running...");
    }

    @MyTest
    public void test2(){
        System.out.println("test2 is running...");
    }

    @MyTest
    public void test3(){
        System.out.println("test3 is running...");
    }
}
