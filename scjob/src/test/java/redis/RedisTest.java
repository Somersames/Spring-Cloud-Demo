package redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author szh
 * @create 2018-08-25 18:32
 **/
public class RedisTest {
    @Test
    public  void  redisConn(){
        Jedis jedis = new Jedis("localhost",6379);
        jedis.auth("somersames");
        System.out.println("Connection to server sucessfully");
        System.out.println("Server is running: "+jedis.ping());
    }
}
