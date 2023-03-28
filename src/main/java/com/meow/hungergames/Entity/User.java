package com.meow.hungergames.Entity;

public class User {

    private String userId;
    private String userName;
    private String userImage;
    private String userBio;
    private String joiningDate;

    public User() {
    }

    public User(String userId, String userName, String userImage, String userBio, String joiningDate) {
        this.userId = userId;
        this.userName = userName;
        this.userImage = userImage;
        this.userBio = userBio;
        this.joiningDate = joiningDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getUserBio() {
        return userBio;
    }

    public void setUserBio(String userBio) {
        this.userBio = userBio;
    }
}
