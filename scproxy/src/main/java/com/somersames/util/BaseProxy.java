package com.somersames.util;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @author szh
 * @create 2018-08-26 23:01
 **/
public class BaseProxy {
    public static CloseableHttpClient getHttpPostWithProxy(String ip , int port, String type){
        HttpHost proxy = new HttpHost(ip, port,type);
        //把代理设置到请求配置
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setProxy(proxy)
                // 超时时间
                .setConnectTimeout(10000)
                .build();
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        return httpclient;
    }
}
