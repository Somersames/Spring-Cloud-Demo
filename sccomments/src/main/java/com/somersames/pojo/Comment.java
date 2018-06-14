package com.somersames.pojo;

import java.io.Serializable;

/**
 * 评论实体类
 *
 * @author szh
 * @create 2018-05-31 9:59
 **/
public class Comment implements Serializable {
    private String commentUUID;
    private int commentId;
    private String commentTitle;
    private String commentContent;
    private int commentUserId;
    private String commentDate;
    private int goodId;
    private int commentOrder;


    public String getCommentUUID() {
        return commentUUID;
    }

    public void setCommentUUID(String commentUUID) {
        this.commentUUID = commentUUID;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(int commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public int getCommentOrder() {
        return commentOrder;
    }

    public void setCommentOrder(int commentOrder) {
        this.commentOrder = commentOrder;
    }
}
