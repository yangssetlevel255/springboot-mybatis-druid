package com.dhu.love.project.mapper;

import com.dhu.love.project.entity.Datemanager;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DatemanagerMapper {
    int addDate(Datemanager datemanager);
    int updateDate(Datemanager datemanager);
    int deleteDate(Datemanager datemanager);
    Datemanager findDate(Datemanager datemanager);
}
