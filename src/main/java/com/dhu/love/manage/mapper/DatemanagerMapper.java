package com.dhu.love.manage.mapper;

import com.dhu.love.manage.entity.Datemanager;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface DatemanagerMapper {
    int addDate(Datemanager datemanager);
    int updateDate(Datemanager datemanager);
    int deleteDate(int mid);
    int updateCustomer(String status,int mmid,int mfid);
    Map findDateByname(String mmname);
    Datemanager findDateOne(String mmid,String mmmobile,String mfid,String mfmobile);
    Map findDateAll();
}
