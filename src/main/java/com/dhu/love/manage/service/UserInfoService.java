package com.dhu.love.manage.service;

import com.dhu.love.manage.entity.UserInfo;

public interface UserInfoService {
    UserInfo addUser(UserInfo userInfo);
    UserInfo updateByPrimaryKey (UserInfo userInfo);
    UserInfo deleteByPrimaryKey (String uuid);
    UserInfo findUserInfo(String uuid);
}
