package com.meow.hungergames.Entity;

public class Comment {
    private String postId;
    private String commentId;
    private String userId;
    private String userName;
    private String userImg;
    private String comment;
    private String dateTime;


    public Comment() {

    }

    public Comment(String postId, String commentId, String userId, String userName, String userImg, String comment, String dateTime) {
        this.postId = postId;
        this.commentId = commentId;
        this.userId = userId;
        this.userName = userName;
        this.userImg = userImg;
        this.comment = comment;
        this.dateTime = dateTime;
    }

    public String getPostId() {
        return postId;
    }
    public void setPostId(String postId) {
        this.postId = postId;
    }
    public String getCommentId() {
        return commentId;
    }
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }
}
