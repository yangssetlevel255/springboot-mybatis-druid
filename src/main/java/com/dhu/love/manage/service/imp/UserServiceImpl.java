package com.dhu.love.manage.service.imp;
import com.dhu.love.manage.dao.UserDao;
import com.dhu.love.manage.entity.User;
import com.dhu.love.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User login(String username)
    {
        return userDao.login(username);

    }
    public  User findOne(String username)
    {
        return userDao.findOne(username);
    }
    public User register(String username,String passwd)
    {
        userDao.register(username,passwd);
        return userDao.findOne(username);
    }
    public boolean addUser(String username,String passwd)
    {
        return true;
    }

  //  public User findUser(String username)
   // {
   //     User param = new User();
   //     param.setUsername(username);
  //      return  userDao.login(param);
   // }
    public String passwordToHash(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(password.getBytes());
            byte[] src = digest.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for (byte aSrc : src) {
                String s = Integer.toHexString(aSrc & 0xFF);
                if (s.length() < 2) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(s);
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException ignore) {
        }
        return null;
    }


}
