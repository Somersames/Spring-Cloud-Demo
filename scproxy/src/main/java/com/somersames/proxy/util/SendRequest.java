package com.somersames.proxy.util;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author szh
 * @create 2018-08-31 23:49
 **/
public class SendRequest {
    public static String SendRequestAndResponse(HttpGet httpGet, CloseableHttpClient httpClient){
        Map<String,String> map =new HashMap<String, String>();
        StringBuffer sb = new StringBuffer();
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();
            InputStream inputStream = httpEntity.getContent();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                String s = new String(bytes, 0, len);
                sb.append(s);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
