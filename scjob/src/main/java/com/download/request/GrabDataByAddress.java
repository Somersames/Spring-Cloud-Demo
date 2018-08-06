package com.download.request;

import com.download.Grab;
import org.apache.http.client.methods.HttpPost;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 拉勾首页获取数据
 *
 * @author szh
 * @create 2018-07-31 23:40
 **/
public class GrabDataByAddress extends Grab {

    @Resource
    HttpUtils httpUtils;

    @Override
    public String getData() {
        return null;
    }

    @Override
    public String getDataByAddress(String address) {
        Map<String,String> param =new HashMap<String, String>();
        httpUtils.sa();
        param.put("",""); // TODO 请求头
        HttpPost httpPost =HttpUtils.startGrab(param,address,address);
        return "OK";
    }
}
