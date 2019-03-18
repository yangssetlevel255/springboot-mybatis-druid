package com.dhu.love.manage.dao;

import com.dhu.love.manage.entity.Datemanager;
import com.dhu.love.manage.mapper.DatemanagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DatemanagerDao {
    @Autowired
    DatemanagerMapper datemanagerMapper;
    public int addDate(Datemanager datemanager){return datemanagerMapper.addDate(datemanager);}
    public int updateDate(Datemanager datemanager){return  datemanagerMapper.updateDate(datemanager);}
    public int deleteDate(int  mid){return  datemanagerMapper.deleteDate(mid);}
    public int updateCuster(String status,int mmid,int mfid){return  datemanagerMapper.updateCustomer(status,mmid,mfid);}
    public Map findDateByname(String mmname){ return datemanagerMapper.findDateByname(mmname);}
    public Datemanager findDateOne(String mmid,String mmmobile,String mfid,String mfmobile){return datemanagerMapper.findDateOne(mmid,mmmobile,mfid,mfmobile);}
    public Map findDateAll(){return  datemanagerMapper.findDateAll();}
}
