package com.dhu.love.manage.service.imp;

import com.dhu.love.manage.dao.DateManagerDao;
import com.dhu.love.manage.entity.DateManager;
import com.dhu.love.manage.service.DateManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.List;

@Service
public class DateManagerServiceImpl implements DateManagerService {
    @Autowired
    DateManagerDao dateManagerDao;
    @Override
    public int addDate(DateManager dateManager)
    {
        return dateManagerDao.addDate(dateManager);
    }
    public  int updateDate(DateManager dateManager)
    {
        return dateManagerDao.updateDate(dateManager);
    }
    public  int deleteDate(int id)
    {
        return  dateManagerDao.deleteDate(id);
    }
    public  int updateCustomer(String status,int mmId,int mfId){return  dateManagerDao.updateCustomer(status,mmId,mfId);}
    public List<DateManager> findDateByName(String name)
    {
        return  dateManagerDao.findDateByName(name);
    }
    public DateManager findDateOne(String mmId,String mmMobile,String mfId,String mfMobile)
    {
        return  dateManagerDao.findDateOne(mmId,mmMobile,mfId,mfMobile);
    }
    public  List<DateManager> findDateAll()
    {
        return  dateManagerDao.findDateAll();}
}
