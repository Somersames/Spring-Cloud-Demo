package com.download.request;

import com.emum.RequestType;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
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
public class HttpUtils {
    //类加载时就初始化
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static CloseableHttpClient getInstance(){
        if(httpClient == null){
            log.error("httpClient未初始化完毕");
        }
        return httpClient;
    }
    public static void startGrab(Map<Object,Object> params ,String url,String requestType){
        CloseableHttpClient httpClient = getInstance();
        //TODO:之后新建一个StringUtils，然后替换该判断
        if(requestType == null || requestType.length() ==0){
            requestType ="GET";
        }
        if(RequestType.POST.equals(requestType)){
            //TODO:之后新建一个StringUtils，然后判断是否为空
           HttpPost httpPost =new HttpPost(url);
        }
        for (Map.Entry<Object, Object> entry : params.entrySet()) {
            //TODO:迭代取值
        }
    }
}
