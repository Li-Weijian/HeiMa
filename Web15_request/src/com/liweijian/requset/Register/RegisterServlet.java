package com.liweijian.requset.Register;

import com.liweijian.requset.utils.DataSourceUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

/**
 * @Author:Liweijian
 * @Description: 注册
 * @Date:Create in 21:37 2017/11/18 0018
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //解决乱码问题 -- 只适用于post提交
        request.setCharacterEncoding("UTF-8");

        //get方式乱码解决 -- 不适用于表单
        //String username = request.getParameter("username");//乱码
        //先用iso8859-1编码 在使用utf-8解码
        //username = new String(username.getBytes("iso8859-1"),"UTF-8");


        //1、获取数据
        //String username = request.getParameter("username");
        //System.out.println(username);
        //String password = request.getParameter("password");
        //.....

        //2、将散装的封装到javaBean
        //User user = new User();
        //user.setUsername(username);
        //user.setPassword(password);
        //....很烦很累。还是使用工具吧

        //1.封装一个实体并从页面获取数据
        /**
         * 此处使用Tomcat的一个工具类 -- BeanUtil
         * 需要导入两个包commons-beanutils-1.8.3.jar和commons-logging-1.1.1.jar
         * 作用是自动将Map集合的key与实体类中的属性进行自动映射，前提是key与属性名字必须相同
         * */
        User user = new User();
        Map<String, String[]> parameterMap = request.getParameterMap();

        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //至此，User对象已经封装完毕
        //2.设置uid字段 -- 使用UUID类进行自动生成(随机生成32位字符串)
        user.setUid(UUID.randomUUID().toString());

        //3.将User传递给业务进行写入数据库
        try {
            register(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //重定向至登录页面
        response.sendRedirect(request.getContextPath()+"/login.jsp");

    }

    //注册方法
    public void register(User user) throws SQLException {

        //获取数据库
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";

        //写入数据库
        queryRunner.update(sql,user.getUid(),user.getUsername(),user.getPassword(),
                user.getName(),user.getEmail(),null,user.getBirthday(),user.getSex(),null,null);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
