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
import java.util.List;

/**
 * @author szh
 * @create 2018-08-26 22:41
 **/
@Service
public class WuYouDaili implements BaseRequest {

    @Resource
    private RedisTemplate<String, ProxyDto> redisTemplate;

    @Resource
    ParseUtil parseUtil;
    @Override
    public void grad() {
        ProxyDto proxy =redisTemplate.opsForList().leftPop("proxy");
        CloseableHttpClient httpClient =null;
        if(proxy == null || proxy.getIp() == null){
            httpClient = HttpClients.createDefault();
        }else{
            httpClient = BaseProxy.getHttpPostWithProxy(proxy.getIp(),Integer.parseInt(proxy.getPort()),proxy.getHttpType());
        }
        HttpGet httpGet =new HttpGet("http://www.data5u.com/free/gngn/index.shtml");
        httpGet.addHeader("Accept", HeaderEnum.Accept.getType());
        httpGet.addHeader("Accept-Encoding", HeaderEnum.AcceptEncoding.getType());
        httpGet.addHeader("Accept-Language", HeaderEnum.AcceptLanguage.getType());
        httpGet.addHeader("Cache-Control", HeaderEnum.CACHECONTROLL.getType());
        httpGet.addHeader("Connection", HeaderEnum.Connection.getType());
        httpGet.addHeader("Host", HeaderEnum.Host.getType());
        httpGet.addHeader("Upgrade-Insecure-Requests", HeaderEnum.UPGRADEINSECUREREQUESTS.getType());
        httpGet.addHeader("User-Agent", HeaderEnum.UserAgent.getType());
        String conten = SendRequest.SendRequestAndResponse(httpGet,httpClient);
        List<ProxyDto> list =parseUtil.parseContent(conten);
        for (ProxyDto proxyDto: list){
            redisTemplate.opsForList().leftPush("proxy",proxyDto);
        }

    }

    @Override
    public String say() {
        return redisTemplate.opsForList().leftPop("proxy").getIp();
    }
}
