package grab;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.download.request.HttpUtils;
import com.dto.LagouDto;
import com.emum.Header;
import com.proxy.BaseProxy;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author szh
 * @create 2018-08-13 23:45
 **/
public class GrabTest {
    @Test
    public void  getDataByAddress() throws IOException {
        HttpUtils httpUtils =new HttpUtils();
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        CloseableHttpClient httpClient = BaseProxy.getHttpPostWithProxy("115.46.98.208", 8123, "http");
        Map<String,String> param =new HashMap<String, String>();
        HttpHost proxy = new HttpHost("58.38.94.126", 9797);
        //把代理设置到请求配置
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setProxy(proxy)
                .build();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        Map<String,String> paramMap =new HashMap<>();
        paramMap.put("accept", Header.Accept.getType());
        paramMap.put("Accept-Encoding", Header.AcceptEncoding.getType());
        paramMap.put("Accept-Language", Header.AcceptLanguage.getType());
        paramMap.put("Connection", Header.Connection.getType());
        paramMap.put("Content-Type", Header.ContentType.getType());
        paramMap.put("Cookie", "");
        paramMap.put("Host", "www.lagou.com");
        paramMap.put("Origin", "https://www.lagou.com");
        paramMap.put("Referer", "https://www.lagou.com/jobs/list_java?city=%E5%85%A8%E5%9B%BD&cl=false&fromSearch=true&labelWords=&suginput=");
        paramMap.put("User-Agent:", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
        paramMap.put("X-Anit-Forge-Code:", "0");
        paramMap.put("X-Anit-Forge-Token:", "none");
        paramMap.put("X-Requested-With", "XMLHttpRequest");
        HttpPost post=httpUtils.startGrab(paramMap,"https://www.lagou.com/jobs/positionAjax.json?needAddtionalResult=false","POST");
//        post.setConfig(defaultRequestConfig);
        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("first", "true"));
        params.add(new BasicNameValuePair("pn", "1"));
        params.add(new BasicNameValuePair("kd", "java"));
        post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        CloseableHttpResponse response = httpClient.execute(post);
        HttpEntity httpEntity = response.getEntity();
        if (httpClient != null) {
            InputStream inputStream = httpEntity.getContent();
            byte[] bytes = new byte[1024];
            int len;
            StringBuffer sb =new StringBuffer();
            while ((len = inputStream.read(bytes)) != -1) {
                String s = new String(bytes, 0, len);
                sb.append(s);
            }
            String result = sb.toString();
            LagouDto lagouDto = JSON.parseObject(result, new TypeReference<LagouDto>() {});
            System.out.println(lagouDto.getContent().getPageSize());
        }

    }
}
