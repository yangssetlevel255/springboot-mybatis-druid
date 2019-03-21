package com.dhu.love.manage.service;

import com.dhu.love.grade.model.CustomerRequire;

public interface UserRequirementService {
    int addUserRequirement(CustomerRequire customerRequire);
    int updateUserRequirement(CustomerRequire customerRequire);
    int deleteUserRequirement(int customerId);
}
