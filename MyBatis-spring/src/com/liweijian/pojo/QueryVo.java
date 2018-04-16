package com.liweijian.pojo;

import java.io.Serializable;
import java.util.List;

public class QueryVo implements Serializable {

    private User user;
    private List<Integer> idList;
    private Integer[] ids;


    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
