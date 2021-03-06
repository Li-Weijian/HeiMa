package com.liweijian.web.action;

import com.liweijian.domain.Customer;
import com.liweijian.service.CustomerService;
import com.liweijian.service.impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import ognl.Ognl;
import ognl.OgnlContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:23 2018/1/11 0011
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

    private Customer customer = new Customer();

    public String list() throws Exception{

        //1.获得ServletActionContext对象
        ServletContext context = ServletActionContext.getServletContext();
        //2.从context中获得容器
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
        //3.通过容器获得对象
        CustomerService service = (CustomerService) applicationContext.getBean("customerService");
        //===================================================================================


        //1.获得参数
        String cust_name = ServletActionContext.getRequest().getParameter("cust_name");
        //2.新建离线查询
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        //3.判断参数是否为空并组合条件
        if (StringUtils.isNotBlank(cust_name)){
            dc.add(Restrictions.like("cust_name","%"+cust_name+"%"));
        }
        //4.传递离线查询
        List<Customer> list = service.customerList(dc);
        //5.设置参数
      //ServletActionContext.getRequest().setAttribute("list",list);
        ActionContext.getContext().put("list",list);
        return "list";
    }

    //添加客户
    public String add(){
        //1.获得ServletActionContext对象
        ServletContext context = ServletActionContext.getServletContext();
        //2.从context中获得容器
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
        //3.通过容器获得对象
        CustomerService service = (CustomerService) applicationContext.getBean("customerService");
        //===================================================================================

        service.addCustomer(customer);
        return "toList";
    }


    @Override
    public Customer getModel() {
        return customer;
    }
}
