package com.dhu.love.grade.util;

import com.dhu.love.grade.mapper.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CommonData {

    @Autowired
    GradeMapper gradeMapper;

    private List<String> addressList;
    private List<String> professionList;

    public void init(){
        this.addressList=gradeMapper.queryAllAddress();
        this.professionList=gradeMapper.queryAllProfession();
    }



    public List<String> getAddressList() {
        return addressList;
    }

    public List<String> getProfessionList() {
        return professionList;
    }
}
