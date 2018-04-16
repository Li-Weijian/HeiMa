package com.liweijian.junit;

import com.liweijian.mapper.OrdersMapper;
import com.liweijian.mapper.UserMapper;
import com.liweijian.pojo.Orders;
import com.liweijian.pojo.QueryVo;
import com.liweijian.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 测试动态代理映射查找方式
 * */
public class MapperTest {

        private SqlSessionFactory sessionFactory;

        @Before
        public void init() throws IOException {
            //读取主配置文件 默认找classpath下的，也就是src下
            InputStream stream = Resources.getResourceAsStream("sqlMapConfig.xml");
            //创建工厂
            sessionFactory = new SqlSessionFactoryBuilder().build(stream);
        }


        @Test
        public void findUserById() throws IOException {

            //获得sqlSession
            SqlSession sqlSession = sessionFactory.openSession();
            //获取映射对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.findUserById(10);
            System.out.println(user);
        }

    //根据用户名称模糊查询用户列表
    @Test
    public void findUserByUsername() throws IOException {

        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.findUserByUsername("五");
        for (Object u: user) {
            System.out.println(u);
        }
    }

    //添加用户
    @Test
    public void insertUser() throws IOException {

        //获得sqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        //获取映射对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("老王ba");
        user.setAddress("广东");
        user.setBirthday(new Date());
        user.setSex("男");

        mapper.insertUser(user);
        sqlSession.commit();
    }

    //更新用户
    @Test
    public void updateUserById() throws IOException {
        SqlSession sqlSession = sessionFactory.openSession();

        User user = new User();
        user.setId(29);
        user.setUsername("老王ya");
        user.setAddress("广东湛江emm");
        user.setBirthday(new Date());
        user.setSex("女");

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUserById(user);

        sqlSession.commit();
    }

    //删除用户
    @Test
    public void deleteUserById() throws IOException {

        SqlSession sqlSession = sessionFactory.openSession();

        User user = new User();
        user.setId(29);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUserById(user);
        sqlSession.commit();
    }

    //    根据用户名模糊查询用户信息
    @Test
    public void selectUserByQueryVo() throws IOException {

        SqlSession sqlSession = sessionFactory.openSession();

        User user = new User();
        user.setUsername("五");
        QueryVo vo = new QueryVo();
        vo.setUser(user);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUserByQueryVo(vo);
        for (User u: users) {
            System.out.println(u);
        }
    }

    //查询用户表数据条数
    @Test
    public void UserCount() throws IOException {

        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Integer count = mapper.UserCount();
        System.out.println(count);
    }


    //查询订单表order的所有数据
    @Test
    public void selectAllOrders() throws IOException {

        SqlSession sqlSession = sessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> ordersList = mapper.selectAllOrders();

        for (Orders o: ordersList) {
            System.out.println(o);
        }

    }

    //根据性别和名字查询用户
    @Test
    public void selectUserBySexAndUsername() throws IOException {

        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setSex("1");
//        user.setUsername("张小明");
//        QueryVo vo = new QueryVo();
//        vo.setUser(user);

        List<User> userList = mapper.selectUserBySexAndUsername(user);
        for (User u: userList) {
            System.out.println(u);
        }
    }

    //根据多个id查询用户信息
    @Test
    public void selectUserByIds() throws IOException {

        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<Integer> ids = new ArrayList<>();
        ids.add(16);
        ids.add(22);
        ids.add(24);

      /* Integer[] ids = new Integer[3];
       ids[0] = 16;
       ids[1] = 22;
       ids[2] = 24;*/


//        QueryVo vo = new QueryVo();
//        vo.setIdList(ids);
        List<User> userList = mapper.selectUserByIds(ids);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    //查询所有订单信息，关联查询下单用户信息
    @Test
    public void selectOrdersOfUser() throws IOException {

        SqlSession sqlSession = sessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> orders = ordersMapper.selectOrdersOfUser();
        for (Orders o : orders) {
            System.out.println(o);
        }
    }

    //查询所有用户信息及用户关联的订单信息。
    @Test
    public void selectUserAndOrders() throws IOException {

        SqlSession sqlSession = sessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<User> users = ordersMapper.selectUserAndOrders();

        for (User u : users) {
            System.out.println(u);
        }
    }



}
