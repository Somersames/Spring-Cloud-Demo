import com.netflix.discovery.converters.Auto;
import com.somersames.UserConfigApplication;
//import com.somersames.redisutil.RedisConfigue;
import com.somersames.dto.ProxyDto;
import com.somersames.proxy.impl.KuaiDaili;
import com.somersames.proxy.impl.WuYouDaili;
import com.somersames.proxy.impl.XiCIProxy;
import com.somersames.proxy.valid.impl.ValidIpImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadFactory;

/**
 * @author szh
 * @create 2018-08-26 22:14
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UserConfigApplication.class)
public class SpringTest {
    //    @Autowired356
//    RedisConfigue redisConfigue;
//
//    @Autowired
//    RedisTemplate redisTemplate;
    @Resource
    private RedisTemplate<String, ProxyDto> redisTemplate;

    @Resource
    XiCIProxy xiCIProxy;

    @Resource
    KuaiDaili kuaiDaili;

    @Resource
    WuYouDaili wuYouDaili;
    @Resource
    ValidIpImpl validIp;
    @Test
    public void hello() throws Exception {
//        this.sender.send();
//        redisConfigue.getRedisTemplate().opsForValue().set("1","test");
//        stringRedisTemplate.opsForList().leftPush("20","2");
//        System.out.println(stringRedisTemplate.opsForList().leftPop("20"));
//        stringRedisTemplate.opsForValue().set("1","test");

//        ProxyDto proxyDto1 =new ProxyDto();
//        proxyDto1.setIp("1.1.1.0");
//        redisTemplate.opsForValue().set("proxy",proxyDto1);
//        kuaiDaili.grad();
//        xiCIProxy.grad();
//        wuYouDaili.grad();
        validIp.valid();
        Thread.currentThread().sleep(100000);
//        ProxyDto list =redisTemplate.opsForList().leftPop("proxy");
//        System.out.println(list == null);
    }
}