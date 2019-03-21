package com.dhu.love.manage.controller;

import com.dhu.love.common.ResponseBean;
import com.dhu.love.grade.model.Customer;
import com.dhu.love.grade.model.CustomerRequire;
import com.dhu.love.manage.service.CustomerInfoService;
import com.dhu.love.manage.service.UserRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "api")
public class CustomerInfoController {

    @Autowired
    CustomerInfoService customerInfoService;


    @Autowired
    UserRequirementService userRequirementService;

    @RequestMapping(value = "addCustomer" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String addCustomer(@RequestParam Map <String,String> map, HttpServletRequest request, HttpServletResponse response)
    {
        Customer customer =new Customer();
        customer.setCustomerName(map.get("customerName"));
        customer.setGender(map.get("gender"));
        customer.setBirthday(map.get("birthday"));
        customer.setAge(Integer.valueOf(map.get("age")));
        customer.setBirthPlace(map.get("birthPlace"));
        customer.setAddress(map.get("address"));
        customer.setPhoneNumber(map.get("phoneNumber"));
        customer.setProfession(map.get("profession"));
        customer.setSalary(Integer.valueOf(map.get("salary")));
        customer.setHouseNumber(Integer.valueOf(map.get("houseNumber")));
        customer.setHaveCar(map.get("haveCar"));
        customer.setHobby(map.get("hobby"));
        customer.setPersonality(map.get("personality"));
        customer.setIsDivorce(map.get("isDivorce"));
        customer.setCompany(map.get("company"));
        customer.setChildNumber(Integer.valueOf(map.get("childNumber")));
        // 设置用户状态 可匹配 进行中 停用 默认新增用户的时候 default值为可匹配
        customer.setStatus("可匹配");

        //插入customer_info表

        if(customerInfoService.findCustomerOne(customer.getCustomerName(),customer.getPhoneNumber())!= null)
        {
            return "新增失败...该用户已经存在!";
        }
        else
        {
            customerInfoService.addCustomer(customer);
            CustomerRequire customerRequire = new CustomerRequire();
            customerRequire.setCustomerId((customerInfoService.findCustomerOne(customer.getCustomerName(),customer.getPhoneNumber())).getCustomerId());
            customerRequire.setDivorceReq(map.get("divorceReq"));
            customerRequire.setDivorceWeg(Integer.valueOf(map.get("divorceWeg")));
            customerRequire.setChildReq(Integer.valueOf(map.get("childReq")));
            customerRequire.setChildWeg(Integer.valueOf(map.get("childWeg")));
            customerRequire.setLocalReq(map.get("localReq"));
            customerRequire.setLocalWeg(Integer.valueOf(map.get("localWeg")));
            customerRequire.setHouseReq(Integer.valueOf(map.get("houseReq")));
            customerRequire.setHouseWeg(Integer.valueOf(map.get("houseWeg")));
            customerRequire.setCarReq(map.get("carReq"));
            customerRequire.setCarWeg(Integer.valueOf(map.get("carWeg")));
            customerRequire.setSalaryReq(Integer.valueOf(map.get("salaryReq")));
            customerRequire.setSalaryWeg(Integer.valueOf(map.get("salaryWeg")));
            customerRequire.setEducationReq(Integer.valueOf(map.get("educationReq")));
            customerRequire.setEducationWeg(Integer.valueOf(map.get("educationWeg")));
            customerRequire.setMinAgeReq(Integer.valueOf(map.get("minAgeReq")));
            customerRequire.setMaxAgeReq(Integer.valueOf(map.get("maxAgeReq")));
            customerRequire.setAgeWeg(Integer.valueOf(map.get("ageWeg")));
            customerRequire.setRequirement(map.get("requirement"));
            customerRequire.setRequirement_p(Integer.valueOf(map.get("requirement_p")));
            customerRequire.setProfessionReq(map.get("professionReq"));
            customerRequire.setProfessionWeg(Integer.valueOf(map.get("professionWeg")));

            //插入 user_requirement
            userRequirementService.addUserRequirement(customerRequire);

            return  "用户新增成功!";

        }


    }
    @RequestMapping(value = "updateCustomer" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String updateCustomer(@RequestParam Map <String,String> map, HttpServletRequest request, HttpServletResponse response)
    {
        Customer customer = new Customer();
        customer.setCustomerId(Integer.valueOf(map.get("customerId")));
        customer.setCustomerName(map.get("customerName"));
        customer.setGender(map.get("gender"));
        customer.setBirthday(map.get("birthday"));
        customer.setAge(Integer.valueOf(map.get("age")));
        customer.setBirthPlace(map.get("birthPlace"));
        customer.setAddress(map.get("address"));
        customer.setPhoneNumber(map.get("phone_number"));
        customer.setProfession(map.get("profession"));
        customer.setSalary(Integer.valueOf(map.get("salary")));
        customer.setHouseNumber(Integer.valueOf(map.get("houseNumber")));
        customer.setHaveCar(map.get("haveCar"));
        customer.setHobby(map.get("hobby"));
        customer.setPersonality(map.get("personality"));
        customer.setIsDivorce(map.get("isDivorce"));
        customer.setCompany(map.get("company"));
        customer.setChildNumber(Integer.valueOf(map.get("childNumber")));
        customer.setStatus(map.get("status"));
        customerInfoService.updateCustomer(customer);

        //同步更新user_requirement
        CustomerRequire customerRequire = new CustomerRequire();
        customerRequire.setRid(Integer.valueOf(map.get("rid")));
        customerRequire.setCustomerId(Integer.valueOf(map.get("customerId")));
        customerRequire.setDivorceReq(map.get("divorceReq"));
        customerRequire.setDivorceWeg(Integer.valueOf(map.get("divorceWeg")));
        customerRequire.setChildReq(Integer.valueOf(map.get("childReq")));
        customerRequire.setChildWeg(Integer.valueOf(map.get("childWeg")));
        customerRequire.setLocalReq(map.get("localReq"));
        customerRequire.setLocalWeg(Integer.valueOf(map.get("localWeg")));
        customerRequire.setHouseReq(Integer.valueOf(map.get("houseReq")));
        customerRequire.setHouseWeg(Integer.valueOf(map.get("houseWeg")));
        customerRequire.setCarReq(map.get("carReq"));
        customerRequire.setCarWeg(Integer.valueOf(map.get("carWeg")));
        customerRequire.setSalaryReq(Integer.valueOf(map.get("salaryReq")));
        customerRequire.setSalaryWeg(Integer.valueOf(map.get("salaryWeg")));
        customerRequire.setEducationReq(Integer.valueOf(map.get("educationReq")));
        customerRequire.setEducationWeg(Integer.valueOf(map.get("educationWeg")));
        customerRequire.setMinAgeReq(Integer.valueOf(map.get("minAgeReq")));
        customerRequire.setMaxAgeReq(Integer.valueOf(map.get("maxAgeReq")));
        customerRequire.setAgeWeg(Integer.valueOf(map.get("ageWeg")));
        customerRequire.setRequirement(map.get("requirement"));
        customerRequire.setRequirement_p(Integer.valueOf(map.get("requirement_p")));
        customerRequire.setProfessionReq(map.get("professionReq"));
        customerRequire.setProfessionWeg(Integer.valueOf(map.get("professionWeg")));

        userRequirementService.updateUserRequirement(customerRequire);

        return "更新成功!";
    }

    @RequestMapping(value = "deleteCustomer" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String deleteCustomer(@RequestParam Map <String,String> map, HttpServletRequest request, HttpServletResponse response)
    {
        String customerName = map.get("customerName");
        String phoneNumber = map.get("phoneNumber");
        Customer customer= customerInfoService.findCustomerOne(customerName,phoneNumber);
        if (customer != null) {
            //删除user_info
            int customerId = customer.getCustomerId();
            customerInfoService.deleteCustomer(customerId);
            //同步删除customer_id
            userRequirementService.deleteUserRequirement(customerId);
            return "删除成功!";
        }
        else
            return "用户不存在!删除失败";

    }
    @RequestMapping(value = "findCustomerAll" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ResponseBean findCustomerAll(HttpServletRequest request, HttpServletResponse response)
    {
        List<Customer> customerList=customerInfoService.findCustomerAll();
        ResponseBean responseBean=new ResponseBean(true,customerList);
        return responseBean;
    }
    @RequestMapping(value = "findCustomerByname" , method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public  ResponseBean findCustomerByName(@RequestParam String customerName, HttpServletRequest request, HttpServletResponse response)
    {
        List<Customer> customerList = customerInfoService.findCustomerByname(customerName);
        ResponseBean responseBean=new ResponseBean(true,customerList);
        return  responseBean;
    }
    @RequestMapping(value = "findCustomerOne" , method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public  ResponseBean findCustomerOne(@RequestParam String customerName,String phoneNumber, HttpServletRequest request, HttpServletResponse response)
    {
        Customer customer = customerInfoService.findCustomerOne(customerName,phoneNumber);
        ResponseBean responseBean=new ResponseBean(true,customer);
        return  responseBean;
    }
    @RequestMapping(value = "totalCustomer", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public int totalCustomer()
    {
        return customerInfoService.totalCustomer();
    }
}
