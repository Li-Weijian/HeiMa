package com.liweijian.web.action;

import com.liweijian.domain.SaleVisit;
import com.liweijian.service.SaleVisitService;
import com.liweijian.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:14 2018/1/31 0031
 */
public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {

    private SaleVisit saleVisit = new SaleVisit();
    private SaleVisitService saleVisitService;

    //分页封装
    private Integer currentPage;
    private Integer pageSize;

    //保存拜访记录
    public String save() throws Exception {

        saleVisitService.save(saleVisit);
        return "toList";
    }



    //获取页面数据
    public String list(){

        //封装查询条件
        DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);

        if (saleVisit.getCustomer() != null && saleVisit.getCustomer().getCust_id() != null){
            dc.add(Restrictions.eq("customer.cust_id",saleVisit.getCustomer().getCust_id()));
        }
        //1.调用Service处理分页逻辑，并返回PageBean对象
        PageBean pageBean = saleVisitService.getPageBean(dc,currentPage,pageSize);

        //2.存入request并转发到页面
        ActionContext.getContext().put("pageBean",pageBean);
        return "list";
    }

    //根据id获取拜访记录
    public String getSaleVisitById (){

        //调用Service查询
        SaleVisit idSaleVisit = saleVisitService.getSaleVIsitById(saleVisit.getVisit_id());
        //将查询到的添加到request
        ActionContext.getContext().put("saleVisit",idSaleVisit);
        //转发
        return "edit";
    }

    //更新客户
    public String update(){

        saleVisitService.update(saleVisit);
        return "toList";
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

    public void setSaleVisitService(SaleVisitService saleVisitService) {
        this.saleVisitService = saleVisitService;
    }

    @Override
    public SaleVisit getModel() {
        return saleVisit;
    }
}
