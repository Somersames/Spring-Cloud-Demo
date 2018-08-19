package com.somersames.pojo.lagou.dto;

import java.util.Map;

/**
 * json里面的Content
 *
 * @author szh
 * @create 2018-08-12 23:07
 **/
public class Content {
    private String pageNo;

    private String pageSize;

    private Map<String,HrInfoMap> hrInfoMap;

    private PositionResult positionResult;
    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, HrInfoMap> getHrInfoMap() {
        return hrInfoMap;
    }

    public void setHrInfoMap(Map<String, HrInfoMap> hrInfoMap) {
        this.hrInfoMap = hrInfoMap;
    }

    public PositionResult getPositionResult() {
        return positionResult;
    }

    public void setPositionResult(PositionResult positionResult) {
        this.positionResult = positionResult;
    }
}
