package com.dhu.love.project.mapper;

import com.dhu.love.project.entity.Datemanager;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface DatemanagerMapper {
    int addDate(Datemanager datemanager);
    int updateDate(Datemanager datemanager);
    int deleteDate(int mid);
    Map findDateByname(String mmname);
    Datemanager findDateOne(String mmid,String mmmobile,String mfid,String mfmobile);
    Map findDateAll();
}
