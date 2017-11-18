package com.liweijian.requset.content;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * @Author:Liweijian
 * @Description: 获取请求体参数
 * @Date:Create in 16:38 2017/11/18 0018
 */
@WebServlet(name = "ContentServlet")
public class ContentServlet extends HttpServlet {

    //请求体是通过post提交的。
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取单个表单的值
        String username = request.getParameter("username");
        System.out.println(username);
        String password = request.getParameter("password");
        System.out.println(password);

        //获取多个表单的值
        String[] hobbies = request.getParameterValues("hobby");
      //  System.out.println(hobbies.toString());     //for循环打印也行

        //获取所有请求参数的名称
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            System.out.println(parameterNames.nextElement());
        }

        //获取所有的参数，所有参数封装到Map集合里
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String,String[]> entry:parameterMap.entrySet()){
            System.out.println(entry.getKey());
            for (String str:entry.getValue()){
                System.out.println(str);
            }

            System.out.println("-----------");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
