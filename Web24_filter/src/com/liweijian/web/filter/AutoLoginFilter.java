package com.liweijian.web.filter;

import com.liweijian.domain.User;
import com.liweijian.web.service.LoginService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description: 自动登录过滤器
 * @Date:Create in 19:42 2017/12/15 0015
 */
@WebFilter(filterName = "AutoLoginFilter")
public class AutoLoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        HttpSession session = ((HttpServletRequest) req).getSession();
        String cookie_username = null;
        String cookie_password = null;
        User user = null;

        //检查cookie是否携带username和password
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                if (cookie.getName().equals("cookie_username")){
                    cookie_username = cookie.getValue();
                    cookie_username = URLEncoder.encode(cookie_username,"UTF-8");   //恢复中文用户名 -- post提交
                }
                if (cookie.getName().equals("cookie_password")){
                    cookie_password = cookie.getValue();
                }
            }
        }


        if (cookie_username!=null && cookie_password!=null){
            //去数据库进行登录
            LoginService service = new LoginService();
            try {
                user = service.login(cookie_username,cookie_password);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //设置到Session
            session.setAttribute("user",user);
        }

        //放行
        chain.doFilter(httpServletRequest,httpServletResponse);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }

}
