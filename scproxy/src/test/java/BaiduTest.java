import com.somersames.dto.ProxyDto;
import com.somersames.ipenum.HeaderEnum;
import com.somersames.proxy.util.SendRequest;
import com.somersames.util.BaseProxy;
import com.somersames.util.ParseUtil;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Queue;

/**
 * @author szh
 * @create 2018-09-01 16:57
 **/
public class BaiduTest {
    @Test
    public void baidu() {
        CloseableHttpClient httpClient = BaseProxy.getHttpPostWithProxy("47.52.208.159", 80, "http");
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        httpGet.setHeader("Accept", HeaderEnum.Accept.getType());
        httpGet.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpGet.setHeader("Accept-Language", HeaderEnum.AcceptLanguage.getType());
        httpGet.setHeader("Cache-Control", HeaderEnum.CACHECONTROLL.getType());
        httpGet.setHeader("Connection", HeaderEnum.Connection.getType());
        httpGet.setHeader("Host", "www.baidu.com");
        httpGet.setHeader("Upgrade-Insecure-Requests", HeaderEnum.UPGRADEINSECUREREQUESTS.getType());
        httpGet.setHeader("User-Agent", HeaderEnum.UserAgent.getType());
        try {
//            httpClient.execute(httpGet);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            System.out.println(response.getStatusLine().toString());
            Header[] responseHeaderEnum2 = response.getAllHeaders();
            Header[] responseHeaderEnum = response.getHeaders("Status Code");
            for (Header header : responseHeaderEnum) {
                if ("200".equals(header.getValue())) {
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void xiciTest() {
        System.out.println("爬取Ip中");
        CloseableHttpClient httpClient = BaseProxy.getHttpPostWithProxy("180.118.134.66", 9000, "http");
        String url = "http://www.xicidaili.com/nn/1";
        System.out.println(url);
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Accept", HeaderEnum.Accept.getType());
        httpGet.addHeader("Accept-Encoding", HeaderEnum.AcceptEncoding.getType());
        httpGet.addHeader("Accept-Language", HeaderEnum.AcceptLanguage.getType());
        httpGet.addHeader("Connection", HeaderEnum.Connection.getType());
        httpGet.addHeader("If-None-Match", "W/\"4acb70c806ea7878a35d8b7383e4800a\"");
        httpGet.addHeader("Host", "www.xicidaili.com");
        httpGet.addHeader("Upgrade-Insecure-Requests", HeaderEnum.UPGRADEINSECUREREQUESTS.getType());
        httpGet.addHeader("User-Agent", HeaderEnum.UserAgent.getType());
        String content = SendRequest.SendRequestAndResponse(httpGet, httpClient);
        System.out.println(content);
    }
}