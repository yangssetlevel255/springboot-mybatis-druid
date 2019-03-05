package com.dhu.love.project.service.imp;

import com.dhu.love.project.dao.CustomerInfoDao;
import com.dhu.love.project.entity.CustomerInfo;
import com.dhu.love.project.service.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {
    @Autowired
    CustomerInfoDao customerInfoDao;

    @Override
    public int addCustomer(CustomerInfo customerInfo)
    {
        return customerInfoDao.addCustomer(customerInfo);
    }
    public int updateCustomer(CustomerInfo customerInfo)
    {
        return customerInfoDao.updateCustomer(customerInfo);
    }
    public int deleteCustomer(int customer_id)
    {
        return customerInfoDao.deleteCustomer(customer_id);
    }
    public Map findCustomerByname(String customer_id)
    {
        return customerInfoDao.findCustomerByname(customer_id);
    }
    public CustomerInfo findCustomerOne(String customer_name, String phone_number)
    {
        return customerInfoDao.findCustomerOne(customer_name,phone_number);
    }
    public Map findCustomerAll()
    {
        return customerInfoDao.findCustomerAll();
    }
    public  int totalCustomer()
    {
        return  customerInfoDao.totalCustomer();
    }
}
