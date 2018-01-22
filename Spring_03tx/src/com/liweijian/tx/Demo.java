package com.liweijian.tx;

import com.liweijian.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:55 2018/1/22 0022
 */
public class Demo {

    private AccountService service;

    @Test
    public void tranfer(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = (AccountService) ac.getBean("accountService");
        service.account(1,2,100d);
    }

    public void setService(AccountService service) {
        this.service = service;
    }
}
