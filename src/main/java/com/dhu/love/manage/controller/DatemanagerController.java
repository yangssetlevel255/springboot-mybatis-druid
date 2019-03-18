package com.dhu.love.manage.controller;

import com.dhu.love.manage.entity.Datemanager;
import com.dhu.love.manage.service.CustomerInfoService;
import com.dhu.love.manage.service.DatemanagerService;
import com.dhu.love.manage.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RequestMapping(value = "api")
public class DatemanagerController {
    @Autowired
    DatemanagerService datemanagerService;
    CustomerInfoService customerInfoService;
    @RequestMapping(value = "addDate" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody

    public String addDate(@RequestParam Map<String,String> map, HttpServletRequest request, HttpServletResponse response)
    {
        Datemanager datemanager = new Datemanager();
        datemanager.setMmname(map.get("mmname"));
        datemanager.setMmmobile(Integer.valueOf(map.get("mmmobile")));
        datemanager.setMmid(customerInfoService.findCustomerOne(map.get("mmname"),map.get("mmmobile")).getCustomer_id());
        datemanager.setMfname(map.get("mfname"));
        datemanager.setMfmobile(Integer.valueOf(map.get("mfmobile")));
        datemanager.setMfid(customerInfoService.findCustomerOne(map.get("mfname"),map.get("mfmobile")).getCustomer_id());
        datemanager.setStarttime(DateUtil.strToDate(map.get("starttime")));
        datemanager.setEndtime(DateUtil.strToDate(map.get("endtime")));
        datemanager.setDatestatus(Integer.valueOf(map.get("datestatus")));
        //新增
        datemanagerService.addDate(datemanager);

        //新增成功后 同步修改状态
        datemanagerService.updateCustomer(map.get("datestatus"),datemanager.getMmid(),datemanager.getMfid());
        return "新增成功!";

    }
    @RequestMapping(value = "updateDate" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String updateDate(@RequestParam Map<String,String> map, HttpServletRequest request, HttpServletResponse response)
    {
        Datemanager datemanager = new Datemanager();
        datemanager.setStarttime(DateUtil.strToDate(map.get("starttime")));
        datemanager.setEndtime(DateUtil.strToDate(map.get("endtime")));
        datemanager.setDatestatus(Integer.valueOf(map.get("datestatus")));
        //更新后 同步更新客户状态
        datemanagerService.updateCustomer(map.get("datestatus"),Integer.valueOf(map.get("mmid")),Integer.valueOf(map.get("mfid")));
        return "更新成功!";

    }
    @RequestMapping(value = "deleteDate" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String deleteDate(@RequestParam int mid, HttpServletRequest request, HttpServletResponse response)
    {
        datemanagerService.deleteDate(mid);
        return "删除成功!";
    }

    @RequestMapping(value = "findDateByname" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody

    public Map findDateByname(@RequestParam String mmname,HttpServletRequest request, HttpServletResponse response)
    {
        return  datemanagerService.findDateByname(mmname);
    }

    @RequestMapping(value = "findDateByname" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Datemanager findDateOne(@RequestParam String mmname,String mfname,String  mmmobile,String mfmobile,HttpServletRequest request, HttpServletResponse response)
    {
        return datemanagerService.findDateOne(mmname,mfname,mmmobile,mfmobile);
    }
    @RequestMapping(value = "findDateAll" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map findDateAll()
    {
        return  datemanagerService.findDateAll();
    }


}
