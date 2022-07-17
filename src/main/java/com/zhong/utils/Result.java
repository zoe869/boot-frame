package com.zhong.utils;

import java.util.List;

public class Result<T> {

    private int code;   //状态码
    private String msg; //提示信息
    private Object data; //数据
    private int count;  //分页获取数据时，存储符合程序条件的数据总量


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getTotal() {
        return count;
    }

    public void setTotal(int total) {
        this.count = total;
    }

}