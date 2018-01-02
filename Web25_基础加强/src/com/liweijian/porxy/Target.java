package com.liweijian.porxy;

/**
 * @Author:Liweijian
 * @Description: TargetInterface的实现类
 * @Date:Create in 16:10 2017/12/19 0019
 */
public class Target implements TargetInterface{


    @Override
    public void method1() {
        System.out.println("method1 is running ...");
    }

    @Override
    public String method2() {
        System.out.println("method2 is running ...");
        return "method2";
    }

    @Override
    public int method3(int x) {
        System.out.println("method3 is running ...");
        return x;
    }
}
