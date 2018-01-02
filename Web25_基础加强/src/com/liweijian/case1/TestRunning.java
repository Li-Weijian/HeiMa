package com.liweijian.case1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author:Liweijian
 * @Description: 自定义注解 -- 模拟单元测试
 * @Date:Create in 14:17 2017/12/19 0019
 */
public class TestRunning {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        //通过反射获取字节码对象
        Class clazz = TestDemo.class;

        //获得所有方法
        Method[] methods = clazz.getMethods();

        if (methods != null){
            for (Method method : methods){
                //获取使用了MyTest注解的方法
                boolean isTest = method.isAnnotationPresent(MyTest.class);
                if (isTest){
                    //调用该方法
                    method.invoke(clazz.newInstance(),null);
                }
            }
        }

    }
}
