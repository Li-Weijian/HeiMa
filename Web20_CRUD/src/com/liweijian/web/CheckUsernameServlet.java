package com.liweijian.web;

import com.liweijian.service.CheckUsernameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description: 利用ajax动态校验用户名
 * @Date:Create in 22:33 2017/12/12 0012
 */
@WebServlet(name = "CheckUsernameServlet")
public class CheckUsernameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        boolean isExist = false;
        CheckUsernameService service = new CheckUsernameService();
        try {
           isExist = service.checkUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //以json格式返回数据
        response.getWriter().write("{\"isExist\":"+isExist+"}");
    }
}
