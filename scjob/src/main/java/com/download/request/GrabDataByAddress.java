package com.download.request;

import com.download.Grab;
import com.emum.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 拉勾首页获取数据
 *
 * @author szh
 * @create 2018-07-31 23:40
 **/
@Service
public class GrabDataByAddress extends Grab {

    @Resource
    HttpUtils httpUtils;

    @Override
    public String getData() {
        return null;
    }

    @Override
    public String getDataByAddress(String address) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        Map<String,String> param =new HashMap<String, String>();
        Map<String,String> paramMap =new HashMap<>();
        paramMap.put("accept", Header.Accept.getType());
        paramMap.put("Accept-Encoding", Header.AcceptEncoding.getType());
        paramMap.put("Accept-Language", Header.AcceptLanguage.getType());
        paramMap.put("Connection", Header.Connection.getType());
        paramMap.put("Content-Type", Header.ContentType.getType());
        paramMap.put("Cookie", "JSESSIONID=ABAAABAAAFCAAEG40E027925B1C5E1CB19E7FE90D3CD3D5; user_trace_token=20180813233451-7a1d8fce-a19e-475a-a40f-6642d5742662; SEARCH_ID=a1446d307db74811817010321867ba13");
        paramMap.put("Host", "www.lagou.com");
        paramMap.put("Origin", "https://www.lagou.com");
        paramMap.put("Referer", "https://www.lagou.com/jobs/list_java?city=%E5%85%A8%E5%9B%BD&cl=false&fromSearch=true&labelWords=&suginput=");
        paramMap.put("User-Agent:", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
        paramMap.put("X-Anit-Forge-Code:", "0");
        paramMap.put("X-Anit-Forge-Token:", "none");
        paramMap.put("X-Requested-With", "XMLHttpRequest");
        HttpPost post=httpUtils.startGrab(paramMap,"https://www.lagou.com/jobs/positionAjax.json?needAddtionalResult=false","POST");
        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("first", "true"));
        params.add(new BasicNameValuePair("pn", "1"));
        params.add(new BasicNameValuePair("kd", "java"));
        post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        CloseableHttpResponse response = httpClient.execute(post);
        HttpEntity httpEntity = response.getEntity();
        if (httpClient != null) {
            InputStream inputStream = httpEntity.getContent();
        }
        return "OK";
    }
}
