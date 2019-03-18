package com.dhu.love.manage.mapper;

import com.dhu.love.manage.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {
    int addUser(UserInfo userInfo);
    int updateByPrimaryKey(UserInfo userInfo);
    int deleteByPrimaryKey(String  uuid);
    UserInfo findUserInfo(String uuid);
}
