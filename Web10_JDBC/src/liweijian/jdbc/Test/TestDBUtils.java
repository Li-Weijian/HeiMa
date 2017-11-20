package liweijian.jdbc.Test;

import liweijian.jdbc.Util.C3P0Utils;
import liweijian.jdbc.Util.JDBCUtils_V3;
import liweijian.jdbc.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description: DBUtils测试类
 * @Date:Create in 21:25 2017/11/2 0002
 */
public class TestDBUtils {

    //1.导入Mysql驱动包--> 导入c3p0包 --> 导入DBUtils包
    @Test
    public void test1(){
        //2.创建QueryRunner对象，用来操作sql语句
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        //3.编写sql语句
        String sql = "insert into user values(null,?,?)";

        //4.操作sql--插入，修改，删除方法相同
        try {
            int row = qr.update(sql,"哈哈","haha");
            System.out.println(row);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


   /*①ArrayHandler：     将查询结果的第一行数据，保存到Object数组中
     ②ArrayListHandler     将查询的结果，每一行先封装到Object数组中，然后将数据存入List集合
     ③BeanHandler     将查询结果的第一行数据，封装到user对象
     ④BeanListHandler     将查询结果的每一行封装到user对象，然后再存入List集合
     ⑤ColumnListHandler     将查询结果的指定列的数据封装到List集合中
     ⑥MapHandler     将查询结果的第一行数据封装到map结合（key==列名，value==列值）
     ⑦MapListHandler     将查询结果的每一行封装到map集合（key==列名，value==列值），再将map集合存入List集合
     ⑧BeanMapHandler     将查询结果的每一行数据，封装到User对象，再存入mao集合中（key==列名，value==列值）
     ⑨KeyedHandler     将查询的结果的每一行数据，封装到map1（key==列名，value==列值 ），然后将map1集合（有多个）存入map2集合（只有一个）
     ⑩ScalarHandler     封装类似count、avg、max、min、sum......函数的执行结果*/
   //常用的是BeanHandler、BeanListHandler和ScalarHandler

    @Test
    public void test2(){

        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql = "select * from user";

        try {
            User user = qr.query(sql, new BeanHandler<User>(User.class));
            System.out.println(user.getUname() + " : " + user.getUpassword());
            System.out.println(user.toString());        //重写User类中的toString()
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){

        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql = "select * from user";

        try {
            //ctrl + alt + V 自动引入变量
            List<User> users = qr.query(sql, new BeanListHandler<User>(User.class));
            System.out.println(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
