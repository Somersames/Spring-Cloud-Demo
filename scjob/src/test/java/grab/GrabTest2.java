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
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
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
 * @create 2018-08-25 15:25
 **/
public class GrabTest2 {
    @Test
    public void  getDataByAddress() throws IOException {
        HttpUtils httpUtils =new HttpUtils();
////        CloseableHttpClient httpClient = BaseProxy.getHttpPostWithProxy("117.127.0.195", 8080, "http");
//////        HttpHost proxy = new HttpHost("121.8.98.198", 80, "http");
//////        //把代理设置到请求配置
//////        RequestConfig defaultRequestConfig = RequestConfig.custom()
//////                .setProxy(proxy)
//////                .build();
//////        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
//        HttpHost proxy = new HttpHost("121.31.147.100", 8123);
        DefaultHttpClient httpClient = new DefaultHttpClient();
//        httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,proxy);

        Map<String,String> paramMap =new HashMap<>();
        paramMap.put("accept", Header.Accept.getType());
        paramMap.put("Accept-Encoding", Header.AcceptEncoding.getType());
        paramMap.put("Accept-Language", Header.AcceptLanguage.getType());
        paramMap.put("Connection", Header.Connection.getType());
        paramMap.put("Content-Type", Header.ContentType.getType());
        paramMap.put("Cookie", "");
        paramMap.put("Host", "www.lagou.com");
        paramMap.put("Origin", "https://www.lagou.com");
        paramMap.put("Referer", "https://www.lagou.com/jobs/list_java?labelWords=&fromSearch=true&suginput=");
        paramMap.put("User-Agent:", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
        paramMap.put("X-Anit-Forge-Code:", "0");
        paramMap.put("X-Anit-Forge-Token:", "none");
        paramMap.put("X-Requested-With", "XMLHttpRequest");
        HttpPost post=httpUtils.startGrab(paramMap,"https://www.lagou.com/jobs/positionAjax.json?city=%E4%B8%8A%E6%B5%B7&needAddtionalResult=false","POST");
//        post.setConfig(defaultRequestConfig);
        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("first", "true"));
        params.add(new BasicNameValuePair("pn", "1"));
        params.add(new BasicNameValuePair("kd", "java"));
        post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
//        post.setProtocolVersion();
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
