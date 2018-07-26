package com.endava.springmvc.service;

import com.endava.springmvc.dao.UserProdileDao;
import com.endava.springmvc.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProdileDao userProdileDao;

    @Override
    public UserProfile findById(int id) {
        return userProdileDao.findById(id);
    }

    @Override
    public UserProfile findByType(String type) {
        return userProdileDao.findByType(type);
    }

    @Override
    public List<UserProfile> findAll() {
        return userProdileDao.findAll();
    }
}
