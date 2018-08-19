package com.somersames.pojo.lagou.dto;

import java.util.List;

/**
 * PositionResult结果集
 *
 * @author szh
 * @create 2018-08-12 21:01
 **/
public class PositionResult {
    private String totalCount;

    private List<LocationInfo> locationInfo;

    private String resultSize;

    private List<QueryAnalysisInfo> queryAnalysisInfo;

    private List<StrategyProperty> strategyProperty;

    private String hotLabels;

    private String hiTags;

    private List<CompanyInfo> result;

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public List<LocationInfo> getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(List<LocationInfo> locationInfo) {
        this.locationInfo = locationInfo;
    }

    public String getResultSize() {
        return resultSize;
    }

    public void setResultSize(String resultSize) {
        this.resultSize = resultSize;
    }

    public List<QueryAnalysisInfo> getQueryAnalysisInfo() {
        return queryAnalysisInfo;
    }

    public void setQueryAnalysisInfo(List<QueryAnalysisInfo> queryAnalysisInfo) {
        this.queryAnalysisInfo = queryAnalysisInfo;
    }

    public List<StrategyProperty> getStrategyProperty() {
        return strategyProperty;
    }

    public void setStrategyProperty(List<StrategyProperty> strategyProperty) {
        this.strategyProperty = strategyProperty;
    }

    public String getHotLabels() {
        return hotLabels;
    }

    public void setHotLabels(String hotLabels) {
        this.hotLabels = hotLabels;
    }

    public String getHiTags() {
        return hiTags;
    }

    public void setHiTags(String hiTags) {
        this.hiTags = hiTags;
    }

    public List<CompanyInfo> getResult() {
        return result;
    }

    public void setResult(List<CompanyInfo> result) {
        this.result = result;
    }
}
