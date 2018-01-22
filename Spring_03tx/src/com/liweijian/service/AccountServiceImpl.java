package com.liweijian.service;

import com.liweijian.dao.AccountDao;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:57 2018/1/22 0022
 */
public class AccountServiceImpl implements AccountService {


    private AccountDao dao;
    private TransactionTemplate tt;

    @Override
    public void account(int from, int to, double money) {

        tt.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                dao.addMoney(to,money);
                int i = 1/0;
                dao.dercMoney(from,money);
            }
        });


    }

    public void setDao(AccountDao dao) {
        this.dao = dao;
    }

    public void setTt(TransactionTemplate tt) {
        this.tt = tt;
    }
}
