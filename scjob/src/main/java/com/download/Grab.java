package com.download;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 抓取信息的类
 *
 * @author szh
 * @create 2018-07-31 23:26
 **/
public abstract class Grab {
    /**
     *
     * @return
     */
    public abstract String getData();


    public abstract String getDataByAddress(String address) throws IOException;

}
