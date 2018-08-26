package com.somersames.util;

import com.somersames.dto.ProxyDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author szh
 * @create 2018-08-26 23:15
 **/
public class ParseUtil {
    public static List<ProxyDto> parseContent(String content) {
        Document document = Jsoup.parse(content);
        List<ProxyDto> list = new ArrayList<ProxyDto>();
        Elements liElements = document.getElementsByClass("l2");
        for (int i = 0; i < liElements.size(); i++) {
            Elements temp = liElements.get(i).getElementsByTag("span");
            String[] ipContent = temp.text().split(" ");
            ProxyDto proxyDto =new ProxyDto();
            for (String str : ipContent) {
                if(str.contains(".")){
                    proxyDto.setIp(str);
                }else if(isNum(str)){
                    proxyDto.setIp(str);
                }
                list.add(proxyDto);
            }
        }
        return list;
    }
    private  static  boolean isNum(String str){
        if(str == null || str.length() ==0){
            return false;
        }
        for(int i= 0 ;i<str.length() ;i++){
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
