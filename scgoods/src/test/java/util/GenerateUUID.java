package util;

import org.junit.Test;

import java.util.Random;
import java.util.UUID;

/**
 * 随机生成UUID
 *
 * @author szh
 * @create 2018-06-13 16:25
 **/
public class GenerateUUID {
    @Test
    public void generateUUID(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        System.out.println(str);
    }
}
