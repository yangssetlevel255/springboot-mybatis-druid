package com.dhu.love.manage.mapper;

import com.dhu.love.grade.model.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerInfoMapper {
    int addCustomerInfo(Customer customer);
    int updateCustomerInfo(Customer customer);
    int deleteCustomerInfo(int customeId);
    List<Customer> findCustomerByname(String customerName);
    Customer findCustomerOne(String customerName, String phoneNumber);
    List<Customer> findCustomerAll();
    int totalCustomer();
}
