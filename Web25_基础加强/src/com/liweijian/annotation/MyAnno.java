package com.liweijian.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author:Liweijian
 * @Description: 自定义注解 -- @interface
 * @Date:Create in 13:37 2017/12/19 0019
 */


//元注解
@Target({ElementType.TYPE,ElementType.METHOD}) // 类和方法下可以使用
@Retention(RetentionPolicy.RUNTIME) //注解在整个生命周期可以使用
public @interface MyAnno {

    //注解的属性 -- 如果以value命名，则在使用时不需要以键值对的形式出现
    /*
    *  可以是以下类型：
    *  1.基本类型
    *  2.字符串类型
    *  3.枚举类型
    *  4.Class字节码类型
    *  5.注解类型
    *  6.以上类型的一维数组
    * */
    String value();
    int age() default 28;

}
