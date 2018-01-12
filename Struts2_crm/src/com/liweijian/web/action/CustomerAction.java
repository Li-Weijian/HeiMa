package com.liweijian.web.action;

import com.liweijian.domain.Customer;
import com.liweijian.service.CustomerService;
import com.liweijian.service.impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:23 2018/1/11 0011
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

    private CustomerService service = new CustomerServiceImpl();
    private Customer customer = new Customer();

    public String list() throws Exception{

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
        ServletActionContext.getRequest().setAttribute("list",list);

        return "list";
    }

    //添加客户
    public String add(){
        service.addCustomer(customer);
        return "toList";
    }


    @Override
    public Customer getModel() {
        return customer;
    }
}
