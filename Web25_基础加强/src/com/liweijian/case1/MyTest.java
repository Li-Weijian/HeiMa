package com.liweijian.case1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author:Liweijian
 * @Description: 自定义注解 -- 模拟单元测试
 * @Date:Create in 14:14 2017/12/19 0019
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyTest {


}
