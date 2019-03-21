package com.dhu.love.manage.service;

import com.dhu.love.manage.entity.DateManager;

import java.util.Map;
import java.util.List;

public interface DateManagerService {
    int addDate(DateManager dateManager);
    int updateDate(DateManager dateManager);
    int deleteDate(int id);
    int updateCustomer(String status,int mmId,int mfId);
    List<DateManager> findDateByName(String name);
    DateManager findDateOne(String mmName,String mmMobile,String mfId,String mfMobile);
    List<DateManager> findDateAll();
}
