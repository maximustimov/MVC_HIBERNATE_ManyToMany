package com.endava.springmvc.converter;

import com.endava.springmvc.model.UserProfile;
import com.endava.springmvc.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleToUserProfileConverter implements Converter<Object,UserProfile>{
    @Autowired
    UserProfileService userProfileService;

    public UserProfile convert(Object element){
        Integer id=Integer.parseInt((String)element);
        UserProfile userProfile=userProfileService.findById(id);
        System.out.println("Profile: "+userProfile);
        return  userProfile;
    }
}
