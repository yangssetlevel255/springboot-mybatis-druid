package com.dhu.love.manage.entity;
import java.util.Date;
public class Datemanager {

    public Integer mid; //主键
    public String mmname; //男方姓名
    public int mmid;  //男方userid
    public String mfname; //女方姓名
    public int mfid;   //女方id
    public int mmmobile; //男方手机号


    public int mfmobile;
    public Date starttime;  //女方手机号
    public Date endtime; //相亲开始时间
    public int datestatus; //相亲结束时间

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMmname() {
        return mmname;
    }

    public void setMmname(String mmname) {
        this.mmname = mmname;
    }

    public int getMmid() {
        return mmid;
    }

    public void setMmid(int mmid) {
        this.mmid = mmid;
    }

    public String getMfname() {
        return mfname;
    }

    public void setMfname(String mfname) {
        this.mfname = mfname;
    }

    public int getMfid() {
        return mfid;
    }

    public void setMfid(int mfid) {
        this.mfid = mfid;
    }

    public int getMmmobile() {
        return mmmobile;
    }

    public void setMmmobile(int mmmobile) {
        this.mmmobile = mmmobile;
    }
    public int getMfmobile() {
        return mfmobile;
    }

    public void setMfmobile(int mfmobile) {
        this.mfmobile = mfmobile;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date mstarttime) {
        this.starttime = mstarttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date mendtime) {
        this.endtime = mendtime;
    }

    public int getDatestatus() {
        return datestatus;
    }

    public void setDatestatus(int datestatus) {
        this.datestatus = datestatus;
    }
}


