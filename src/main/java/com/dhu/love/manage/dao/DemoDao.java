package com.dhu.love.manage.dao;

import com.dhu.love.manage.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DemoDao {
    @Autowired
    DemoMapper demoMapper;
    public Map searchLove(String param){
        return demoMapper.searchLove(param);
    }
}
