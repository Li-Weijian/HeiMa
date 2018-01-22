package com.liweijian.test2;

import com.liweijian.bean.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:06 2018/1/22 0022
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template;

    @Override
    public void save(User user) {

        String sql = "insert into t_user values (null,?)";
        template.update(sql,user.getName());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from  t_user where id = ?";
        template.update(sql,id);
    }

    @Override
    public void update(User user) {
        String sql = "update t_user set name = ? where id = ?";
        template.update(sql,user.getName(),user.getId());
    }

    @Override
    public User getById(Integer id) {
        String sql = "select * from t_user where id = ?";
        return template.queryForObject(sql, new RowMapper<User>() {

            @Override
            //实现接口封装对象并返回。
            //类似与DBUtils，只不过DBUtils帮我们实现了这些分装方法
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                return user;
            }
        },id);
    }

    @Override
    public int getByTotalCount() {
        String sql = "select count(*) from t_user";
        Integer count = template.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<User> getAll() {
        String sql = "select * from t_user";

        List<User> query = template.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                return user;
            }
        });

        return query;
    }


    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
}
