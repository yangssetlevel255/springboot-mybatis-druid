package com.dhu.love.project.mapper;

import com.dhu.love.project.entity.User;
import com.dhu.love.project.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserInfoMapper {
    int addUser(UserInfo userInfo);
    int updateByPrimaryKey(UserInfo userInfo);
    int deleteByPrimaryKey(String  uuid);
    UserInfo findUserInfo(String uuid);
}
