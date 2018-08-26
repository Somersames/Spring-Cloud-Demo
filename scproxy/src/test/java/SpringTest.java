import com.netflix.discovery.converters.Auto;
import com.somersames.UserConfigApplication;
//import com.somersames.redisutil.RedisConfigue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

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
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void hello() throws Exception {
//        this.sender.send();
//        redisConfigue.getRedisTemplate().opsForValue().set("1","test");
//        stringRedisTemplate.opsForList().leftPush("20","2");
        System.out.println(stringRedisTemplate.opsForList().leftPop("20"));
//        stringRedisTemplate.opsForValue().set("1","test");
    }
}