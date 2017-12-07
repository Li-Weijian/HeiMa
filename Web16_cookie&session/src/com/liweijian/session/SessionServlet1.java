package com.liweijian.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @Author:Liweijian
 * @Description: session的创建和基本设置
 *               在服务器中，设置了session的自动销毁时间，且可以手动配置
 * @Date:Create in 23:23 2017/11/21 0021
 */
@WebServlet(name = "SessionServlet1")
public class SessionServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取session
        /*
        *  该方法会自动检测服务器中是否有session对象
        *  如果有，则获取该session并返回
        *  如果没有，则自动创建并返回
        * */
        HttpSession session = request.getSession();

        //2.获取JSESSIONID -- session的id标识
        String id = session.getId();

        //3.向session域中存储数据 -- 可以在本次会话中并且在同一客户端中进行获取
        session.setAttribute("name","Tom");

        //4.为了解决直接访问session2获取不到存储的数据的情况，对cookie设置持久化
        //通过抓包模拟cookie创建过程
        Cookie cookie = new Cookie("JSESSIONID",id);
        cookie.setMaxAge(10*60);        //十分钟
        cookie.setPath("/");
        response.addCookie(cookie);

        //打印JSESSIONID
        response.getWriter().write("JSESSIONID:"+id);

    }
}
