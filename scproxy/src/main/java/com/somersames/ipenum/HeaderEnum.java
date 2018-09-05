package com.somersames.ipenum;

public enum HeaderEnum {

    Accept("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),

    AcceptEncoding("gzip, deflate"),

    AcceptLanguage("zh-CN,zh;q=0.9,en;q=0.8"),

    CACHECONTROLL("max-age=0"),

    Connection("keep-alive"),

    ContentLength(""),

    ContentType("application/x-www-form-urlencoded; charset=UTF-8"),

    Host("www.data5u.com"),

    Origin("https://www.lagou.com"),

    UPGRADEINSECUREREQUESTS("1"),


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

    HeaderEnum(String type) {
        this.type = type;
    }
}
