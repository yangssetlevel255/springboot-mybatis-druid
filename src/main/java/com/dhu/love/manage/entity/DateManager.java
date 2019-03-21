package com.dhu.love.manage.entity;
import java.util.Date;
public class DateManager {

    public Integer mId; //主键
    public String mmName; //男方姓名
    public int mMid;  //男方userid
    public String mfName; //女方姓名
    public int mfId;   //女方id
    public int mmMobile; //男方手机号
    public int mfMobile;
    public Date startTime;  //女方手机号
    public Date endTime; //相亲开始时间
    public int dateStatus; //相亲结束时间

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getMmName() {
        return mmName;
    }

    public void setMmName(String mmName) {
        this.mmName = mmName;
    }

    public int getmMid() {
        return mMid;
    }

    public void setmMid(int mMid) {
        this.mMid = mMid;
    }

    public String getMfName() {
        return mfName;
    }

    public void setMfName(String mfName) {
        this.mfName = mfName;
    }

    public int getMfId() {
        return mfId;
    }

    public void setMfId(int mfId) {
        this.mfId = mfId;
    }

    public int getMmMobile() {
        return mmMobile;
    }

    public void setMmMobile(int mmMobile) {
        this.mmMobile = mmMobile;
    }

    public int getMfMobile() {
        return mfMobile;
    }

    public void setMfMobile(int mfMobile) {
        this.mfMobile = mfMobile;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getDateStatus() {
        return dateStatus;
    }

    public void setDateStatus(int dateStatus) {
        this.dateStatus = dateStatus;
    }


}


