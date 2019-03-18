package com.dhu.love.manage.dao;

import com.dhu.love.manage.entity.UserRequirement;
import com.dhu.love.manage.mapper.UserRequirementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRequirementDao {
    @Autowired
    UserRequirementMapper userRequirementMapper;
    public  int addUserRequirement(UserRequirement userRequirement){return userRequirementMapper.addUserRequirement(userRequirement);}
    public  int updateUserRequirement(UserRequirement userRequirement){return  userRequirementMapper.updateUserRequirement(userRequirement);}
    public  int deleteUserRequirement(int rid){return userRequirementMapper.deleteUserRequirement(rid);}
}
