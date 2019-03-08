package com.dhu.love.grade.util;

import com.dhu.love.grade.model.Customer;
import com.dhu.love.grade.model.CustomerRequire;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class RequireSQL {

    private String gender;
    private int maxAge;
    private int minAge;
    private String addressRange;
    private int minEducation;
    private String professionRange;
    private int minSalary;
    private int minHouseNumber;
    private String haveCar;
    private int maxChild;
    private CustomerRequire customerRequire;
    private CommonData commonData;
    private Customer customer;
    private Map<String,Object> mostImortantRequireParam;
    private Map<String,Object> allRequireParam;

    private RequireSQL(){};
    public static RequireSQL builder(CustomerRequire customerRequire, CommonData commonData,Customer customer){
        RequireSQL requireSQL=new RequireSQL();
        requireSQL.customerRequire=customerRequire;
        commonData.init();
        requireSQL.commonData=commonData;
        requireSQL.customer=customer;
        return requireSQL;
    }

    public RequireSQL init(){
        setGender();
        setAddressRange();
        setAgeRange();
        setHaveCar();
        setMaxChild();
        setMinEducation();
        setMinHouseNumber();
        setMinSalary();
        setProfessionRange();
        createAllRequireParam();
        return this;

    }

    private void setGender(){
        this.gender=this.customer.getGender();
    }

    private void setAgeRange(){
        int maxAge=this.customerRequire.getMaxAgeReq();
        int minAge=this.customerRequire.getMinAgeReq();
        this.maxAge=Optional.ofNullable(maxAge).orElse(100);
        this.minAge=Optional.ofNullable(minAge).orElse(0);

    }

    private void setAddressRange(){
        List<String> addressList =this.commonData.getAddressList();
        String customerAddress=this.customer.getAddress();
        String customerRequireAddress=this.customerRequire.getLocalReq();
        StringBuffer sb=new StringBuffer("(");
        if("0".equals(customerRequireAddress)){
            addressList.forEach(address->{
                sb.append("'").append(address).append("'").append(",");
            });
            sb.append(")");
            this.addressRange=sb.toString();

        }else{
            String adr="("+customerAddress+")";
            this.addressRange=adr;
        }
    }

    private void setMinEducation(){
        this.minEducation=this.customerRequire.getEducationReq();
    }

    private void setProfessionRange(){
        List<String> professionList=this.commonData.getProfessionList();
        String professionRequire=Optional.ofNullable(this.customerRequire.getProfessionReq()).orElse("");
        StringBuffer sb =new StringBuffer("(");
        if(StringUtils.isEmpty(professionRequire)){
            professionList.forEach(profession->{
                sb.append("'").append(profession).append("'").append(",");
            });
            sb.append(")");
        }else{
            List<String> professionRequireList= Arrays.asList(professionRequire.split(","));
            professionRequireList.forEach(profession->{
                sb.append("'").append(profession).append("'").append(",");
            });
            sb.append(")");
        }
        this.professionRange=sb.toString();
    }

    private void setMinSalary(){
        this.minSalary=this.customerRequire.getSalaryReq();
    }

    private void setMinHouseNumber(){
        this.minHouseNumber=this.customerRequire.getHouseReq();
    }

    private void setHaveCar(){
        String carFlag=this.customerRequire.getCarReq();
        if(carFlag.equals("0")){
            //sql and car!="1"
            this.haveCar="1";
        }else{
            this.haveCar="2";
        }
    }

    private void setMaxChild(){
        this.maxChild=this.customerRequire.getChildReq();
    }


    private void createAllRequireParam(){
        Map<String,Object> map =new HashMap<>();
        map.put("gender",this.gender);
        map.put("maxAge",this.maxAge);
        map.put("minAge",this.minAge);
        map.put("address",this.addressRange);
        map.put("education",this.minEducation);
        map.put("profession",this.professionRange);
        map.put("salary",this.minSalary);
        map.put("houseNumber",this.minHouseNumber);
        map.put("car",this.haveCar);
        map.put("child",this.maxChild);
        this.allRequireParam=map;
    }

    public Map<String, Object> getAllRequireParam() {
        return allRequireParam;
    }
}
