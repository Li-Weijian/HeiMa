package com.liweijian.cookie;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:Liweijian
 * @Description: 用户上一次访问时间
 * @Date:Create in 15:23 2017/11/21 0021
 */
@WebServlet(name = "LastAccessTimeServlet")
public class LastAccessTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //防止乱码
        response.setContentType("text/html;charset=UTF-8");

        //1.获取客户端的cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie: cookies){
                String cookieName = cookie.getName();
                if (cookieName.equals("LastAccessTime")){
                    String cookieValue = cookie.getValue();
                    response.getWriter().write("您上次的访问时间是："+cookieValue);
                }
            }
        }else {
            response.getWriter().write("您是第一次访问");
        }

        //2.获取当前时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String lastDate = simpleDateFormat.format(date);

        //3.创建cookie
        Cookie cookie = new Cookie("LastAccessTime",lastDate);

        //4.设置cookie持久化
        cookie.setMaxAge(60*10);        //十分钟

        //5.向客户端发送cookie
        response.addCookie(cookie);
    }
}
