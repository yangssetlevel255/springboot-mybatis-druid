package com.dhu.love.manage.service;
import com.dhu.love.manage.entity.User;

public interface UserService {
    User login(String username);
    User register(String username,String passwd);
    boolean addUser(String username,String passwd);
   // Map getUser(String username);
   // User findUser(User user);
    User findOne(String username);
    String passwordToHash(String password);
}
