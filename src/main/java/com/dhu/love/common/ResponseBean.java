package com.dhu.love.common;

public class ResponseBean<T>  {


    //是否成功
    boolean success;
    //返回的数据
    T data;

    String errorMessage;


    public ResponseBean(T data){
        this.data=data;
    }
    public ResponseBean(boolean success){
        this.success=success;
    }

    public ResponseBean(boolean success,T data){
        this.data=data;
        this.success=success;
    }

    public ResponseBean(boolean success,T data,String errorMessage){
        this.data=data;
        this.success=success;
        this.errorMessage=errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
