package com.liweijian.content;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author:Liweijian
 * @Description: 向客户端传输字节流
 * @Date:Create in 22:39 2017/11/15 0015
 */
@WebServlet(name = "ByteServlet")
public class ByteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取字节输出流
        ServletOutputStream out = response.getOutputStream();

        //获取服务器上的图片
        String realPath = this.getServletContext().getRealPath("a.jpg");
        InputStream in = new FileInputStream(realPath);


        //输出到客户端
        int len = 0;
        byte[] buff = new byte[1024];
        while ((len = in.read(buff)) > 0){
            out.write(buff,0,len);
        }

        in.close();
        out.close();


    }
}
