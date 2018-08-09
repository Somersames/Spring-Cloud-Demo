package com.emum;

/**
 * @author szh
 * @create 2018-08-09 22:20
 **/
public enum  Header {

    Accept("application/json, text/javascript, */*; q=0.01"),

    AcceptEncoding("gzip, deflate, br"),

    AcceptLanguage("zh-CN,zh;q=0.9,en;q=0.8"),

    Connection("keep-alive"),

    ContentLength(""),

    ContentType("application/x-www-form-urlencoded; charset=UTF-8"),

    Host("www.lagou.com"),

    Origin("https://www.lagou.com"),

    Referer(""),

    UserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36"),

    XAnitForgeCode("0"),

    XAnitForgeToken("none"),

    XRequestedWith("XMLHttpRequest");

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    Header(String type) {
        this.type = type;
    }
}
