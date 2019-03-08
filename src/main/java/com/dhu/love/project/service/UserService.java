package com.dhu.love.project.service;
import java.util.Map;
import com.dhu.love.project.entity.User;

public interface UserService {
    User login(String username);
    User register(String username,String passwd);
    boolean addUser(String username,String passwd);
   // Map getUser(String username);
   // User findUser(User user);
    User findOne(String username);
    String passwordToHash(String password);
}
