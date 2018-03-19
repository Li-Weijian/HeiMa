package com.liweijian.service;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @Author:Liweijian
 * @Description: WebService服务端创建：
 *                  1. 创建一个类，并提供一个方法
 *                  2. 在类中加入@WebService注解
 *                  3. 在main中调用jdk提供的对外发布的方法
 *                  4. 访问提供的地址 http://192.168.1.2:8080/hello?wsdl
 *
 * @Date:Create in 13:08 2018/3/19 0019
 */
@WebService
public class HelloService {

    public String sayHello(String name){
        System.out.println("服务端被调用。。。");
        return "hello " + name;
    }

    public static void main(String[] args){

        String address = "http://192.168.1.2:8080/hello";
        Object service = new HelloService();
        Endpoint.publish(address,service);
    }
}
