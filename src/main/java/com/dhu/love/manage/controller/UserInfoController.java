package com.dhu.love.manage.controller;

import com.dhu.love.manage.entity.UserInfo;
import com.dhu.love.manage.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import com.dhu.love.manage.util.DateUtil;

@Controller
@RequestMapping(value = "api")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    @RequestMapping(value = "addUser", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String addUser(@RequestParam Map<String,String> map, HttpServletRequest request, HttpServletResponse response)
    {
        UserInfo userInfo = new UserInfo();
        DateUtil dateUtil = new DateUtil();
        userInfo.setUsername(map.get("username"));
        userInfo.setUsersex(map.get("usersex"));
        userInfo.setBirthdate(dateUtil.strToDate(map.get("birthdate")));
        userInfo.setBirthlocation(map.get("birthlocation"));
        userInfo.setStatus(Integer.valueOf(map.get("status")));
        userInfo.setMobile(map.get("mobile"));
        userInfo.setCompany(map.get("company"));
        userInfo.setAddress(map.get("address"));
        userInfo.setGmt_create(dateUtil.strToDate(map.get("gmt_create")));
        userInfo.setCreate_id(map.get("create_id"));
        userInfo.setGmt_modified(map.get("gmt_modified"));
        userInfo.setModified_id(map.get("modified_id"));
        userInfo.setSalary(Integer.valueOf(map.get("salary")));
        userInfo.setHousenumber(Integer.valueOf(map.get("housenumer")));
        userInfo.setHobby(map.get("hobby"));
        userInfo.setCharactor(map.get("charactor"));
        userInfo.setEducation(map.get("education"));
        userInfo.setCar(map.get("car"));
        userInfo.setJobtitle(map.get("jobtitle"));
        userInfo.setDivorce(map.get("divorce"));
        //生成全局唯一uuid
        String uuid = java.util.UUID.randomUUID().toString();
        userInfo.setUuid(uuid);
        userInfoService.addUser(userInfo);
        if ( userInfoService.findUserInfo(uuid)!=null)
        {

            return "新增记录成功!";

        }
        else
        {
            return "记录新增失败!";
        }

    }


}
