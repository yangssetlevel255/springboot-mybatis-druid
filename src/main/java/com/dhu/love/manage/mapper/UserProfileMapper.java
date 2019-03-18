package com.dhu.love.manage.mapper;

import com.dhu.love.manage.entity.UserProfile;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserProfileMapper {
    int addRequire(UserProfile userProfile);
    int updateRequire(UserProfile userProfile);
    int deleteRequire(UserProfile userProfile);
    UserProfile findRequire(String uuid);
}
