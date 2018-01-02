package com.liweijian.annotation;

import java.lang.reflect.Method;

/**
 * @Author:Liweijian
 * @Description: 解析自定义注解 -- 通过反射获取
 * @Date:Create in 13:51 2017/12/19 0019
 */
public class MyAnnoparser {


    public static void main(String[] args) throws NoSuchMethodException {
        //获取字节码对象
        Class clazz = TestMyAnno.class;

        //获取方法
        Method method = clazz.getMethod("show", String.class);

        //获取方法上的注解
        MyAnno anno = method.getAnnotation(MyAnno.class);

        //对注解属性进行操作
        //如果不设置元注解，则无法获取（具体查看自定义注解）
        System.out.println(anno.value());
        System.out.println(anno.age());

        //实现业务逻辑

    }


}
