package com.dhu.love.manage.dao;

import com.dhu.love.grade.model.Customer;
import com.dhu.love.manage.entity.CustomerInfo;
import com.dhu.love.manage.mapper.CustomerInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CustomerInfoDao {
    @Autowired
    CustomerInfoMapper customerInfoMapper;
    public int addCustomer(CustomerInfo customerInfo){return  customerInfoMapper.addCustomerInfo(customerInfo);}
    public int updateCustomer(CustomerInfo customerInfo){return  customerInfoMapper.updateCustomerInfo(customerInfo);}
    public int deleteCustomer(int customer_id){return  customerInfoMapper.deleteCustomerInfo(customer_id);}
    public Map findCustomerByname(String customer_id){return  customerInfoMapper.findCustomerByname(customer_id);}
    public CustomerInfo findCustomerOne(String customer_id ,String phone_number){return  customerInfoMapper.findCustomerOne(customer_id,phone_number);}
    public List<Customer> findCustomerAll(){return customerInfoMapper.findCustomerAll();}
    public int totalCustomer(){return customerInfoMapper.totalCustomer();}
}
