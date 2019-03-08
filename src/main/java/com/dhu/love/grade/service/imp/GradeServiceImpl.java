package com.dhu.love.grade.service.imp;

import com.dhu.love.grade.mapper.GradeMapper;
import com.dhu.love.grade.model.Customer;
import com.dhu.love.grade.model.CustomerRequire;
import com.dhu.love.grade.service.GradeService;
import com.dhu.love.grade.util.CommonData;
import com.dhu.love.grade.util.CustomerBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeMapper gradeMapper;
    @Autowired
    CommonData commonData;
    @Autowired
    CustomerBaseImpl customerBase;


    @Override
    public Customer queryCustomerById(String CustomerId) {
        return gradeMapper.queryCustomerById(CustomerId);
    }

    @Override
    public List<CustomerRequire> queryCustomerRequireById(String CustomerId) {
        return null;
    }

    @Override
    public List<Customer> queryCustomerByRequire(Map requireMap) {
        return null;
    }

    @Override
    public List<Customer> getMostSuitableCustomer(String CustomerId) {
        //相亲对象
        Customer customer=gradeMapper.queryCustomerById(CustomerId);
        CustomerRequire customerRequire=gradeMapper.queryCustomerRequireById(CustomerId);
        customerBase.init(customerRequire,commonData,customer);
        List<Customer> customerList=customerBase.queryCustomerByMostImportantRequire();
        List<Customer> mostSuitableCustomerList=customerBase.doScore(customerList);
        return mostSuitableCustomerList;
    }
}
