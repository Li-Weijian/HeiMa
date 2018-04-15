package com.liweijian.junit;

import com.liweijian.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisFirstTest {

    //根据id查找用户
    @Test
    public void findUserById() throws IOException {
        //读取主配置文件 默认找classpath下的，也就是src下
        InputStream stream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
        //获得sqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        //执行操作
        //第一个参数是User.xml中的对应sql的id，第二个参数是sql需要的参数
        User user = sqlSession.selectOne("test.findUserById", 1);

        System.out.println(user);
    }

    //根据用户名称模糊查询用户列表
    @Test
    public void findUserByUsername() throws IOException {

        InputStream stream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sessionFactory.openSession();
        List<Object> user = sqlSession.selectList("test.findUserByUsername", "五");

        for (Object u: user) {
            System.out.println(u);
        }
    }

    //添加用户
    @Test
    public void insertUser() throws IOException {

        InputStream stream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sessionFactory.openSession();

        User user = new User();
        user.setUsername("老王");
        user.setAddress("广东湛江");
        user.setBirthday(new Date());
        user.setSex("男");

        sqlSession.insert("test.insertUser",user);

        System.out.println(user.getId());
        sqlSession.commit();
    }

    //更新用户
    @Test
    public void updateUserById() throws IOException {

        InputStream stream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sessionFactory.openSession();

        User user = new User();
        user.setId(28);
        user.setUsername("老王ya");
        user.setAddress("广东湛江emm");
        user.setBirthday(new Date());
        user.setSex("女");

        sqlSession.update("test.updateUserById",user);

        sqlSession.commit();
    }

    //删除用户
    @Test
    public void deleteUserById() throws IOException {

        InputStream stream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sessionFactory.openSession();

        User user = new User();
        user.setId(28);

        sqlSession.update("test.deleteUserById",user);

        sqlSession.commit();
    }

}
