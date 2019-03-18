package com.dhu.love.manage.service.imp;

import com.dhu.love.manage.dao.UserInfoDao;
import com.dhu.love.manage.entity.UserInfo;
import com.dhu.love.manage.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoDao userInfoDao;
    @Override
    public UserInfo addUser(UserInfo userInfo)
    {
        userInfoDao.addUser(userInfo);
        return userInfoDao.findUserInfo(userInfo.getUuid());
    }
    public UserInfo updateByPrimaryKey(UserInfo userInfo)
    {
        userInfoDao.updateByPrimaryKey(userInfo);
        return userInfoDao.findUserInfo(userInfo.getUuid());
    }
    public UserInfo deleteByPrimaryKey(String uuid)
    {
        userInfoDao.deleteByPrimaryKey(uuid);
        return  userInfoDao.findUserInfo(uuid);
    }
    public  UserInfo findUserInfo(String uuid)
    {
        return userInfoDao.findUserInfo(uuid);
    }

}
