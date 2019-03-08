package com.dhu.love.project.dao;

import com.dhu.love.project.entity.UserProfile;
import com.dhu.love.project.mapper.UserProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserProfileDao {
    @Autowired
    UserProfileMapper userProfileMapper;
    public int addRequire(UserProfile userProfile){return  userProfileMapper.addRequire(userProfile);}
    public int updateRequire(UserProfile userProfile){return  userProfileMapper.updateRequire(userProfile);}
    public int deleteRequire(UserProfile userProfile){return  userProfileMapper.deleteRequire(userProfile);}
    public UserProfile findRequire(String uuid){ return userProfileMapper.findRequire(uuid);}

}
