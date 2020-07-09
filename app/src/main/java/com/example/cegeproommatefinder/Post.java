
package com.example.cegeproommatefinder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("Post Title")
    @Expose
    private String postTitle;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("Price")
    @Expose
    private String price;
    @SerializedName("description")
    @Expose
    private String description;

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
