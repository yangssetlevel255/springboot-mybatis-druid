package com.dhu.love.manage.service;

import com.dhu.love.grade.model.Customer;
import com.dhu.love.manage.entity.CustomerInfo;

import java.util.List;
import java.util.Map;

public interface CustomerInfoService {
    int addCustomer(CustomerInfo customerInfo);
    int updateCustomer(CustomerInfo customerInfo);
    int deleteCustomer(int customer_id);
    Map findCustomerByname(String customer_name); //用户名查询
    CustomerInfo findCustomerOne(String customer_name,String phone_number);  //用户名+手机号 确定唯一用户;
    List<Customer> findCustomerAll(); //首页显示
    int totalCustomer(); //用户数
}
