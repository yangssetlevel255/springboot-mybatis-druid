package com.dhu.love.manage.mapper;

import com.dhu.love.grade.model.Customer;
import com.dhu.love.manage.entity.CustomerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerInfoMapper {
    int addCustomerInfo(CustomerInfo customerInfo);
    int updateCustomerInfo(CustomerInfo customerInfo);
    int deleteCustomerInfo(int customer_id);
    Map findCustomerByname(String customer_name);
    CustomerInfo findCustomerOne(String customer_name, String phone_number);
    List<Customer> findCustomerAll();
    int totalCustomer();
}
