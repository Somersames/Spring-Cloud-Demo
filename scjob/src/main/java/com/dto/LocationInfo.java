package com.dto;

/**
 * 地址信息
 *
 * @author szh
 * @create 2018-08-12 21:02
 **/
public class LocationInfo {

    private String city;

    private String district;

    private String queryByGisCode;

    private String businessZone;

    private String locationCode;

    private String isAllhotBusinessZone;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getQueryByGisCode() {
        return queryByGisCode;
    }

    public void setQueryByGisCode(String queryByGisCode) {
        this.queryByGisCode = queryByGisCode;
    }

    public String getBusinessZone() {
        return businessZone;
    }

    public void setBusinessZone(String businessZone) {
        this.businessZone = businessZone;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getIsAllhotBusinessZone() {
        return isAllhotBusinessZone;
    }

    public void setIsAllhotBusinessZone(String isAllhotBusinessZone) {
        this.isAllhotBusinessZone = isAllhotBusinessZone;
    }
}
