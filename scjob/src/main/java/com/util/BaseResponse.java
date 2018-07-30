package com.util;

/**
 * 返回的基础类
 *
 * @author szh
 * @create 2018-07-31 0:30
 **/
public class BaseResponse {
    protected String code ;

    protected String mesage;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }

    public BaseResponse() {
        this.code = "200";
        this.mesage = "SUCCESS";
    }
}
