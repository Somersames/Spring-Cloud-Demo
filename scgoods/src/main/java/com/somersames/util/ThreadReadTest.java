package com.somersames.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.somersames.pojo.MongoPojo;
import com.somersames.pojo.lagou.dto.LagouDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

/**
 * @author szh
 * @create 2018-08-19 15:45
 **/
@Service
public class ThreadReadTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static  ThreadFactory threadFactory =new ThreadFactoryBuilder().setNameFormat("read-Messager-Pool").build();
    private static  ExecutorService executorService =new ThreadPoolExecutor(5,200,0L, TimeUnit.MICROSECONDS,new LinkedBlockingDeque<Runnable>(1024),threadFactory,new ThreadPoolExecutor.AbortPolicy());
    public  void readMessage(final String s ){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(s);
                LagouDto lagouDto = JSON.parseObject(s, new TypeReference<LagouDto>() {});
//                MongoPojo mongoPojo = JSON.parseObject(s, new TypeReference<MongoPojo>() {
//                });
                mongoTemplate.insert(lagouDto);
            }
        });
    }
}
