package test;

import oracle.jdbc.driver.OracleTypes;
import org.junit.Test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description: 测试连接OracleJDBC
 * @Date:Create in 21:35 2018/2/11 0011
 */
public class TestJdbc {
    Connection conn = null;
    CallableStatement call = null;

    @Test
    public void test1() {

        //{call <procedure-name>[(<arg1>,<arg2>, ...)]}
        String sql = "{call queryEmpInformation(?,?,?,?)}";

        Connection conn = null;
        CallableStatement call = null;
        try {
            conn = JDBCUtils.getConnection();
            call = conn.prepareCall(sql);

            //对于in参数，赋值
            call.setInt(1, 7839);

            //对于out参数，申明
            call.registerOutParameter(2, OracleTypes.VARCHAR);
            call.registerOutParameter(3, OracleTypes.NUMBER);
            call.registerOutParameter(4, OracleTypes.VARCHAR);

            //执行
            call.execute();

            //输出
            String name = call.getString(2);
            double sal = call.getDouble(3);
            String job = call.getString(4);

            System.out.println(name + "\t" + sal + "\t" + job);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
