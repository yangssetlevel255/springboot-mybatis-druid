package com.dhu.love.manage.service.imp;

import com.dhu.love.manage.dao.UserProfileDao;
import com.dhu.love.manage.entity.UserProfile;
import com.dhu.love.manage.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    UserProfileDao userProfileDao;
    @Override
    public UserProfile addRequire(UserProfile userProfile)
    {
        userProfileDao.addRequire(userProfile);
        return  userProfileDao.findRequire(userProfile.getUuid());
    }
    public  UserProfile updateRequire(UserProfile userProfile)
    {
        userProfileDao.updateRequire(userProfile);
        return  userProfileDao.findRequire(userProfile.getUuid());
    }
    public UserProfile deleteRequire(String uuid)
    {
        return userProfileDao.findRequire(uuid);
    }


    public UserProfile findRequire(String uuid)
    {
        return  userProfileDao.findRequire(uuid);
    }
}
