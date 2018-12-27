package com.spanish.dao.impl;

import com.spanish.bean.User;
import com.spanish.dao.UserDao;
import com.spanish.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

    @Override
    public void addUser(User user) {
        String sql = "insert into t_user(id,username,password,role,createtime,phone,mail) values(?,?,?,?,?,?,?)";
        try {
            runner.update(sql,user.getId(),user.getUsername(),user.getPassword(),user.getRole(),user.getCreateTime(),user.getPhone(),user.getMail());
        } catch (SQLException e) {
            System.out.println("Fail to add user ");
            e.printStackTrace();
        }
    }

    @Override
    public void delUser(Integer userid) {
        String sql = "delete from t_user t where t.id = ?";
        try {
            System.out.println("Fail to del user");
            runner.update(sql,userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<User> getAllUsers() {
        String sql = "select * from t_user ";
        List<User> userList = null;
        try {
            userList = runner.query(sql,new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            System.out.println("Fail to find all users");
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findUserById(Integer userId) {
        String sql = "select * from t_user where id = ?";
        User user = null;
        try {
            user = runner.query(sql,new BeanHandler<User>(User.class),userId);
        } catch (SQLException e) {
            System.out.println("Fail to find user by id");
            e.printStackTrace();
        }
        return user;

    }

    @Override
    public Integer getMaxUserId() {
        String sql = "select max(id) from t_user ";
        try {
           return (Integer) runner.query(DataSourceUtils.getConnection(),sql,new ScalarHandler(1));
        } catch (SQLException e) {
            System.out.println("没有找到最大的userid");
            e.printStackTrace();
        }
        return null;
    }
}
