package com.dhu.love.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.dhu.love.manage.entity.User;
@Mapper
public interface UserMapper {
    User login(@Param("username") String username);
    int register(@Param("username") String username, @Param("passwd") String passwd);
    User findOne(@Param("username") String username);
}
