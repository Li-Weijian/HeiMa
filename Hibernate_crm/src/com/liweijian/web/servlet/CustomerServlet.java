package com.liweijian.web.servlet;

import com.liweijian.domain.Customer;
import com.liweijian.service.CustomerService;
import com.liweijian.service.impl.CustomerServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:29 2018/1/6 0006
 */
public class CustomerServlet extends BaseServlet {

    private CustomerService service = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //添加客户
    public void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1.获得表达提交的参数
        Customer customer = new Customer();
        try {
            BeanUtils.populate(customer,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //2.传递到service
        service.addCustomer(customer);

        //3.重定向
        response.sendRedirect(request.getContextPath()+"/customerServlet?method=customerList");
    }


    //客户列表
    public void customerList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cust_name = request.getParameter("cust_name");
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        //离线查询组合条件
        if (cust_name!= null && !"".equals(cust_name)){
            dc.add(Restrictions.like("cust_name","%"+cust_name+"%"));
        }

        List<Customer> customerList = service.customerList(dc);
        request.setAttribute("parme",cust_name);
        request.setAttribute("list",customerList);
        request.getRequestDispatcher(request.getContextPath()+"/jsp/customer/list.jsp").forward(request,response);
    }




}
