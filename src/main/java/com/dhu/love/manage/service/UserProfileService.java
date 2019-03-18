package com.dhu.love.manage.service;

import com.dhu.love.manage.entity.UserProfile;

public interface UserProfileService {
    UserProfile addRequire(UserProfile userProfile);
    UserProfile updateRequire(UserProfile userProfile);
    UserProfile deleteRequire(String uuid);
    UserProfile findRequire(String uuid);
}
