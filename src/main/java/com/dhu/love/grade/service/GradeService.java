package com.dhu.love.grade.service;

import com.dhu.love.grade.model.Customer;
import com.dhu.love.grade.model.CustomerRequire;

import java.util.List;
import java.util.Map;

public interface GradeService {

    //根据id查询客户信息
    Customer queryCustomerById(String CustomerId);

    //根据id查询客户相亲要求，包括各项权重
    List<CustomerRequire> queryCustomerRequireById(String CustomerId);

    //根据客户的相亲要求，查询满足最高权重要求的客户
    List<Customer> queryCustomerByRequire(Map requireMap);

    List<Customer> getMostSuitableCustomer(String CustomerId);

}
