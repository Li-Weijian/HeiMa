package com.liweijian.dao;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:59 2018/1/22 0022
 */
public interface AccountDao {
    void addMoney(int to, double money);

    void dercMoney(int from, double money);
}
