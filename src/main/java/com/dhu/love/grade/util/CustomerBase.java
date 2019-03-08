package com.dhu.love.grade.util;

import com.dhu.love.grade.model.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerBase {

    List<Customer> queryCustomerByAllRequire(RequireSQL require);
    List<Customer> queryCustomerByMostImportantRequire();
    List<Customer> queryAllCustomer(String gender);
    List<Customer> doScore(List<Customer> customerList);
    Map<String,Object> reSetDefaultParameter();
}
