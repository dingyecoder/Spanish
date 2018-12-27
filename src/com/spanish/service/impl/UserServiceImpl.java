package com.spanish.service.impl;

import com.spanish.bean.User;
import com.spanish.dao.UserDao;
import com.spanish.dao.impl.UserDaoImpl;
import com.spanish.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void delUser(Integer userid) {
        userDao.delUser(userid);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User findUserById(Integer userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public Integer getMaxUserId() {
        return userDao.getMaxUserId();
    }
}
