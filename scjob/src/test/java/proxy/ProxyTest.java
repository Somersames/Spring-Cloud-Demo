package proxy;

import com.proxy.BaseProxy;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author szh
 * @create 2018-08-24 23:18
 **/
public class ProxyTest {
    @Test
    public void grab() throws IOException {
        CloseableHttpClient httpClient = BaseProxy.getHttpPostWithProxy("171.39.45.38", 8123, "http");
        HttpGet httpGet = new HttpGet("http://tool.chinaz.com");
        httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        httpGet.setHeader("Accept-Encoding", "gzip, deflate");
        httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        httpGet.setHeader("Cache-Control", "max-age=0");
        httpGet.setHeader("Connection", "keep-alive");
        httpGet.setHeader("Cookie", "mainurl=%20");
        httpGet.setHeader("Host", "tool.chinaz.com");
        httpGet.setHeader("Upgrade-Insecure-Requests", "1");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity httpEntity = response.getEntity();
        if (httpClient != null) {
            InputStream inputStream = httpEntity.getContent();
            byte[] bytes = new byte[1024];
            int len;
            StringBuffer sb = new StringBuffer();
            while ((len = inputStream.read(bytes)) != -1) {
                String s = new String(bytes, 0, len);
                sb.append(s);
            }
            String result = sb.toString();
            System.out.println(result);
        }
    }
}
