package com.liweijian.transfer.service;

import com.liweijian.transaction.utils.DataSourceUtils;
import com.liweijian.transaction.utils.MyDataSourceUtils;
import com.liweijian.transfer.dao.TransferDao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description: service层，处理业务代码
 * @Date:Create in 18:20 2017/12/7 0007
 */
public class TransferService {

    public boolean transfer(String in, String out, double money) {
        boolean isTransferSuccess = true;


        /*
        *  因为分层的缘故，所以在service层最好别出现Connection
        *  所以重新封装了一个工具类 MyDataSourceUtils
        *  通过ThreadLocal对象进行封装
        *  ThreadLocal类似map，key是当前操作的线程，value是Connection
        * */
       // Connection conn = null;
        try {

          /*  //1.获取连接
            conn = DataSourceUtils.getConnection();
            //2.设置手动提交
            conn.setAutoCommit(false);
          */
            //开启事务
            MyDataSourceUtils.startTransaction();

            TransferDao dao = new TransferDao();
            //转入方法
            dao.in(in,money);
            //转出方法
            dao.out(out,money);


        } catch (Exception e) {
            try {
                MyDataSourceUtils.rollback();    //回滚
                isTransferSuccess = false;
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                MyDataSourceUtils.commit();  //提交，即使出现异常提交后没问题。
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isTransferSuccess;
    }
}
