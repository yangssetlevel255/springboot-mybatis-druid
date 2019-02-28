package com.dhu.love.project.service;

import com.dhu.love.project.entity.UserInfo;

public interface UserInfoService {
    UserInfo addUser(UserInfo userInfo);
    UserInfo updateByPrimaryKey (UserInfo userInfo);
    UserInfo deleteByPrimaryKey (String uuid);
    UserInfo findUserInfo(String uuid);
}
