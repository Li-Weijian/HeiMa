package com.liweijian.requset.line;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:Liweijian
 * @Description: 获得request请求行的相关api
 * @Date:Create in 14:57 2017/11/18 0018
 */
@WebServlet(name = "LineServlet")
public class LineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        String contextPath = request.getContextPath();
        String queryString = request.getQueryString();


        System.out.println("Method : "+method);
        System.out.println("requestURI:"+requestURI);
        System.out.println("requestURL:"+requestURL);
        System.out.println("contextPath:"+contextPath);
        System.out.println("queryString:"+queryString);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
