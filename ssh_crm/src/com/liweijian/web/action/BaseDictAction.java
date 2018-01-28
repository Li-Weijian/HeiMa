package com.liweijian.web.action;

import com.google.gson.Gson;
import com.liweijian.domain.BaseDict;
import com.liweijian.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 20:57 2018/1/28 0028
 */
public class BaseDictAction extends ActionSupport {

    private String dict_type_code;
    private BaseDictService bdService;

    @Override
    public String execute() throws Exception {

        //1.调用BaseDictService获取BaseDict
        List<BaseDict> baseDict = bdService.getBaseDictByTypeCode(dict_type_code);

        //2.封装成json
        Gson gson = new Gson();
        String json = gson.toJson(baseDict);

        //3.返回到客户端
        ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().write(json);

        //告诉Struts2不需要对结果进行处理
        return null;
    }

    public void setBdService(BaseDictService bdService) {
        this.bdService = bdService;
    }

    public String getDict_type_code() {
        return dict_type_code;
    }

    public void setDict_type_code(String dict_type_code) {
        this.dict_type_code = dict_type_code;
    }
}
