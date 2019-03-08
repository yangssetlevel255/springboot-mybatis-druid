package com.dhu.love.project.controller;

import com.dhu.love.project.entity.UserProfile;
import com.dhu.love.project.service.UserInfoService;
import com.dhu.love.project.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping (value = "api")

public class UserProfileController {
    @Autowired
    UserProfileService userProfileService;
    UserInfoService userInfoService;
    @RequestMapping(value = "addRequire", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String addRequire(@RequestParam Map<String,String> map, HttpServletRequest request, HttpServletResponse response)
    {
        UserProfile userProfile =new UserProfile();

        userProfile.setUuid(map.get("uuid"));
        Integer userid = userInfoService.findUserInfo(userProfile.getUuid()).getUserid();
        userProfile.setUserid(userid);
        userProfile.setTdivorce(map.get("tdivorce"));
        userProfile.setTdivorce_p(map.get("tdivorce_p"));
        userProfile.setTchild(map.get("tchild"));
        userProfile.setTchild_p(map.get("tchild_p"));
        userProfile.setTlocal(map.get("tlocal"));
        userProfile.setTlocal_p(map.get("tlocal_p"));
        userProfile.setThouse(map.get("thouse"));
        userProfile.setThouse_p(map.get("thouse_p"));
        userProfile.setTcar(map.get("tcar"));
        userProfile.setTcar_p(map.get("tcar_p"));
        userProfile.setTsalary(map.get("tsalary"));
        userProfile.setTsalary_p(map.get("tsalary_p"));
        userProfile.setTeducation(map.get("teducation"));
        userProfile.setTeducation_p(map.get("teducation_p"));
        userProfile.setTbirthmin(Integer.valueOf(map.get("tbirthmin")));
        userProfile.setTbirthmax(Integer.valueOf(map.get("tbirthmax")));
        userProfile.setTbirth_p(map.get("tbirth_p"));
        userProfile.setRequirement(map.get("requirement"));
        userProfile.setRequirement_p(map.get("requirement_p"));
        userProfileService.addRequire(userProfile);
        if (userProfileService.findRequire(userProfile.getUuid())!= null)
        {
            return "添加成功";
        }
        else
        {
            return "添加失败";
        }

    }
}
