package com.dhu.love.project.service.imp;

import com.dhu.love.project.dao.UserRequirementDao;
import com.dhu.love.project.entity.UserRequirement;
import com.dhu.love.project.service.UserRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRequirementServiceImpl implements UserRequirementService {
    @Autowired
    UserRequirementDao userRequirementDao;
    @Override
    public int addUserRequirement(UserRequirement userRequirement)
    {
        return userRequirementDao.addUserRequirement(userRequirement);
    }
    public int updateUserRequirement(UserRequirement userRequirement)
    {
        return userRequirementDao.updateUserRequirement(userRequirement);
    }
    public int deleteUserRequirement(int rid)
    {
        return userRequirementDao.deleteUserRequirement(rid);
    }
}
