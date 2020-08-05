package com.example.cegeproommatefinder;

public class ModelPost {
    String postTitle, postDescription, postImage;

    public ModelPost() {
    }

    public ModelPost(String postTitle, String postDescription, String postImage) {
        this.postTitle = postTitle;
        this.postDescription = postDescription;
        this.postImage = postImage;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }
}
