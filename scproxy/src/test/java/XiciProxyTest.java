import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.*;

/**
 * @author szh
 * @create 2018-08-26 21:23
 **/
public class XiciProxyTest {
    @Test
    public void jsonParse() throws IOException {
//        Jedis jedis = new Jedis("47.104.139.106",6379);
//        jedis.auth("somersames");
//        System.out.println("Connection to server sucessfully");
//        System.out.println("Server is running: "+jedis.ping());
        FileInputStream fileInputStream = new FileInputStream(new File("D:\\disk\\kuaidaili.txt"));
        Reader reader = new InputStreamReader(fileInputStream, "UTF-8");
        int len;
        char[] a = new char[1024];
        StringBuffer sb = new StringBuffer();
        while ((len = reader.read(a)) != -1)  //以字节流去读pdf文件
        {
            String s1 = new String(a, 0, len);
            sb.append(s1);
        }
        reader.close();
        Document document = Jsoup.parse(sb.toString());
        Elements liElements = document.getElementsByClass("table table-bordered table-striped").select("tbody").select("tr");
//        Element liElements = document.getElementById("ip_list");
//        Elements listEl =liElements.getAllElements();
//        System.out.println(listEl.text());
        for (int i = 0; i < liElements.size(); i++) {
            Elements temp = liElements.get(i).getElementsByTag("td");
            String content = temp.text();
            String[] ipContent = content.split(" ");
            for (String str : ipContent) {
                System.out.println(str);
            }
//        }
        }
    }
}
