package com.dhu.love.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.dhu.love.project.entity.User;
@Mapper
public interface UserMapper {
    User login(@Param("username") String username);
    int register(@Param("username") String username, @Param("passwd") String passwd);
    User findOne(@Param("username") String username);
}
