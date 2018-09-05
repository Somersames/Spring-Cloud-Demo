package com.somersames.proxy.impl;

import com.somersames.dto.ProxyDto;
import com.somersames.ipenum.HeaderEnum;
import com.somersames.proxy.BaseRequest;
import com.somersames.proxy.util.SendRequest;
import com.somersames.util.BaseProxy;
import com.somersames.util.ParseUtil;
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
 * 快代理IP爬取
 *
 * @author szh
 * @create 2018-09-01 17:48
 **/
@Service
public class KuaiDaili implements BaseRequest {

    private static volatile int PAGE = 1;
    @Resource
    RedisTemplate<String,ProxyDto> redisTemplate;

    @Resource
    ParseUtil parseUtil;

    @Override
    public void grad() throws IOException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        for(int i=0 ;i<1000;i++){
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    startGrab();
                }
            });
        }
    }

    @Override
    public String say() {
        return null;
    }

    private void startGrab(){
        ProxyDto proxy =getIpfromRedis();
        CloseableHttpClient httpClient= null;
        if(proxy == null || proxy.getIp() == null){
            httpClient = HttpClients.createDefault();
        }else{
            httpClient = BaseProxy.getHttpPostWithProxy(proxy.getIp(),Integer.parseInt(proxy.getPort()),proxy.getHttpType());
        }
        String url ="https://www.kuaidaili.com/free/inha/"+String.valueOf(getPage());
        System.out.println(url);
        HttpGet httpGet =new HttpGet(url);
        httpGet.setHeader("Accept", HeaderEnum.Accept.getType());
        httpGet.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpGet.setHeader("Accept-Language", HeaderEnum.AcceptLanguage.getType());
        httpGet.setHeader("Cache-Control", HeaderEnum.CACHECONTROLL.getType());
        httpGet.setHeader("Connection", HeaderEnum.Connection.getType());
        httpGet.setHeader("Host", "www.kuaidaili.com");
        httpGet.setHeader("Upgrade-Insecure-Requests", HeaderEnum.UPGRADEINSECUREREQUESTS.getType());
        httpGet.setHeader("User-Agent", HeaderEnum.UserAgent.getType());
        String content = SendRequest.SendRequestAndResponse(httpGet, httpClient);
        List<ProxyDto> list = parseUtil.kuaidailiParseContent(content);
        for(ProxyDto proxyDto :list){
            redisTemplate.opsForList().leftPush("proxy",proxyDto);
        }
    }
    private synchronized ProxyDto getIpfromRedis(){
        ProxyDto proxy =redisTemplate.opsForList().index("validProxy",0);
        return proxy;
    }
    private synchronized  int getPage(){
        if(PAGE >=1000){
            return -1000;
        }else{
            PAGE++;
            return PAGE;
        }
    }
}
