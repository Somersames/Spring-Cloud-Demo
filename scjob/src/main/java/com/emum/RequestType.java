package com.emum;

/**
 * @author szh
 * @create 2018-08-06 0:23
 **/
public enum RequestType {
    POST("POST"),
    GET("GET")
    ;
    private String type;



    RequestType(String post) {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
