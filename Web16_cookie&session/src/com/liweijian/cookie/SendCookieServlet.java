package com.liweijian.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:Liweijian
 * @Description: 向客户端发送cookie
 * @Date:Create in 18:18 2017/11/20 0020
 */
public class SendCookieServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建cookie
        Cookie cookie = new Cookie("name","zhangsan");

        //1.1创建持久化cookie
        //如果不指定cookie持久化，则该cookie处于会话级别（关闭浏览器即销毁）
        cookie.setMaxAge(60*10); // 以秒为单位 -- 时间设置为0即删除cookie

        //1.2设置携带cookie的路径
        cookie.setPath("/sendCookie");      //指定路径
        // cookie.setPath("/Web16_cookie&session");  //指定该Web应用都可以携带

        //2.发送cookie
        response.addCookie(cookie);


    }
}
