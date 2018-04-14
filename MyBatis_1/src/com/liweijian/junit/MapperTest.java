package com.liweijian.junit;

import com.liweijian.mapper.UserMapper;
import com.liweijian.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
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

}
