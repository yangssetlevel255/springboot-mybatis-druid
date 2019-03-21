package com.dhu.love.manage.service;

import com.dhu.love.grade.model.Customer;

import java.util.List;

public interface CustomerInfoService {
    int addCustomer(Customer customerInfo);
    int updateCustomer(Customer customer);
    int deleteCustomer(int customer_id);
    List<Customer> findCustomerByname(String customer_name); //用户名查询
    Customer findCustomerOne(String customerName,String phoneNumber);  //用户名+手机号 确定唯一用户;
    List<Customer> findCustomerAll(); //首页显示
    int totalCustomer(); //用户数
}
