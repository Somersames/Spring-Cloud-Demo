package com.somersames.proxy.impl;

import com.somersames.dto.ProxyDto;
import com.somersames.ipenum.HeaderEnum;
import com.somersames.proxy.BaseRequest;
import com.somersames.proxy.util.SendRequest;
import com.somersames.util.BaseProxy;
import com.somersames.util.ParseUtil;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author szh
 * @create 2018-08-31 23:33
 **/
@Service
public class XiCIProxy implements BaseRequest{
    private static volatile  int PAGE =0;
    @Resource
    ParseUtil parseUtil;

    @Resource
    private RedisTemplate<String, ProxyDto> redisTemplate;

    @Override
    public void grad() throws IOException {
        ProxyDto proxy =getIpfromRedis();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        for(int i=0 ;i<1000;i++){
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    grabIp();
                }
            });
        }
//        grabIp();
    }
    private synchronized  int getPage(){
       if(PAGE >=1000){
           return -1000;
       }else{
           PAGE++;
           return PAGE;
       }
    }
    private synchronized ProxyDto getIpfromRedis(){
        ProxyDto proxy =redisTemplate.opsForList().index("validProxy",1);
        return proxy;
    }
    private void grabIp(){
        System.out.println("爬取Ip中");
        ProxyDto proxy =getIpfromRedis();
        CloseableHttpClient httpClient =null;
        if(proxy == null || proxy.getIp() == null){
            //TODO 需要在配置文件中添加开关
            httpClient = HttpClients.createDefault();
        }else{
            httpClient   = BaseProxy.getHttpPostWithProxy(proxy.getIp(),Integer.parseInt(proxy.getPort()),proxy.getHttpType());
        }
        String url= "http://www.xicidaili.com/nn/"+String.valueOf(getPage());
        System.out.println(url);
        HttpGet httpGet =new HttpGet(url);
        httpGet.addHeader("Accept", HeaderEnum.Accept.getType());
        httpGet.addHeader("Accept-Encoding", HeaderEnum.AcceptEncoding.getType());
        httpGet.addHeader("Accept-Language", HeaderEnum.AcceptLanguage.getType());
        httpGet.addHeader("Connection", HeaderEnum.Connection.getType());
        httpGet.addHeader("If-None-Match", "W/\"4acb70c806ea7878a35d8b7383e4800a\"");
        httpGet.addHeader("Host", "www.xicidaili.com");
        httpGet.addHeader("Upgrade-Insecure-Requests", HeaderEnum.UPGRADEINSECUREREQUESTS.getType());
        httpGet.addHeader("User-Agent", HeaderEnum.UserAgent.getType());
        String content =SendRequest.SendRequestAndResponse(httpGet, httpClient);
        List<ProxyDto> list = parseUtil.xiciParseContent(content);
        for(ProxyDto proxyDto :list){
            redisTemplate.opsForList().leftPush("proxy",proxyDto);
        }
    }
    @Override
    public String say() {
        return null;
    }
}
