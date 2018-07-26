package com.endava.springmvc.service;

import com.endava.springmvc.model.User;

import java.util.List;

public interface UserService {
    User findById(int id);

    User findBySSO(String sso);

    void saveUser(User user);

    void updateUser(User user);

    void deleteBySSO(String sso);

    List<User> findAllUsers();

    boolean isUsersSSOUnique(Integer id, String sso);
}
