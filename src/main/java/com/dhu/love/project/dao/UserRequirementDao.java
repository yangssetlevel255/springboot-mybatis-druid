package com.dhu.love.project.dao;

import com.dhu.love.project.entity.UserRequirement;
import com.dhu.love.project.mapper.UserRequirementMapper;
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
