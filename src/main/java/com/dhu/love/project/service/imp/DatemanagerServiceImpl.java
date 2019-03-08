package com.dhu.love.project.service.imp;

import com.dhu.love.project.dao.DatemanagerDao;
import com.dhu.love.project.entity.Datemanager;
import com.dhu.love.project.service.DatemanagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DatemanagerServiceImpl implements DatemanagerService {
    @Autowired
    DatemanagerDao datemanagerDao;
    @Override
    public int addDate(Datemanager datemanager)
    {
        return datemanagerDao.addDate(datemanager);
    }
    public  int updateDate(Datemanager datemanager)
    {
        return datemanagerDao.updateDate(datemanager);
    }
    public  int deleteDate(int mid)
    {
        return  datemanagerDao.deleteDate(mid);
    }
    public  int updateCustomer(String status,int mmid,int mfid){return  datemanagerDao.updateCuster(status,mmid,mfid);}
    public Map findDateByname(String mmname)
    {
        return  datemanagerDao.findDateByname(mmname);
    }
    public Datemanager findDateOne(String mmid,String mmmobile,String mfid,String mfmobile)
    {
        return  datemanagerDao.findDateOne(mmid,mmmobile,mfid,mfmobile);
    }
    public  Map findDateAll(){return  datemanagerDao.findDateAll();}
}
