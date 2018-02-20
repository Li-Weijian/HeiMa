package com.liweijian.dao.impl;

import static org.junit.Assert.*;

import com.liweijian.dao.CustomerDao;
import com.liweijian.entity.Customer;
import org.apache.log4j.net.SyslogAppender;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CustomerDaoImplTest {

	@Test
	public void test() {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		CustomerDao customerDao = (CustomerDao) app.getBean("customerDao");
		Customer customer = customerDao.findCustomerById(23L);
		System.out.println("********************"+customer.getCustName());
	}

}
