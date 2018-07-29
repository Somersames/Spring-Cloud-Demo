package com.somersames.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json工具类
 *
 * @author szh
 * @create 2018-06-12 21:05
 **/
public class JsonToString {
    public static  String JsonToString(Object o){
        ObjectMapper objectMapper =new ObjectMapper();
        try{
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new String("");
    }
}
