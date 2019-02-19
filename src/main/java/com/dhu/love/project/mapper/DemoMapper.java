package com.dhu.love.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DemoMapper {
    String searchLove(@Param("param") String param);
}
