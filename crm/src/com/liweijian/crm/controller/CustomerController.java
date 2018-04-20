package com.liweijian.crm.controller;

import com.liweijian.crm.pojo.BaseDict;
import com.liweijian.crm.pojo.Customer;
import com.liweijian.crm.pojo.QueryVo;
import com.liweijian.crm.service.BaseDictService;
import com.liweijian.crm.service.CustomerService;
import com.liweijian.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private BaseDictService baseDictService;
    @Autowired
    private CustomerService customerService;

    //解决硬编码问题，从resouce.properties中读取。需要去springmvc中进行配置
    @Value("${baseDict_industryType}")
    private String BASEDICT_industryType;
    @Value("${baseDict_fromType}")
    private String BASEDICT_fromType;
    @Value("${baseDict_levelType}")
    private String BASEDICT_levelType;

    @RequestMapping(value = "/customer/list")
    public String list(QueryVo vo, Model model){

        List<BaseDict> industryType = baseDictService.selectBaseDictByCode(BASEDICT_industryType);
        List<BaseDict> fromType = baseDictService.selectBaseDictByCode(BASEDICT_fromType);
        List<BaseDict> levelType = baseDictService.selectBaseDictByCode(BASEDICT_levelType);

        model.addAttribute("industryType",industryType);
        model.addAttribute("fromType",fromType);
        model.addAttribute("levelType",levelType);

        Page<Customer> page = customerService.selectPageByQueryVo(vo);
        model.addAttribute("page",page);
        model.addAttribute("custName",vo.getCustName());
        model.addAttribute("custIndustry",vo.getCustIndustry());
        model.addAttribute("custLevel",vo.getCustLevel());
        model.addAttribute("custSource",vo.getCustSource());
        
        return "customer";
    }



}
