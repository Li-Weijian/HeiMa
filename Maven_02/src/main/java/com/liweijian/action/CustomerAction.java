package com.liweijian.action;

import com.liweijian.entity.Customer;
import com.liweijian.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:00 2018/2/20 0020
 */
public class CustomerAction extends ActionSupport {

    private Customer customer;

    private Long cust_id;

    private CustomerService customerService;


    public String findCustomerById() throws Exception {

        customer = customerService.findCustomerById(cust_id);
        System.out.println(customer.getCustName());
        return SUCCESS;
    }

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
