package com.somersames.proxy.impl;

import com.somersames.dto.ProxyDto;
import com.somersames.ipenum.Header;
import com.somersames.proxy.BaseRequest;
import com.somersames.proxy.util.SendRequest;
import com.somersames.util.BaseProxy;
import com.somersames.util.ParseUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author szh
 * @create 2018-08-26 22:41
 **/
@Service
public class WuYouDaili implements BaseRequest {

    @Resource
    private RedisTemplate<String, ProxyDto> redisTemplate;

    @Override
    public void grad() {
        ProxyDto proxy =redisTemplate.opsForList().leftPop("proxy");
        CloseableHttpClient httpClient =null;
        if(proxy == null || proxy.getIp() == null){
            httpClient = HttpClients.createDefault();
        }else{
            httpClient = BaseProxy.getHttpPostWithProxy("118.190.95.43",9001,"http");
        }
        HttpGet httpGet =new HttpGet("http://www.data5u.com/free/gngn/index.shtml");
        httpGet.addHeader("Accept", Header.Accept.getType());
        httpGet.addHeader("Accept-Encoding", Header.AcceptEncoding.getType());
        httpGet.addHeader("Accept-Language", Header.AcceptLanguage.getType());
        httpGet.addHeader("Cache-Control", Header.CACHECONTROLL.getType());
        httpGet.addHeader("Connection", Header.Connection.getType());
        httpGet.addHeader("Host", Header.Host.getType());
        httpGet.addHeader("Upgrade-Insecure-Requests", Header.UPGRADEINSECUREREQUESTS.getType());
        httpGet.addHeader("User-Agent", Header.UserAgent.getType());
        String conten = SendRequest.SendRequestAndResponse(httpGet,httpClient);
        List<ProxyDto> list =ParseUtil.parseContent(conten);
        for (ProxyDto proxyDto: list){
            redisTemplate.opsForList().leftPush("proxy",proxyDto);
        }

    }

    @Override
    public String say() {
        return redisTemplate.opsForList().leftPop("proxy").getIp();
    }
}