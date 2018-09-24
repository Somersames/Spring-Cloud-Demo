package com.somersames.httputils;

import com.somersames.dto.ProxyDto;
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
    public volatile  ProxyDto validProxyDto=null;

    {
        System.out.println("init------------HttpUtils");
    }
    public void removeInvalidIp(ProxyDto proxyDto){
        if(proxyDto.getIp().equals(validProxyDto.getIp())){
            //remove valid IP
            redisTemplate.opsForList().leftPop("validProxy");
            validProxyDto = redisTemplate.opsForList().index("validProxy",0);
        }else{
            return;
        }
    }
    //初始获取可用Ip
    private  ProxyDto getIpfromRedis(){
        ProxyDto proxy =redisTemplate.opsForList().index("validProxy",0);
        return proxy;
    }

}
