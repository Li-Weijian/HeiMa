package com.liweijian.web.action;

import com.liweijian.domain.Customer;
import com.liweijian.domain.Linkman;
import com.liweijian.service.LinkmanService;
import com.liweijian.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 22:57 2018/1/29 0029
 */
public class LinkManAction extends ActionSupport implements ModelDriven {

    Linkman linkman = new Linkman();
    LinkmanService lmService;

    //分页封装
    private Integer currentPage;
    private Integer pageSize;


    //获取页面数据
    public String list(){

        //封装查询条件
        DetachedCriteria dc = DetachedCriteria.forClass(Linkman.class);
        if (StringUtils.isNotBlank(linkman.getLkm_name())){
            dc.add(Restrictions.like("lkm_name","%"+linkman.getLkm_name()+"%"));
        }

        if (linkman.getCustomer() != null && linkman.getCustomer().getCust_id() != null){
            dc.add(Restrictions.eq("customer.cust_id",linkman.getCustomer().getCust_id()));
        }

        //1.调用Service处理分页逻辑，并返回PageBean对象
        PageBean pageBean = lmService.getPageBean(dc,currentPage,pageSize);

        //2.存入request并转发到页面
        ActionContext.getContext().put("pageBean",pageBean);
        return "list";
    }


    //保存联系人
    public String save(){

        lmService.save(linkman);
        return "toList";
    }


    //根据id获取联系人
    public String getLinkManById(){

        //调用Service查询
        Linkman idLinkman = lmService.getLinkmanById(linkman.getLkm_id());
        //将查询到的添加到request
        ActionContext.getContext().put("linkman",idLinkman);
        //转发
        return "edit";
    }

    //更新客户
    public String update(){

        lmService.update(linkman);
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

    public void setLmService(LinkmanService lmService) {
        this.lmService = lmService;
    }

    @Override
    public Object getModel() {
        return linkman;
    }
}
