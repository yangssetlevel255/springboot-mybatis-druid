package com.dhu.love.manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface DemoMapper {
    Map searchLove(@Param("userId") String userId);
}
