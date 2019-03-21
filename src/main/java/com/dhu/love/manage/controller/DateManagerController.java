package com.dhu.love.manage.controller;

import com.dhu.love.common.ResponseBean;
import com.dhu.love.manage.entity.DateManager;
import com.dhu.love.manage.service.CustomerInfoService;
import com.dhu.love.manage.service.DateManagerService;
import com.dhu.love.manage.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "api")
public class DateManagerController {
    @Autowired
    DateManagerService dateManagerService;
    CustomerInfoService customerInfoService;
    @RequestMapping(value = "addDate" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody

    public String addDate(@RequestParam Map<String,String> map, HttpServletRequest request, HttpServletResponse response)
    {
        DateManager dateManager = new DateManager();
        dateManager.setMmName(map.get("mmName"));
        dateManager.setMmMobile(Integer.valueOf(map.get("mmMobile")));
        dateManager.setmMid(customerInfoService.findCustomerOne(map.get("mmName"),map.get("mmMobile")).getCustomerId());
        dateManager.setMfName(map.get("mfName"));
        dateManager.setMfMobile(Integer.valueOf(map.get("mfMobile")));
        dateManager.setMfId(customerInfoService.findCustomerOne(map.get("mfName"),map.get("mfMobile")).getCustomerId());
        dateManager.setStartTime(DateUtil.strToDate(map.get("startTime")));
        dateManager.setEndTime(DateUtil.strToDate(map.get("endTime")));
        dateManager.setDateStatus(Integer.valueOf(map.get("dateStatus")));
        //新增
        dateManagerService.addDate(dateManager);

        //新增成功后 同步修改状态
        dateManagerService.updateCustomer(map.get("dateStatus"),dateManager.getmId(),dateManager.getMfId());
        return "新增成功!";

    }
    @RequestMapping(value = "updateDate" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String updateDate(@RequestParam Map<String,String> map, HttpServletRequest request, HttpServletResponse response)
    {
        DateManager dateManager = new DateManager();
        dateManager.setStartTime(DateUtil.strToDate(map.get("startTime")));
        dateManager.setEndTime(DateUtil.strToDate(map.get("endTime")));
        dateManager.setDateStatus(Integer.valueOf(map.get("dateStatus")));
        //更新后 同步更新客户状态
        dateManagerService.updateDate(dateManager);
        dateManagerService.updateCustomer(map.get("dateStatus"),Integer.valueOf(map.get("mmId")),Integer.valueOf(map.get("mfId")));
        return "更新成功!";

    }
    @RequestMapping(value = "deleteDate" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String deleteDate(@RequestParam int id, HttpServletRequest request, HttpServletResponse response)
    {
        dateManagerService.deleteDate(id);
        return "删除成功!";
    }

    @RequestMapping(value = "findDateByName" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody

    public ResponseBean findDateByName(@RequestParam String name, HttpServletRequest request, HttpServletResponse response)
    {
        List<DateManager>  dateManagerList= dateManagerService.findDateByName(name);
        ResponseBean responseBean = new ResponseBean(true,dateManagerList);
        return  responseBean;
    }

    @RequestMapping(value = "findDateOne" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ResponseBean findDateOne(@RequestParam String mmName,String mfName,String  mmMobile,String mfMobile,HttpServletRequest request, HttpServletResponse response)
    {
        DateManager dateManager = dateManagerService.findDateOne(mmName,mfName,mmMobile,mfMobile);
        ResponseBean responseBean = new ResponseBean(true,dateManager);
        return  responseBean;
    }
    @RequestMapping(value = "findDateAll" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ResponseBean findDateAll()
    {
        List<DateManager> dateManagerList = dateManagerService.findDateAll();
        ResponseBean responseBean = new ResponseBean(true,dateManagerList);
        return  responseBean;
    }


}
