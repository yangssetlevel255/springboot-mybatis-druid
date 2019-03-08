package com.dhu.love.project.dao;

import com.dhu.love.project.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.dhu.love.project.entity.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class UserInfoDao {
    @Autowired
    UserInfoMapper userInfoMapper;
    public int addUser(UserInfo userInfo) {return userInfoMapper.addUser(userInfo);}
    public int updateByPrimaryKey(UserInfo userInfo){return  userInfoMapper.updateByPrimaryKey(userInfo);}
    public int deleteByPrimaryKey(String  uuid){return  userInfoMapper.deleteByPrimaryKey(uuid);}
    public UserInfo findUserInfo(String uuid){return  userInfoMapper.findUserInfo(uuid);}

}
