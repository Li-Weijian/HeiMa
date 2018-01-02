package com.liweijian.porxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author:Liweijian
 * @Description: 动态代理2 稍微优化了一下
 * @Date:Create in 16:57 2017/12/19 0019
 */
public class TestProxy2 {

    @Test
    public void test2(){
        Target target = new Target();
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    /*
                    * invoke被执行几次？
                    * 代理对象调用几次就执行几次
                    * */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object invoke = method.invoke(target, args);
                        return invoke;
                    }
                }
        );

        proxy.method1();    //method：method1  args:null  返回值:null
        String s = proxy.method2(); //method: method2 args:null 返回值:s = "method2"
        int i = proxy.method3(200); //method: method3 args:x = 200 返回值：i = 200
        System.out.println(s);
        System.out.println(i);
    }
}
