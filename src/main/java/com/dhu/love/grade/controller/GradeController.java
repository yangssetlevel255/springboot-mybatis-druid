package com.dhu.love.grade.controller;

import com.dhu.love.grade.mapper.GradeMapper;
import com.dhu.love.grade.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "BanPick")

public class GradeController {

    @Autowired
    GradeService gradeService;
    @Autowired
    GradeMapper gradeMapper;

    @RequestMapping(value = "choicePartner",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public void choicePartner(HttpServletRequest request, HttpServletResponse response, @RequestParam("customerId") String customerId){
        //Customer list =gradeService.queryCustomerById(customerId);
        //List<String>address =gradeMapper.queryAllAddress();
        //List<String> pr =gradeMapper.queryAllProfession();
        //CustomerRequire list=gradeMapper.queryCustomerRequireById(customerId);
        gradeService.getMostSuitableCustomer(customerId);
        //System.out.print(list.toString());
    }
}
