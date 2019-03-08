package com.dhu.love.project.controller;

import com.dhu.love.project.entity.CustomerInfo;
import com.dhu.love.project.entity.UserRequirement;
import com.dhu.love.project.service.CustomerInfoService;
import com.dhu.love.project.service.UserRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RequestMapping(value = "api")
public class CustomerInfoController {
    @Autowired
    CustomerInfoService customerInfoService;
    UserRequirementService userRequirementService;
    @RequestMapping(value = "addCustomer" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String addCustomer(@RequestParam Map <String,String> map, HttpServletRequest request, HttpServletResponse response)
    {
        CustomerInfo customerInfo =new CustomerInfo();
        customerInfo.setCustomer_name(map.get("customer_name"));
        customerInfo.setGender(map.get("gender"));
        customerInfo.setBirthday(map.get("birthday"));
        customerInfo.setAge(Integer.valueOf(map.get("age")));
        customerInfo.setBirth_place(map.get("birth_place"));
        customerInfo.setAddress(map.get("address"));
        customerInfo.setPhone_number(map.get("phone_number"));
        customerInfo.setProfession(map.get("profession"));
        customerInfo.setSalary(Integer.valueOf(map.get("salary")));
        customerInfo.setHouse_number(Integer.valueOf(map.get("house_number")));
        customerInfo.setCar(map.get("setcar"));
        customerInfo.setHobby(map.get("hobby"));
        customerInfo.setPersonality(map.get("personality"));
        customerInfo.setDivorce(map.get("divorce"));
        customerInfo.setCompany(map.get("company"));
        customerInfo.setChild(Integer.valueOf(map.get("child")));
        // 设置用户状态 可匹配 进行中 停用 默认新增用户的时候 default值为可匹配
        customerInfo.setStatus("可匹配");

        //插入customer_info表

        if(customerInfoService.findCustomerOne(customerInfo.getCustomer_name(),customerInfo.getPhone_number())!= null)
        {
            return "新增失败...该用户已经存在!";
        }
        else
        {
            customerInfoService.addCustomer(customerInfo);
            UserRequirement userRequirement = new UserRequirement();
            userRequirement.setCustomer_id(customerInfoService.findCustomerOne(customerInfo.getCustomer_name(),customerInfo.getPhone_number()).getCustomer_id());
            userRequirement.setTdivorce(map.get("tdivorce"));
            userRequirement.setTdivorce_p(Integer.valueOf(map.get("tdivorce_p")));
            userRequirement.setTchild(map.get("tchild"));
            userRequirement.setTchild_p(Integer.valueOf(map.get("tchild_p")));
            userRequirement.setTlocal(map.get("tlocal"));
            userRequirement.setTlocal_p(Integer.valueOf(map.get("tlocal_p")));
            userRequirement.setThouse(map.get("thouse"));
            userRequirement.setThouse_p(Integer.valueOf(map.get("thouse_p")));
            userRequirement.setTcar(map.get("tcar"));
            userRequirement.setTcar_p(Integer.valueOf(map.get("tcar_p")));
            userRequirement.setTsalary(map.get("tsalary"));
            userRequirement.setTsalary_p(Integer.valueOf(map.get("tsalary_p")));
            userRequirement.setTeducation(map.get("teducation"));
            userRequirement.setTeducation_p(Integer.valueOf(map.get("teducation_p")));
            userRequirement.setTbirthmin(Integer.valueOf(map.get("tbirthmin")));
            userRequirement.setTbirthmax(Integer.valueOf(map.get("tbirthmax")));
            userRequirement.setTbirth_p(Integer.valueOf(map.get("tbirth_p")));
            userRequirement.setRequirement(map.get("requirement"));
            userRequirement.setRequirement_p(Integer.valueOf(map.get("requirement_p")));
            userRequirement.setTprofession(map.get("tprofession"));
            userRequirement.setTprofession_p(Integer.valueOf(map.get("tprofession_p")));

            //插入 user_requirement
            userRequirementService.addUserRequirement(userRequirement);

            return  "用户新增成功!";

        }


    }
    @RequestMapping(value = "updateCustomer" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String updateCustomer(@RequestParam Map <String,String> map, HttpServletRequest request, HttpServletResponse response)
    {
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustomer_id(Integer.valueOf(map.get("customer_id")));
        customerInfo.setCustomer_name(map.get("customer_name"));
        customerInfo.setGender(map.get("gender"));
        customerInfo.setBirthday(map.get("birthday"));
        customerInfo.setAge(Integer.valueOf(map.get("age")));
        customerInfo.setBirth_place(map.get("birth_place"));
        customerInfo.setAddress(map.get("address"));
        customerInfo.setPhone_number(map.get("phone_number"));
        customerInfo.setProfession(map.get("profession"));
        customerInfo.setSalary(Integer.valueOf(map.get("salary")));
        customerInfo.setHouse_number(Integer.valueOf(map.get("house_number")));
        customerInfo.setCar(map.get("setcar"));
        customerInfo.setHobby(map.get("hobby"));
        customerInfo.setPersonality(map.get("personality"));
        customerInfo.setDivorce(map.get("divorce"));
        customerInfo.setCompany(map.get("company"));
        customerInfo.setChild(Integer.valueOf(map.get("child")));
        customerInfo.setStatus(map.get("status"));
        customerInfoService.updateCustomer(customerInfo);

        //同步更新user_requirement
        UserRequirement userRequirement = new UserRequirement();
        userRequirement.setRid(Integer.valueOf(map.get("rid")));
        userRequirement.setCustomer_id(Integer.valueOf(map.get("customer_id")));
        userRequirement.setTdivorce(map.get("tdivorce"));
        userRequirement.setTdivorce_p(Integer.valueOf(map.get("tdivorce_p")));
        userRequirement.setTchild(map.get("tchild"));
        userRequirement.setTchild_p(Integer.valueOf(map.get("tchild_p")));
        userRequirement.setTlocal(map.get("tlocal"));
        userRequirement.setTlocal_p(Integer.valueOf(map.get("tlocal_p")));
        userRequirement.setThouse(map.get("thouse"));
        userRequirement.setThouse_p(Integer.valueOf(map.get("thouse_p")));
        userRequirement.setTcar(map.get("tcar"));
        userRequirement.setTcar_p(Integer.valueOf(map.get("tcar_p")));
        userRequirement.setTsalary(map.get("tsalary"));
        userRequirement.setTsalary_p(Integer.valueOf(map.get("tsalary_p")));
        userRequirement.setTeducation(map.get("teducation"));
        userRequirement.setTeducation_p(Integer.valueOf(map.get("teducation_p")));
        userRequirement.setTbirthmin(Integer.valueOf(map.get("tbirthmin")));
        userRequirement.setTbirthmax(Integer.valueOf(map.get("tbirthmax")));
        userRequirement.setTbirth_p(Integer.valueOf(map.get("tbirth_p")));
        userRequirement.setRequirement(map.get("requirement"));
        userRequirement.setRequirement_p(Integer.valueOf(map.get("requirement_p")));
        userRequirement.setTprofession(map.get("tprofession"));
        userRequirement.setTprofession_p(Integer.valueOf(map.get("tprofession_p")));

        userRequirementService.updateUserRequirement(userRequirement);

        return "更新成功!";
    }

    @RequestMapping(value = "deleteCustomer" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String deleteCustomer(@RequestParam Map <String,String> map, HttpServletRequest request, HttpServletResponse response)
    {
        String customer_name = map.get("customer_name");
        String phone_number = map.get("phone_number");
        CustomerInfo customerInfo= customerInfoService.findCustomerOne(customer_name,phone_number);
        if (customerInfo != null) {
            //删除user_info
            int customer_id = customerInfo.getCustomer_id();
            customerInfoService.deleteCustomer(customer_id);
            //同步删除customer_id
            userRequirementService.deleteUserRequirement(customer_id);
            return "删除成功!";
        }
        else
            return "用户不存在!删除失败";

    }
    @RequestMapping(value = "findCustomerAll" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public  Map findCustomerAll()
    {

        Map map = customerInfoService.findCustomerAll();
        System.out.print(map);
        return map;
    }
}
