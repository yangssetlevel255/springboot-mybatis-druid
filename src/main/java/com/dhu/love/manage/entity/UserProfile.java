package com.dhu.love.manage.entity;

public class UserProfile {

    private Integer rid;  // 主键
    private Integer userid; // 外键
    private String tdivorce;  // 接受离异
    private String tdivorce_p;  // 离异优先级
    private String tchild;  //接受有子
    private String tchild_p;  //有子优先级
    private String tlocal;  // 接受外地
    private String tlocal_p; // 外地优先级
    private String thouse; // 房产数量
    private String thouse_p; // 房产数量优先级
    private String tcar; // 是否要有车
    private String tcar_p; //车辆优先级
    private String tsalary; //年薪要 求
    private String tsalary_p; //年薪优先级
    private String teducation; //学历要求
    private String teducation_p; //学历优先级
    private int tbirthmin;  // 最多小几岁
    private int tbirthmax;  // 最多大几岁
    private String tbirth_p;  //年龄优先级
    private String requirement; //特别需求
    private String requirement_p; //特别需求优先级
    private String uuid; //全局uuid

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }



    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTdivorce() {
        return tdivorce;
    }

    public void setTdivorce(String tdivorce) {
        this.tdivorce = tdivorce;
    }

    public String getTdivorce_p() {
        return tdivorce_p;
    }

    public void setTdivorce_p(String tdivorce_p) {
        this.tdivorce_p = tdivorce_p;
    }

    public String getTchild() {
        return tchild;
    }

    public void setTchild(String tchild) {
        this.tchild = tchild;
    }

    public String getTchild_p() {
        return tchild_p;
    }

    public void setTchild_p(String tchild_p) {
        this.tchild_p = tchild_p;
    }

    public String getTlocal() {
        return tlocal;
    }

    public void setTlocal(String tlocal) {
        this.tlocal = tlocal;
    }

    public String getTlocal_p() {
        return tlocal_p;
    }

    public void setTlocal_p(String tlocal_p) {
        this.tlocal_p = tlocal_p;
    }

    public String getThouse() {
        return thouse;
    }

    public void setThouse(String thouse) {
        this.thouse = thouse;
    }

    public String getThouse_p() {
        return thouse_p;
    }

    public void setThouse_p(String thouse_p) {
        this.thouse_p = thouse_p;
    }

    public String getTcar() {
        return tcar;
    }

    public void setTcar(String tcar) {
        this.tcar = tcar;
    }

    public String getTcar_p() {
        return tcar_p;
    }

    public void setTcar_p(String tcar_p) {
        this.tcar_p = tcar_p;
    }

    public String getTsalary() {
        return tsalary;
    }

    public void setTsalary(String tsalary) {
        this.tsalary = tsalary;
    }

    public String getTsalary_p() {
        return tsalary_p;
    }

    public void setTsalary_p(String tsalary_p) {
        this.tsalary_p = tsalary_p;
    }

    public String getTeducation() {
        return teducation;
    }

    public void setTeducation(String teducation) {
        this.teducation = teducation;
    }

    public String getTeducation_p() {
        return teducation_p;
    }

    public void setTeducation_p(String teducation_p) {
        this.teducation_p = teducation_p;
    }

    public int getTbirthmin() {
        return tbirthmin;
    }

    public void setTbirthmin(int tbirthmin) {
        this.tbirthmin = tbirthmin;
    }

    public int getTbirthmax() {
        return tbirthmax;
    }

    public void setTbirthmax(int tbirthmax) {
        this.tbirthmax = tbirthmax;
    }

    public String getTbirth_p() {
        return tbirth_p;
    }

    public void setTbirth_p(String tbirth_p) {
        this.tbirth_p = tbirth_p;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getRequirement_p() {
        return requirement_p;
    }

    public void setRequirement_p(String requirement_p) {
        this.requirement_p = requirement_p;
    }



}
