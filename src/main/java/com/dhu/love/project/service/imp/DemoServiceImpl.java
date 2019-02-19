package com.dhu.love.project.service.imp;

import com.dhu.love.project.dao.DemoDao;
import com.dhu.love.project.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    DemoDao demoDao;
    @Override
    public String searchLove(String param) {
        return demoDao.searchLove(param);
    }
}
