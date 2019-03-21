package com.dhu.love.manage.service.imp;

import com.dhu.love.grade.model.CustomerRequire;
import com.dhu.love.manage.dao.UserRequirementDao;
import com.dhu.love.manage.service.UserRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRequirementServiceImpl implements UserRequirementService {
    @Autowired
    UserRequirementDao userRequirementDao;
    @Override
    public int addUserRequirement(CustomerRequire customerRequire)
    {
        return userRequirementDao.addUserRequirement(customerRequire);
    }
    public int updateUserRequirement(CustomerRequire customerRequire)
    {
        return userRequirementDao.updateUserRequirement(customerRequire);
    }
    public int deleteUserRequirement(int rId)
    {
        return userRequirementDao.deleteUserRequirement(rId);
    }
}
