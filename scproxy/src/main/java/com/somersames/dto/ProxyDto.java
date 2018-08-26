package com.somersames.dto;

import java.io.Serializable;

/**
 * @author szh
 * @create 2018-08-26 21:34
 **/
public class ProxyDto implements Serializable{
    private String ip ;

    private String port;

    private String type;

    private String httpType;

    private String country;

    private String province;

    private String operator;

    private String aliveTime;

    private String lastValidTime;


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHttpType() {
        return httpType;
    }

    public void setHttpType(String httpType) {
        this.httpType = httpType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getAliveTime() {
        return aliveTime;
    }

    public void setAliveTime(String aliveTime) {
        this.aliveTime = aliveTime;
    }

    public String getLastValidTime() {
        return lastValidTime;
    }

    public void setLastValidTime(String lastValidTime) {
        this.lastValidTime = lastValidTime;
    }
}
