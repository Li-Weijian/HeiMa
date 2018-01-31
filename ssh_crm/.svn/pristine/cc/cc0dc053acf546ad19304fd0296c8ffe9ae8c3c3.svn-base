package com.liweijian.web.action;

import com.liweijian.domain.User;
import com.liweijian.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.junit.Test;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:36 2018/1/23 0023
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();
    private UserService userService;


    //用户登录
    public String login(){
        //1.根据code查询用户
        User u = null;
        try {
            u = userService.getUserByCodePassword(user);
        }catch (Exception e){
            ActionContext.getContext().put("error",e.getMessage());
            return "loginError";
        }

        //2.将用户存入session
        ActionContext.getContext().getSession().put("user",u);

        //3.重定向到首页
        return "toHome";
    }

    //用户注册
    public String save() throws Exception {
        try {
            userService.save(user);
        }catch (Exception e){
            ActionContext.getContext().put("error",e.getMessage());
            return "registError";
        }
        return "toLogin";
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User getModel() {
        return user;
    }
}
