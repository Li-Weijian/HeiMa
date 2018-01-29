package com.liweijian.web.action;

import com.liweijian.domain.Customer;
import com.liweijian.service.CustomerService;
import com.liweijian.utils.PageBean;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.io.File;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:36 2018/1/23 0023
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private Customer customer = new Customer();
    private CustomerService customerService;

    //分页封装
    private Integer currentPage;
    private Integer pageSize;


    //文件上传
    private File photo;
    private String photoFileName;
    private String photoContentType;


    //获取页面数据
    public String list(){

        //封装查询条件
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        if (StringUtils.isNotBlank(customer.getCust_name())){
            dc.add(Restrictions.like("cust_name","%"+customer.getCust_name()+"%"));
        }

        //1.调用Service处理分页逻辑，并返回PageBean对象
        PageBean pageBean = customerService.getPageBean(dc,currentPage,pageSize);

        //2.存入request并转发到页面
        ActionContext.getContext().put("pageBean",pageBean);
        return "list";
    }

    //保存客户
    public String save(){
        //===============================文件上传=========================================//
        photo.renameTo(new File("D://下载/test.jpg"));
        System.out.println(photoFileName);
        System.out.println(photoContentType);

        customerService.save(customer);

        return "toList";
    }

    //根据id获取客户
    public String getCustomerById(){

        //调用Service查询
        Customer idCusomer = customerService.getCustomerById(customer.getCust_id());
        //将查询到的添加到request
        ActionContext.getContext().put("customer",idCusomer);
        //转发
        return "edit";
    }

    //更新客户
    public String update(){

        customerService.update(customer);
        return "toList";
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Customer getModel() {
        return customer;
    }
}
