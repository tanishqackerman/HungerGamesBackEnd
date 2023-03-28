package com.meow.hungergames.Entity;

import java.util.List;

public class Post {
    private String postId;
    private String userId;
    private String userName;
    private String userImg;
    private String imgUrl;
    private String recipeName;
    private int likes;
    private int comments;
    private List<String> ingredients;
    private List<String> steps;
    private String date;
    private boolean isVeg;

    public Post() {
    }

    public Post(String postId, String userId, String userName, String userImg, String imgUrl, String recipeName, int likes, int comments, List<String> ingredients, List<String> steps, String date, boolean isVeg) {
        this.postId = postId;
        this.userId = userId;
        this.userName = userName;
        this.userImg = userImg;
        this.imgUrl = imgUrl;
        this.recipeName = recipeName;
        this.likes = likes;
        this.comments = comments;
        this.ingredients = ingredients;
        this.steps = steps;
        this.date = date;
        this.isVeg = isVeg;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean getIsVeg() {
        return isVeg;
    }

    public void setIsVeg(boolean isVeg) {
        this.isVeg = isVeg;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    
}
