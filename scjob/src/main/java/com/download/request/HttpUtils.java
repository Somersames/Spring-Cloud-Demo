package com.download.request;

import com.emum.RequestType;
import com.proxy.BaseProxy;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.swing.StringUIClientPropertyKey;

import java.util.Map;
import java.util.Set;

/**
 * HTTP的工具类
 *
 * @author szh
 * @create 2018-08-05 23:11
 **/
@Slf4j
@Service
public class HttpUtils {
    @Value("${start.default.address}")
    String address;
    //类加载时就初始化
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static CloseableHttpClient getInstance(){
        if(httpClient == null){
            log.error("httpClient未初始化完毕");
        }
        return httpClient;
    }
    public  HttpPost startGrab(Map<String, String> params ,String url,String requestType){
        CloseableHttpClient httpClient = BaseProxy.getHttpPostWithProxy("115.46.98.208", 8123, "http");
        //TODO:之后新建一个StringUtils，然后替换该判断
        if(requestType == null || requestType.length() ==0){
            requestType ="GET";
        }
        Object obj=null;
        HttpPost httpPost =null;
            //TODO:之后新建一个StringUtils，然后判断是否为空
            obj =new HttpPost(url);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if(entry.getKey() != null && entry.getValue() != null){
                httpPost =(HttpPost)obj;
                httpPost.addHeader(entry.getKey(),entry.getValue());
            }
        }
        return httpPost;
    }
    public void sa(){
        System.out.println(address);
    }
}
