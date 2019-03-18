package com.dhu.love.manage.entity;
import java.util.Date;
public class UserInfo {

    private Integer userid;   //id
    private String username;  //用户姓名
    private String usersex;   //性别
    private Date birthdate;  //出生日期
    private String birthlocation; //出生地
    private int status;    //目前状态
    private String mobile;  // 联系方式
    private String company; //公司名称
    private String address;  //居住地
    private Date gmt_create; // 录入时间
    private String create_id;  //  创建人
    private String gmt_modified; // 更新时间
    private String modified_id;  //修改人
    private int salary;    //年薪
    private int housenumber;  //房产数量
    private String hobby; //个人爱好
    private String charactor;  //个性描述
    private String education;  // 最高学历
    private String car;   //有车
    private String jobtitle;  //职位
    private String divorce; //是否离异



    private String uuid; //唯一uuid

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthlocation() {
        return birthlocation;
    }

    public void setBirthlocation(String birthlocation) {
        this.birthlocation = birthlocation;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public String getCreate_id() {
        return create_id;
    }

    public void setCreate_id(String create_id) {
        this.create_id = create_id;
    }

    public String getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(String gmt_modified) {
        this.gmt_modified = gmt_modified;
    }
    public String getModified_id() {
        return modified_id;
    }

    public void setModified_id(String modified_id) {
        this.modified_id = modified_id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(int housenumber) {
        this.housenumber = housenumber;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getCharactor() {
        return charactor;
    }

    public void setCharactor(String charactor) {
        this.charactor = charactor;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getDivorce() {
        return divorce;
    }

    public void setDivorce(String divorce) {
        this.divorce = divorce;
    }
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}

