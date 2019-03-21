package com.dhu.love.manage.mapper;

import com.dhu.love.manage.entity.DateManager;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;
import java.util.List;

@Mapper
public interface DateManagerMapper {
    int addDate(DateManager datemanager);
    int updateDate(DateManager datemanager);
    int deleteDate(int mid);
    int updateCustomer(String status,int mmid,int mfid);
    List<DateManager> findDateByName(String name);
    DateManager findDateOne(String mmid,String mmmobile,String mfid,String mfmobile);
    List<DateManager> findDateAll();
}
