package com.dhu.love.grade.util;

import com.dhu.love.grade.mapper.GradeMapper;
import com.dhu.love.grade.model.Customer;
import com.dhu.love.grade.model.CustomerRequire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class CustomerBaseImpl implements CustomerBase {


    @Autowired
    GradeMapper gradeMapper;


    private CustomerRequire customerRequire;
    private CommonData commonData;
    private com.dhu.love.grade.model.Customer customer;
    private RequireSQL requireSQL;
    private Map<String,Object> paramMap;
    private List<Customer> allRequireCustomerList;



    public void init(CustomerRequire customerRequire,CommonData commonData,Customer customer) {

        this.customerRequire=customerRequire;
        this.customer=customer;
        this.commonData=commonData;
        this.requireSQL=RequireSQL.builder(customerRequire,commonData,customer).init();
        this.paramMap=requireSQL.getAllRequireParam();
    }

    @Override
    public List<Customer> queryCustomerByAllRequire(RequireSQL require) {
        List<Customer>list=gradeMapper.queryCustomerByRequire(paramMap);
        this.allRequireCustomerList=list;
        return list;
    }

    @Override
    public List<Customer> queryCustomerByMostImportantRequire() {
        List<Customer>list=gradeMapper.queryCustomerByRequire(paramMap);
        this.allRequireCustomerList=list;
        return list;
    }

    @Override
    public List<Customer> queryAllCustomer(String gender) {
        return null;
    }

    @Override
    public List<Customer> doScore(List<Customer> customerList) {
        List<Customer> customerInfoList=new ArrayList<>();
        List<Map<String, Integer>> customerScoreList=new ArrayList<>();
        customerList.forEach(customer ->{
            Map<String,Integer> customerSocreMap=new HashMap<>();
            customerSocreMap.put("customerId",customer.getCustomerId());
            customerSocreMap.put("ageScore",ageScore(customer));
            customerSocreMap.put("addressScore",addressScore(customer));
            customerSocreMap.put("educationScore",educationScore(customer));
            customerSocreMap.put("professionScore",professionScore(customer));
            customerSocreMap.put("salaryScore",salaryScore(customer));
            customerSocreMap.put("houseNumberScore",houseNumberScore(customer));
            customerSocreMap.put("carScore",carScore(customer));
            customerSocreMap.put("childScore",childScore(customer));
            List<Integer> finalScoreList=new ArrayList<>();
            customerSocreMap.forEach((k,v)->{
                finalScoreList.add(v);
            });
            int finalScore=finalScoreList.stream().mapToInt(s->s).sum();
            customerSocreMap.put("finalScore",finalScore);
            customerScoreList.add(customerSocreMap);
        } );
        customerScoreList.sort((cutomer1,cutomer2)->cutomer1.get("finalScore").compareTo(cutomer2.get("finalScore")));
        List<Map<String, Integer>> goodCustomerScore=customerScoreList.stream().limit(5).collect(Collectors.toList());
        goodCustomerScore.forEach(customerMap->{
            Customer customer=gradeMapper.queryCustomerById(customerMap.get("customerId").toString());
            customerInfoList.add(customer);
        });
        return customerInfoList;
    }

    @Override
    public Map<String, Object> reSetDefaultParameter() {
        return null;
    }

    private int ageScore(Customer customer){
        int weight =this.customerRequire.getAgeWeg();
        int maxAge=this.customerRequire.getMaxAgeReq();
        int minAge=this.customerRequire.getMinAgeReq();
        BigDecimal per=new BigDecimal(maxAge-minAge);
        BigDecimal allSocre=new BigDecimal(100);
        int age=customer.getAge();
        if((minAge<=age)&&(age<=maxAge)){
            BigDecimal perScore=allSocre.divide(per);
            BigDecimal allper=new BigDecimal(maxAge-minAge);
            int finalScore=(100-perScore.multiply(allper).intValue())*weight;
            return finalScore;
        }else{
            return 0;
        }
    }

    private int addressScore(Customer customer){
        return 100*this.customerRequire.getLocalWeg();
    }
    private int educationScore(Customer customer){
        int weight=this.customerRequire.getEducationWeg();
        int education =this.customer.getEducation();
        int finalScore=20*education*weight;
        return finalScore;
    }

    private int professionScore(Customer customer){
        String profession =customer.getProfession();
        List<String> professionRequire = Arrays.asList(this.customerRequire.getProfessionReq().split(","));
        int weight=this.customerRequire.getProfessionWeg();
        if(professionRequire.contains(profession)){
            int finalScore=100*weight;
            return finalScore;
        }else{
            int finalScore=0;
            return finalScore;
        }
    }

    private int salaryScore(Customer customer){
        int salary =customer.getSalary();
        int salaryRequire=this.customerRequire.getSalaryReq();
        int weight=this.customerRequire.getSalaryWeg();
        if(salary<salaryRequire){
            return 0;
        }else{
            int fianlScore=0;
            if(salary>salaryRequire*2){
                fianlScore=100*weight;
            }else{
                fianlScore=70*weight;
            }
            return fianlScore;
        }
    }

    private int houseNumberScore(Customer customer){
        int housNumber=customer.getHouseNumber();
        int housNumberRequire=this.customerRequire.getHouseReq();
        int weight=this.customerRequire.getHouseWeg();
        if(housNumber<housNumberRequire){
            return 0;
        }else{
            int finalScore=0;
            if(housNumber>housNumberRequire*2){
                finalScore=100*weight;
            }else{
                finalScore=80*weight;
            }
            return finalScore;
        }
    }

    private int carScore(Customer customer){
        String car=customer.getHaveCar();
        String carRequire=this.customerRequire.getCarReq();
        int weight=this.customerRequire.getCarWeg();
        if(car.equals(carRequire)){
            return 100*weight;
        }else{
            return 0;
        }
    }

    private int childScore(Customer customer){
        int childNumber=customer.getChildNumber();
        int childNumberRequire=this.customerRequire.getChildReq();
        int weight=this.customerRequire.getChildWeg();
        if(childNumber>childNumberRequire){
            return 0;
        }else{
            return 100*weight;
        }
    }

}
