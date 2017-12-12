package com.liweijian.vo;

/**
 * @Author:Liweijian
 * @Description: 搜索条件Bean
 * @Date:Create in 22:02 2017/12/10 0010
 */
public class Condition {

    private String pname;
    private String cid;
    private String is_hot;

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setIs_hot(String is_hot) {
        this.is_hot = is_hot;
    }

    public String getPname() {
        return pname;
    }

    public String getCid() {
        return cid;
    }

    public String getIs_hot() {
        return is_hot;
    }
}
