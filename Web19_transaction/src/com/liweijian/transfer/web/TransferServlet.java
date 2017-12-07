package com.liweijian.transfer.web;

import com.liweijian.transfer.service.TransferService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:Liweijian
 * @Date:Create in 18:14 2017/12/7 0007
 */
public class TransferServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        String in = request.getParameter("in");
        String out = request.getParameter("out");
        String moneyStr = request.getParameter("money");
        double money = Double.parseDouble(moneyStr);

        //2.向service层传递参数
        TransferService service = new TransferService();
        boolean isTransferSuccess = service.transfer(in,out,money);


        response.setContentType("text/html;charset=utf8");
        if (isTransferSuccess){
            response.getWriter().println("转账成功！！");
        }else {
            response.getWriter().println("转账失败！！");
        }
    }
}
