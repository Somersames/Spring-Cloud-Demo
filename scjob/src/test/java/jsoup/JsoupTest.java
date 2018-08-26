package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author szh
 * @create 2018-08-26 21:23
 **/
public class JsoupTest {
    @Test
    public void jsonParse() throws IOException {
        Jedis jedis = new Jedis("47.104.139.106",6379);
        jedis.auth("somersames");
        System.out.println("Connection to server sucessfully");
        System.out.println("Server is running: "+jedis.ping());
        FileInputStream fileInputStream  =new FileInputStream(new File("D:\\disk\\regular.txt"));
        Reader reader =new InputStreamReader(fileInputStream,"UTF-8");
        int len;
        char[] a =new char[1024];
        StringBuffer sb =new StringBuffer();
        while ((len=reader.read(a))!= -1)  //以字节流去读pdf文件
        {
            String s1=   new String(a,0,len) ;
            sb.append(s1);
        }
        reader.close();
        Document document = Jsoup.parse(sb.toString());
//        System.out.println(document.toString());
//        Map<String,Map<String,String>> map =new HashMap<>();
//        Map<String,List<String>> map1 =new HashMap<>();
//        Map<String,String> ipMap =new HashMap<>();
        Elements liElements = document.getElementsByClass("l2");
        for (int i = 0; i < liElements.size(); i++) {
            Elements temp =liElements.get(i).getElementsByTag("span");
            String content = temp.text();
            String[] ipContent = content.split(" ");
//            List tempLi =Arrays.asList(ipContent);
//            map1.put("1",tempLi);
//            jedis.hmset("1",ipMap);
            jedis.set("1"+String.valueOf(i ),content);
            for(String str : ipContent){

                System.out.println(str);
            }
            jedis.close();
        }
    }
}
