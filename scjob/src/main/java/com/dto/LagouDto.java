package com.dto;

/**
 * 使用DTO主要是考虑以后存储数据和以后的复用
 *
 * @author szh
 * @create 2018-08-12 23:03
 **/
public class LagouDto {
    private String requestId;

    private String msg;

    private String resubmitToken;

    private String success;

    private Content content;

    private String code;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResubmitToken() {
        return resubmitToken;
    }

    public void setResubmitToken(String resubmitToken) {
        this.resubmitToken = resubmitToken;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
