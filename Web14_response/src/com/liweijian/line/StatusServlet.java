package com.liweijian.line;

import java.io.IOException;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 20:28 2017/11/15 0015
 */
public class StatusServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setStatus(302);
    }
}
