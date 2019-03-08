package com.dhu.love.project.service;

import com.dhu.love.project.entity.UserProfile;

public interface UserProfileService {
    UserProfile addRequire(UserProfile userProfile);
    UserProfile updateRequire(UserProfile userProfile);
    UserProfile deleteRequire(String uuid);
    UserProfile findRequire(String uuid);
}
