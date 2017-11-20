package com.liweijian.content;

import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @Author:Liweijian
 * @Description: 解决中文文件下载
 * @Date:Create in 20:14 2017/11/16 0016
 */
@WebServlet(name = "DownloadServlet2")
public class DownloadServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取传递进来的filename参数
        String filename = request.getParameter("filename"); //????.jpg

            //解决中文参数的乱码问题
            filename = new String(filename.getBytes("ISO8859-1"),"UTF-8");//美女.jpg

        //因为客户端会对该文件名进行默认解码，所以可能导致下载的文件名出错。
        //因此，需要使用相应的客户端编码格式进行编码
        String filenameEncoder = "";
        String agent = request.getHeader("User-Agent");

        if (agent.contains("MSIE")) {
            // IE浏览器
            filenameEncoder = URLEncoder.encode(filename, "utf-8");
            filenameEncoder = filenameEncoder.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filenameEncoder = "=?utf-8?B?"
                    + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
        } else {
            // 其它浏览器
            filenameEncoder = URLEncoder.encode(filename, "utf-8");
        }


        //设置下载类型  -- 需要根据服务器的资源后缀名进行获取，因此使用filename变量
        response.setContentType(this.getServletContext().getMimeType(filename));
        //设置header。通知客户端以附件的形式打开，而不需要解析
        response.setHeader("Content-Disposition","attachment;filename="+filenameEncoder);

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
