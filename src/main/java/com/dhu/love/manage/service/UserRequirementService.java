package com.dhu.love.manage.service;

import com.dhu.love.manage.entity.UserRequirement;

public interface UserRequirementService {
    int addUserRequirement(UserRequirement userRequirement);
    int updateUserRequirement(UserRequirement userRequirement);
    int deleteUserRequirement(int customer_id);
}
