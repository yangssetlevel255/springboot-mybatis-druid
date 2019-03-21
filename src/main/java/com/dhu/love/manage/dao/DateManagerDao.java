package com.dhu.love.manage.dao;

import com.dhu.love.manage.entity.DateManager;
import com.dhu.love.manage.mapper.DateManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.List;

@Component
public class DateManagerDao {
    @Autowired
    DateManagerMapper dateManagerMapper;
    public int addDate(DateManager dateManager){return dateManagerMapper.addDate(dateManager);}
    public int updateDate(DateManager dateManager){return  dateManagerMapper.updateDate(dateManager);}
    public int deleteDate(int  mid){return  dateManagerMapper.deleteDate(mid);}
    public int updateCustomer(String status,int mmid,int mfid){return  dateManagerMapper.updateCustomer(status,mmid,mfid);}
    public List<DateManager> findDateByName(String name){ return dateManagerMapper.findDateByName(name);}
    public DateManager findDateOne(String mmid,String mmmobile,String mfid,String mfmobile){return dateManagerMapper.findDateOne(mmid,mmmobile,mfid,mfmobile);}
    public List<DateManager> findDateAll(){return  dateManagerMapper.findDateAll();}
}