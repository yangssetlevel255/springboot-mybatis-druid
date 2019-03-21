package com.dhu.love.manage.mapper;

import com.dhu.love.grade.model.CustomerRequire;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRequirementMapper {
    int addUserRequirement(CustomerRequire customerRequire);
    int updateUserRequirement(CustomerRequire customerRequire);
    int deleteUserRequirement(int rid);
}
