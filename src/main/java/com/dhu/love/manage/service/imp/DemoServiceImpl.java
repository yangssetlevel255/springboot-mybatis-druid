package com.dhu.love.manage.service.imp;

import com.dhu.love.manage.dao.DemoDao;
import com.dhu.love.manage.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    DemoDao demoDao;
    @Override
    public Map searchLove(String param) {
        return demoDao.searchLove(param);
    }
}
