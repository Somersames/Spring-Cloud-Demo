package com.somersames.proxy.impl;

import com.alibaba.fastjson.JSON;
import com.somersames.dto.ProxyDto;
import com.somersames.httputils.HttpUtils;
import com.somersames.ipenum.HeaderEnum;
import com.somersames.proxy.BaseRequest;
import com.somersames.proxy.util.SendRequest;
import com.somersames.util.BaseProxy;
import com.somersames.util.ParseUtil;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class KuaiDaili implements BaseRequest {

    private static volatile int PAGE = 1;

    @Resource
    RedisTemplate<String,ProxyDto> redisTemplate;

    @Resource
    ParseUtil parseUtil;

    @Resource
    HttpUtils httpUtilsl;

    @Override
    public void grad() throws IOException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        //TODO 需要换成实际的页数
        for(int i=0 ;i<100;i++){
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
        log.info(httpUtilsl == null ? "httpUtilsl----------is Null":"adadad");
//        ProxyDto proxy =httpUtilsl.validProxyDto;
        ProxyDto proxy =getIpfromRedis();
        log.info("目前获取的Ip是{}，尝试使用此Ip爬取快代理", JSON.toJSONString(proxy));
        CloseableHttpClient httpClient= null;
        if(proxy == null || proxy.getIp() == null){
            httpClient = HttpClients.createDefault();
            log.info("无可用IP，尝试使用本机Ip爬取代理");
        }else{
            httpClient = BaseProxy.getHttpPostWithProxy(proxy.getIp(),Integer.parseInt(proxy.getPort()),proxy.getHttpType());
            log.info("通过代理访问，ip={}，端口={}",proxy.getIp(),proxy.getPort());
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
        if(list == null || list.size() == 0){
            httpUtilsl.removeInvalidIp(proxy);
            return;
        }
        for(ProxyDto proxyDto :list){
            redisTemplate.opsForList().leftPush("proxy",proxyDto);
        }
    }

    private synchronized  int getPage(){
        if(PAGE >=1000){
            return -1000;
        }else{
            PAGE++;
            return PAGE;
        }
    }
    //初始获取可用Ip
    private  ProxyDto getIpfromRedis(){
        ProxyDto proxy =redisTemplate.opsForList().index("validProxy",0);
        return proxy;
    }
}
