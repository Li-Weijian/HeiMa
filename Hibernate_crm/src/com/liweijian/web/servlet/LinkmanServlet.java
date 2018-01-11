package com.liweijian.web.servlet;

import com.liweijian.domain.Customer;
import com.liweijian.domain.Linkman;
import com.liweijian.service.CustomerService;
import com.liweijian.service.LinkmanService;
import com.liweijian.service.impl.CustomerServiceImpl;
import com.liweijian.service.impl.LinkmanServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 10:15 2018/1/9 0009
 */
@WebServlet(name = "LinkmanServlet")
public class LinkmanServlet extends BaseServlet  {
    private LinkmanService service = new LinkmanServiceImpl();
    private CustomerService cust_service = new CustomerServiceImpl();


    //添加联系人
    public void addLinkman(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //封装已有对应的字段
        Linkman linkman = new Linkman();
        try {
            BeanUtils.populate(linkman,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //通过cust_id去数据库查询Customer并封装
        String cust_idStr = request.getParameter("cust_id");
        Long cust_id = Long.parseLong(cust_idStr);
        Customer customer = cust_service.findCustomerByid(cust_id);
        linkman.setCustomer(customer);

        //将Linkman传递到service层
        service.addLinkman(linkman);

        //重定向到联系人列表
        response.sendRedirect(request.getContextPath()+"/linkmanServlet?method=linkmanList");
    }

    //联系人列表
    public void linkmanList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String lkm_name = request.getParameter("lkm_name");
        //离线查询 -- 在web层组装查询条件
        DetachedCriteria dc = DetachedCriteria.forClass(Linkman.class);
        if (lkm_name != null && !"".equals(lkm_name)){
            //添加条件
            dc.add(Restrictions.like("lkm_name","%"+lkm_name+"%"));
        }

        List<Linkman> linkmanList = service.findAllLinkman(dc);

        request.setAttribute("parme",lkm_name);
        request.setAttribute("list",linkmanList);
        request.getRequestDispatcher(request.getContextPath()+"/jsp/linkman/list.jsp").forward(request,response);
    }

}
