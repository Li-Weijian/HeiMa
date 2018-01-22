package com.liweijian.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:59 2018/1/22 0022
 */
public class AccountDaoImpl extends JdbcDaoSupport implements  AccountDao {
    @Override
    public void addMoney(int to, double money) {
        super.getJdbcTemplate().update("UPDATE tranfer SET money = money + ? where id = ?",money,to);
    }

    @Override
    public void dercMoney(int from, double money) {
        super.getJdbcTemplate().update("UPDATE tranfer SET money = money - ? where id = ?",money,from);
    }
}
