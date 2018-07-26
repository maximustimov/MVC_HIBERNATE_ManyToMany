package com.endava.springmvc.dao;

import com.endava.springmvc.model.UserProfile;

import java.util.List;

public interface UserProdileDao {
    List<UserProfile> findAll();
    UserProfile findByType(String type);
    UserProfile findById(int id);

}
