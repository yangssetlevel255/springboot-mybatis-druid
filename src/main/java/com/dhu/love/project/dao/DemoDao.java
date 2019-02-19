package com.dhu.love.project.dao;

import com.dhu.love.project.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoDao {
    @Autowired
    DemoMapper demoMapper;
    public String searchLove(String param){
        return demoMapper.searchLove(param);
    }
}
