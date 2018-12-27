package com.spanish.dao;

import com.spanish.bean.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    void delUser(Integer userid);

    List<User> getAllUsers();

    User findUserById(Integer userId);

    Integer getMaxUserId();

}
