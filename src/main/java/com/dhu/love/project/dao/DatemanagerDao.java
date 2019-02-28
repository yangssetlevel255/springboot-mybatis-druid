package com.dhu.love.project.dao;

import com.dhu.love.project.entity.Datemanager;
import com.dhu.love.project.mapper.DatemanagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatemanagerDao {
    @Autowired
    DatemanagerMapper datemanagerMapper;
    public int addDate(Datemanager datemanager){return datemanagerMapper.addDate(datemanager);}
    public int updateDate(Datemanager datemanager){return  datemanagerMapper.updateDate(datemanager);}
    public int deleteDate(Datemanager datemanager){return  datemanagerMapper.deleteDate(datemanager);}
    public Datemanager findDate(Datemanager datemanager){ return datemanagerMapper.findDate(datemanager);}

}
