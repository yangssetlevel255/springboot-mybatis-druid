package com.dhu.love.manage.dao;

import com.dhu.love.grade.model.Customer;
import com.dhu.love.manage.mapper.CustomerInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerInfoDao {
    @Autowired
    CustomerInfoMapper customerInfoMapper;
    public int addCustomer(Customer customer){return  customerInfoMapper.addCustomerInfo(customer);}
    public int updateCustomer(Customer customer){return  customerInfoMapper.updateCustomerInfo(customer);}
    public int deleteCustomer(int customerId){return  customerInfoMapper.deleteCustomerInfo(customerId);}
    public List<Customer> findCustomerByName(String customerId){return  customerInfoMapper.findCustomerByname(customerId);}
    public Customer findCustomerOne(String customerId ,String phoneNumber){return  customerInfoMapper.findCustomerOne(customerId
            ,phoneNumber);}
    public List<Customer> findCustomerAll(){return customerInfoMapper.findCustomerAll();}
    public int totalCustomer(){return customerInfoMapper.totalCustomer();}
}
