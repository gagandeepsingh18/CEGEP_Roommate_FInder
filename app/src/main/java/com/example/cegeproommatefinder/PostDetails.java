
package com.example.cegeproommatefinder;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostDetails {

    @SerializedName("Post")
    @Expose
    private List<Post> post = null;

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

}
