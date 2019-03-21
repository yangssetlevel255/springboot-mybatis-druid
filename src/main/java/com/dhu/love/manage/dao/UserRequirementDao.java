package com.dhu.love.manage.dao;

import com.dhu.love.grade.model.CustomerRequire;
import com.dhu.love.manage.mapper.UserRequirementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRequirementDao {
    @Autowired
    UserRequirementMapper userRequirementMapper;
    public  int addUserRequirement(CustomerRequire customerRequire){return userRequirementMapper.addUserRequirement(customerRequire);}
    public  int updateUserRequirement(CustomerRequire customerRequire){return  userRequirementMapper.updateUserRequirement(customerRequire);}
    public  int deleteUserRequirement(int rid){return userRequirementMapper.deleteUserRequirement(rid);}
}
