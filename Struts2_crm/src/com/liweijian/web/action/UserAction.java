package com.liweijian.web.action;

import com.liweijian.domain.User;
import com.liweijian.service.UserService;
import com.liweijian.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 22:31 2018/1/16 0016
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{

    User user = new User();
    private UserService service = new UserServiceImpl();

    //登录
    public String login(){
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
