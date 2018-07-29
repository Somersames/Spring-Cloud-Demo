package com.somersames.pojo;


/**
 * 物品类
 *
 * @author szh
 * @create 2018-05-24 14:21
 **/
public class Goods {
    /**
     * 商品的UUId
     */
    private String goodUUID;
    /**
     * 商品的ID
     */
    private int goodId;
    /**
     * 商品的名称
     */
    private String goodName;
    /**
     * 商品的简介
     */
    private String goodIntroduction;
    /**
     * 商品的发布日期
     */
    private String publishDate;
    /**
     * 商品的发布人
     */
    private String publishPeople;
    /**
     * 商品的浏览数量
     */
    private int viewNum;
    /**
     * 商品交易是否完成
     */
    private boolean isFinish;
    /**
     * 商品的被喜欢次数
     */
    private int beFavorite;

    private String type;


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

    public int getViewNum() {
        return viewNum;
    }

    public void setViewNum(int viewNum) {
        this.viewNum = viewNum;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }

    public int getBeFavorite() {
        return beFavorite;
    }

    public void setBeFavorite(int beFavorite) {
        this.beFavorite = beFavorite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
