package com.dhu.love.grade.mapper;

import com.dhu.love.grade.model.Customer;
import com.dhu.love.grade.model.CustomerRequire;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface GradeMapper {

    Customer queryCustomerById(@Param("customerId") String customerId);
    CustomerRequire queryCustomerRequireById(@Param("customerId") String customerId);
    List<Customer> queryCustomerByRequire(Map<String,Object> map);
    List<String> queryAllAddress();
    List<String> queryAllProfession();
}
