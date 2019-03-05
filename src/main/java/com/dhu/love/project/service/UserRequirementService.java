package com.dhu.love.project.service;

import com.dhu.love.project.entity.UserRequirement;

public interface UserRequirementService {
    int addUserRequirement(UserRequirement userRequirement);
    int updateUserRequirement(UserRequirement userRequirement);
    int deleteUserRequirement(int customer_id);
}
