package com.somersames.httputils;

import com.somersames.dto.ProxyDto;
import org.apache.http.client.HttpClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Http的一些集合类
 *
 * @author szh
 * @create 2018-09-01 15:58
 **/
@Service
public class HttpUtils {

    @Resource
    RedisTemplate<String,ProxyDto> redisTemplate;

    /**
     * 有效IP，当无可用IP的时候为null，或者locaalhost
     */
    //TODO 这里需要容器一加载就赋值
    public volatile static ProxyDto validProxyDto=null;

    public synchronized void removeInvalidIp(ProxyDto proxyDto){
        if(proxyDto.getIp().equals(validProxyDto.getIp())){
            //remove valid IP
            redisTemplate.opsForList().leftPop("validProxy");
            validProxyDto = redisTemplate.opsForList().index("validProxy",0);
        }else{
            return;
        }
    }

}
