package com.somersames.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回Json的一个封装
 *
 * @author szh
 * @create 2018-05-23 15:03
 **/
public class ResponseResult implements Serializable{
    private Map<Object,Object> map ;
    private int code;

    public ResponseResult() {
        this.map = new HashMap<Object, Object>();
        this.code = 200;
    }
    public void setParamter(Object key, Object value){
        map.put(key,value);
    }
    public void setCode(int code){
        this.code=code;
    }
}
