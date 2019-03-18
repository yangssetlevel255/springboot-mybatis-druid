package com.dhu.love.manage.service;

import com.dhu.love.manage.entity.Datemanager;

import java.util.Map;

public interface DatemanagerService {
    int addDate(Datemanager datemanager);
    int updateDate(Datemanager datemanager);
    int deleteDate(int mid);
    int updateCustomer(String status,int mmid,int mfid);
    Map findDateByname(String mmname);
    Datemanager findDateOne(String mmname,String mmmobile,String mfid,String mfmobile);
    Map findDateAll();
}
