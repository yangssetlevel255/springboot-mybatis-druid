package com.dhu.love.manage.service.imp;

import com.dhu.love.grade.model.Customer;
import com.dhu.love.manage.dao.CustomerInfoDao;
import com.dhu.love.manage.service.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {

    @Autowired
    CustomerInfoDao customerInfoDao;
    @Override
    public int addCustomer(Customer customer) {
        return 0;
    }

    @Override
    public int updateCustomer(Customer customer) {
        return 0;
    }

    @Override
    public int deleteCustomer(int customer_id) {
        return 0;
    }

    @Override
    public List<Customer> findCustomerByname(String customer_name) {
        return null;
    }

    @Override
    public Customer findCustomerOne(String customer_name, String phone_number) {
        return null;
    }

    @Override
    public List<Customer> findCustomerAll() {
        return customerInfoDao.findCustomerAll();
    }

    @Override
    public int totalCustomer() {
        return 0;
    }
}
