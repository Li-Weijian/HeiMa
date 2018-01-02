package com.liweijian;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description: 使用fileupload工具上传文件示例
 * @Date:Create in 21:11 2018/1/2 0002
 */
public class FileUploadServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取相关路径
        String store_path = this.getServletContext().getRealPath("upload");
        String temp_path = this.getServletContext().getRealPath("temp");

        try {
            //1.创建磁盘文件工厂  -- 设置缓存大小和缓存路径
            DiskFileItemFactory factory = new DiskFileItemFactory(1024 * 1024, new File(temp_path));

            //2.创建文件上传核心类

            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            fileUpload.setHeaderEncoding("UTF-8");

            //3.判断表单是否为文件上传表单
            boolean multipartContent = fileUpload.isMultipartContent(request);
            if (multipartContent) {
                //是上传文件的表单
                //解析request得到FileItem的list
                List<FileItem> list = fileUpload.parseRequest(request);
                for (FileItem item : list){
                    if (item.isFormField()){
                        //是普通表单
                        String name = item.getFieldName();
                        String string = item.getString("UTF-8");  //以指定编码获取
                        System.out.println(name +":"+string);
                    }else {
                        //是文件上传表单
                        InputStream in = item.getInputStream();
                        String filename = item.getName();
                        OutputStream out = new FileOutputStream(store_path+"/"+filename);
                        IOUtils.copy(in,out);
                        in.close();
                        out.close();
                        item.delete(); //删除临时文件
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }







        /*第一种用法。简便开发请使用第二种*/
       /* try {
            //1.创建磁盘文件工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();

            //2.创建文件上传核心类
            ServletFileUpload upload = new ServletFileUpload(factory);

            //3.解析request --  获得文件项集合
            List<FileItem> list = upload.parseRequest(request);

            //4.遍历文件项集合
            for (FileItem item : list){
                //判断是否为普通表单
                boolean isFormField = item.isFormField();
                if (isFormField){
                    //是普通表单
                    String name = item.getFieldName();
                    String string = item.getString();
                    System.out.println(name +":"+string);
                }else {
                    //文件上传表单 -- 使用IO流进行文件复制
                    InputStream in = item.getInputStream();     //获得输入流
                    String filename = item.getName();       //获得文件名
                    String path = this.getServletContext().getRealPath("upload"); // 获得存储路径
                    System.out.println(path);
                    OutputStream out = new FileOutputStream(path + "/"+filename);

                    //复制到服务器中
                    int len = 0;
                    byte[] buffer = new byte[1024];
                    while ((len = in.read(buffer))> 0){
                        out.write(buffer,0,len);
                    }
                    in.close();
                    out.close();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
*/

}
