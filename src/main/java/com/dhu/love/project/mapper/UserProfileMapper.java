package com.dhu.love.project.mapper;

import com.dhu.love.project.dao.UserProfileDao;
import com.dhu.love.project.entity.User;
import com.dhu.love.project.entity.UserProfile;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserProfileMapper {
    int addRequire(UserProfile userProfile);
    int updateRequire(UserProfile userProfile);
    int deleteRequire(UserProfile userProfile);
    UserProfile findRequire(String uuid);
}
