package com.somersames.proxy.valid;

/**
 * 通过访问百度和站长之家来验证IP
 */
public interface ValidIp {
    /**
     *通过给定的url来验证IP
     * @param
     * @return
     */
    void valid();
}
