package com.somersames.proxy.valid.impl;

import com.somersames.dto.ProxyDto;
import com.somersames.ipenum.HeaderEnum;
import com.somersames.proxy.util.SendRequest;
import com.somersames.proxy.valid.ValidIp;
import com.somersames.util.BaseProxy;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 通过各种方式来验证Ip是否可用
 *
 * @author szh
 * @create 2018-09-01 15:49
 **/
@Service
public class ValidIpImpl  implements ValidIp{

    @Resource
    RedisTemplate<String,ProxyDto> redisTemplate;

    /**
     * 启动10个线程，分别去取出Ip
     * @param
     * @return
     */
    @Override
    public void valid() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        for(int i=0 ;i<1000;i++){
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    validIp();
                }
            });
        }
//        validIp();
    }


    private boolean validIp(){
        ProxyDto proxyDto =getIpFromRedis();
        CloseableHttpClient httpClient = BaseProxy.getHttpPostWithProxy(proxyDto.getIp(),Integer.parseInt(proxyDto.getPort()),proxyDto.getHttpType());
        System.out.println(proxyDto.getIp() + "验证中");
//        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        httpGet.setHeader("Accept", HeaderEnum.Accept.getType());
        httpGet.setHeader("Accept-Encoding","gzip, deflate, br");
        httpGet.setHeader("Accept-Language", HeaderEnum.AcceptLanguage.getType());
        httpGet.setHeader("Cache-Control", HeaderEnum.CACHECONTROLL.getType());
        httpGet.setHeader("Connection", HeaderEnum.Connection.getType());
        httpGet.setHeader("Host","www.baidu.com");
        httpGet.setHeader("Upgrade-Insecure-Requests", HeaderEnum.UPGRADEINSECUREREQUESTS.getType());
        httpGet.setHeader("User-Agent", HeaderEnum.UserAgent.getType());
        try{
            CloseableHttpResponse response=httpClient.execute(httpGet);
            String content = SendRequest.SendRequestAndResponse(httpGet, httpClient);
            System.out.println("验证IP----------------:"+content);
            if(content.contains("百度") || "HTTP/1.1 200 OK".equals(response.getStatusLine())){
                redisTemplate.opsForList().leftPush("validProxy",proxyDto);
            }
        }catch (IOException e){
            System.out.println(proxyDto.getIp() + "失效");
            System.out.println(e.getMessage());
            return false;
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(proxyDto.getIp() + "失效");
            return false;
        }
        return true;
    }

    /**
     * 取出Ip的时候必须保证一个线程只能取出一个
     * @return
     */
    private synchronized ProxyDto getIpFromRedis(){
        return redisTemplate.opsForList().leftPop("proxy");
    }


}
