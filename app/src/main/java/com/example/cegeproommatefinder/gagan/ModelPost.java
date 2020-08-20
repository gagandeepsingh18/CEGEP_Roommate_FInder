package com.example.cegeproommatefinder.gagan;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelPost implements Parcelable {
  String postTitle, postDescription, postImage, name, uid;

  public ModelPost(){

  }

  public ModelPost(String postTitle, String postDescription, String postImage, String name, String uid) {
    this.postTitle = postTitle;
    this.postDescription = postDescription;
    this.postImage = postImage;
    this.name = name;
    this.uid = uid;
  }

  protected ModelPost(Parcel in) {
    postTitle = in.readString();
    postDescription = in.readString();
    postImage = in.readString();
    name = in.readString();
    uid = in.readString();
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
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
    dest.writeString(name);
    dest.writeString(uid);
  }
}