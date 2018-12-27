package com.spanish.service;

import com.spanish.bean.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void delUser(Integer userid);

    List<User> getAllUsers();

    User findUserById(Integer userId);

    Integer getMaxUserId();

}
