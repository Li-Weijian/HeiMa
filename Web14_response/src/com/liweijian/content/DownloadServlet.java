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
 * @Description: 实现文件下载  -- 设置header即可
 * @Date:Create in 20:14 2017/11/16 0016
 */
@WebServlet(name = "DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取传递进来的filename参数
        String filename = request.getParameter("filename");

        //设置下载类型
        response.setContentType(this.getServletContext().getMimeType(filename));
        //设置header。通知客户端以附件的形式打开，而不需要解析
        response.setHeader("Content-Disposition","attachment;filename="+filename);

        //获取文件的绝对路径
        String path = this.getServletContext().getRealPath("download/" + filename);

        //获取文件输入流
        InputStream in = new FileInputStream(path);

        //获取文件输出流
        ServletOutputStream out = response.getOutputStream();

        //向客户端输出文件
        int len = 0;
        byte[] buff = new byte[1024];
        while ((len = in.read(buff)) != -1){
            out.write(buff,0,len);
        }

        //关闭连接
        in.close();         //需要手动关闭，因为是自己new的
//      out.close();        //在开发中一般不需要手动关闭此连接，因为容器会自动检测并关闭
    }
}
