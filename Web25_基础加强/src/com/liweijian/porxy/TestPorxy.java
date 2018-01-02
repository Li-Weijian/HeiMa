package com.liweijian.porxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author:Liweijian
 * @Description: 动态代理 优化版请看TestProxy2
 * @Date:Create in 16:13 2017/12/19 0019
 */
public class TestPorxy {

    @Test
    public void test1(){
        //因为目标对象和代理对象都实现了TargetInterface接口，所以可以认为他们都是TargetInterface类型
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                //类加载器
                Target.class.getClassLoader(),
                //接口字节码对象数组
                new Class[]{TargetInterface.class},
                //句柄，匿名内部类
                new InvocationHandler() {
                    //代理对象调用的方法
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //目标方法前的逻辑
                        // ......比如修改参数args
                        // 执行目标方法
                        Object invoke = method.invoke(new Target(), args);
                        //目标方法后的逻辑
                        //....比如修改返回值invoke
                        return invoke;
                    }
                }
        );

        proxy.method1();
        String method2 = proxy.method2();
        int i = proxy.method3(100);

        System.out.println(method2);
        System.out.println(i);
    }
}
