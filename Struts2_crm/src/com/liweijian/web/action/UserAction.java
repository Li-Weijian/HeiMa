package com.liweijian.web.action;

import com.liweijian.domain.User;
import com.liweijian.service.CustomerService;
import com.liweijian.service.UserService;
import com.liweijian.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 22:31 2018/1/16 0016
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{

    User user = new User();

    //登录
    public String login(){

        //1.获得ServletActionContext对象
        ServletContext context = ServletActionContext.getServletContext();
        //2.从context中获得容器
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
        //3.通过容器获得对象
        UserService service = (UserService) applicationContext.getBean("userService");
        //===================================================================================


        //1.调用service查询
        User exietsUser = service.login(user);
        //2.存入session
        ActionContext.getContext().getSession().put("user",exietsUser);
        //3.重定向到主页
        return "toIndex";
    }

    @Override
    public User getModel() {
        return user ;
    }
}
