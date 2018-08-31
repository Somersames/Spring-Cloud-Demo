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
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author szh
 * @create 2018-08-31 23:33
 **/
@Service
public class XiCIProxy implements BaseRequest{
    @Resource
    private RedisTemplate<String, ProxyDto> redisTemplate;

    @Override
    public void grad() throws IOException {
        ProxyDto proxy =redisTemplate.opsForList().leftPop("proxy");
        CloseableHttpClient httpClient =null;
        if(proxy == null || proxy.getIp() == null){
            httpClient = HttpClients.createDefault();
        }else{
            httpClient = BaseProxy.getHttpPostWithProxy("118.190.95.43",9001,"http");
        }
        HttpGet httpGet =new HttpGet("http://www.xicidaili.com");
        httpGet.addHeader("Accept", Header.Accept.getType());
        httpGet.addHeader("Accept-Encoding", Header.AcceptEncoding.getType());
        httpGet.addHeader("Accept-Language", Header.AcceptLanguage.getType());
        httpGet.addHeader("Connection", Header.Connection.getType());
        httpGet.addHeader("If-None-Match", "W/\"4acb70c806ea7878a35d8b7383e4800a\"");
        httpGet.addHeader("Host", "www.xicidaili.com");
        httpGet.addHeader("Upgrade-Insecure-Requests", Header.UPGRADEINSECUREREQUESTS.getType());
        httpGet.addHeader("User-Agent", Header.UserAgent.getType());
        String content =SendRequest.SendRequestAndResponse(httpGet, httpClient);
        List<ProxyDto> list = ParseUtil.xiciParseContent(content);

    }

    @Override
    public String say() {
        return null;
    }
}
