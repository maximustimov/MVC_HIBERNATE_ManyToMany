package com.endava.springmvc.dao;

import com.endava.springmvc.model.User;

import java.util.List;

public interface UserDao {
    User findById(int id);
    User findBySSO(String sso);
    void save(User user);
    void deleteBySSO(String sso);
    List<User> findAllUsers();
}
