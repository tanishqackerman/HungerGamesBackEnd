package com.meow.hungergames.Entity;

public class Like {
    private String postId;
    private String userId;
    private String userName;
    private String userImg;
    private String dateTime;


    public Like() {

    }

    public Like(String postId, String userId, String userName, String userImg, String dateTime) {
        this.postId = postId;
        this.userId = userId;
        this.userName = userName;
        this.userImg = userImg;
        this.dateTime = dateTime;
    }

    public String getPostId() {
        return postId;
    }
    public void setPostId(String postId) {
        this.postId = postId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
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
