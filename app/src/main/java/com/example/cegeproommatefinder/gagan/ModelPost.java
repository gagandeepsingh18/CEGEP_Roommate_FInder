package com.example.cegeproommatefinder.gagan;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelPost implements Parcelable {
    String postTitle, postDescription, postImage;

    public ModelPost() {
    }

    public ModelPost(String postTitle, String postDescription, String postImage) {
        this.postTitle = postTitle;
        this.postDescription = postDescription;
        this.postImage = postImage;
    }

    protected ModelPost(Parcel in) {
        postTitle = in.readString();
        postDescription = in.readString();
        postImage = in.readString();
    }

    public static final Creator<ModelPost> CREATOR = new Creator<ModelPost>() {
        @Override
        public ModelPost createFromParcel(Parcel in) {
            return new ModelPost(in);
        }

        @Override
        public ModelPost[] newArray(int size) {
            return new ModelPost[size];
        }
    };

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(postTitle);
        dest.writeString(postDescription);
        dest.writeString(postImage);
    }
}
