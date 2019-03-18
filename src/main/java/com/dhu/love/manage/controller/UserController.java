package com.dhu.love.manage.controller;

import  com.dhu.love.manage.entity.User;
import com.dhu.love.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value="api")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "login",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String login_check(HttpServletRequest request, HttpServletResponse response, @RequestParam("username") String username, @RequestParam("passwd") String passwd)
    {
        User user = userService.login(username);
        String convese = userService.passwordToHash(passwd);
        if (user!=null && convese.equals(user.getPasswd())) {
            return "登录成功";
        }
        else if(user!=null && !convese.equals(user.getPasswd()))
        {
            return "密码错误";
        }
        else
        {
            return "用户不存在,请先注册";
        }
    }

    @RequestMapping(value = "register",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String register_check(HttpServletRequest request, HttpServletResponse response,@RequestParam("username") String username, @RequestParam("passwd") String passwd)
    {
        User user = userService.login(username);
        if (user!=null){
            return "用户已经存在!";
        }
        else
        {
            passwd = userService.passwordToHash(passwd);
            userService.register(username,passwd);
            if (userService.findOne(username) !=null)
            {
                return "用户" + username + "创建成功!";
            }
            else
            {
                return "用户创建失败";
            }
        }
    }

}
