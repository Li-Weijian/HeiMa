package com.liweijian.junit;

import com.liweijian.dao.Userdao;
import com.liweijian.mapper.UserMapper;
import com.liweijian.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBatis_SpringTest {

    @Test
    public void testSelectUserById(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Userdao userDao = (Userdao) applicationContext.getBean("userDao");
        User user = userDao.selectUserById("1");
        System.out.println(user);
    }

    @Test
    public void findUserById(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        User user = userMapper.findUserById("22");
        System.out.println(user);
    }
}
