package com.liweijian.advice;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 16:40 2018/1/20 0020
 */
public class MyAdvice {

    public void before(){
        System.out.println("这是前置通知");
    }

    public void afterReturning(){
        System.out.println("这是后置通知（出现异常不会调用）");
    }

    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("这是环绕通知之前的部分");
        Object proceed = pjp.proceed(); //调用目标之前的方法
        System.out.println("这是环绕通知单之后的部分");
        return proceed;
    }

    public void afterException(){
        System.out.println("这是异常通知");
    }

    public void after(){
        System.out.println("这是后置通知（出现异常一样会调用）");
    }

}
