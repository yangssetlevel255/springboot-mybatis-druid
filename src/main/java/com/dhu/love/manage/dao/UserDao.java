package com.dhu.love.manage.dao;

import com.dhu.love.manage.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.dhu.love.manage.entity.User;
@Component
public class UserDao {
    @Autowired
    UserMapper userMapper;
    public User login(String param){
        return userMapper.login(param);
    }
    public int register(String username,String passwd)
    {
        return userMapper.register(username,passwd);
    }
    public User findOne(String username)
    {
        return userMapper.findOne(username);
    }
}
