package com.liweijian.service;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 13:16 2018/3/19 0019
 */
public class App {

    public static void main(String[] args){
        HelloServiceService helloServiceService = new HelloServiceService();
        HelloService helloServicePort = helloServiceService.getHelloServicePort();
        String sayHello = helloServicePort.sayHello("liweijian");
        System.out.println(sayHello);
    }
}
