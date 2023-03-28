package com.meow.hungergames.Entity;

public class Saved {
    
    private Post post;
    private String savedBy;
    private String dateTime;

    public Saved() {
        
    }

    public Saved(Post post, String savedBy, String dateTime) {
        this.post = post;
        this.savedBy = savedBy;
        this.dateTime = dateTime;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getSavedBy() {
        return savedBy;
    }

    public void setSavedBy(String savedBy) {
        this.savedBy = savedBy;
    }
}
