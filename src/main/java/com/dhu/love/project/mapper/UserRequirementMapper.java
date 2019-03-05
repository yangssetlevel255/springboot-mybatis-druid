package com.dhu.love.project.mapper;

import com.dhu.love.project.entity.UserRequirement;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRequirementMapper {
    int addUserRequirement(UserRequirement userRequirement);
    int updateUserRequirement(UserRequirement userRequirement);
    int deleteUserRequirement(int rid);
}
