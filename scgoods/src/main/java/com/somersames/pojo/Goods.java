package com.somersames.pojo;

import java.math.BigInteger;

/**
 * 物品类
 *
 * @author szh
 * @create 2018-05-24 14:21
 **/
public class Goods {
    private String goodUUID;
    private int goodId;
    private String goodName;
    private String goodIntroduction;
    private String publishDate;
    private String publishPeople;
    private int browseNum;
    private boolean isFinish;

    public String getGoodUUID() {
        return goodUUID;
    }

    public void setGoodUUID(String goodUUID) {
        this.goodUUID = goodUUID;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodIntroduction() {
        return goodIntroduction;
    }

    public void setGoodIntroduction(String goodIntroduction) {
        this.goodIntroduction = goodIntroduction;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublishPeople() {
        return publishPeople;
    }

    public void setPublishPeople(String publishPeople) {
        this.publishPeople = publishPeople;
    }

    public int getBrowseNum() {
        return browseNum;
    }

    public void setBrowseNum(int browseNum) {
        this.browseNum = browseNum;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }
}
