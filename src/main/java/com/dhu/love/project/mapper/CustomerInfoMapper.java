package com.dhu.love.project.mapper;

import com.dhu.love.project.entity.CustomerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface CustomerInfoMapper {
    int addCustomerInfo(CustomerInfo customerInfo);
    int updateCustomerInfo(CustomerInfo customerInfo);
    int deleteCustomerInfo(int customer_id);
    Map findCustomerByname(String customer_name);
    CustomerInfo findCustomerOne(String customer_name, String phone_number);
    Map findCustomerAll();
    int totalCustomer();
}
