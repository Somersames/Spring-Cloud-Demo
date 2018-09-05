package com.somersames.proxy;

import java.io.IOException;

public interface BaseRequest {
   /**
    * 开始抓取网页
    * @throws IOException
    */
   void grad() throws IOException;

   String say();
}
