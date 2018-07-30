package com.emum;

/**
 * 返回Json的枚举类
 */
public enum ResponseCode {


    SUCCESS("200","SUCCESS");

    private String code ;
    private String messgae;


    private ResponseCode(String code ,String messgae){
        this.code =code;
        this.messgae=messgae;
    }

}
