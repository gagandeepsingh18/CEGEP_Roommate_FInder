package com.example.cegeproommatefinder.gagan;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelPost implements Parcelable {
  String postTitle, postDescription, postImage, name, uid,PostPrice, PostAddress, PostCity, PostPincode;

  public ModelPost() {
  }

  public ModelPost(String postTitle, String postDescription, String postImage, String name, String uid, String postPrice, String postAddress, String postCity, String postPincode) {
    this.postTitle = postTitle;
    this.postDescription = postDescription;
    this.postImage = postImage;
    this.name = name;
    this.uid = uid;
    this.PostPrice = postPrice;
    this.PostAddress = postAddress;
    this.PostCity = postCity;
    this.PostPincode = postPincode;
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

  public String getPostPrice() {
    return PostPrice;
  }

  public void setPostPrice(String postPrice) {
    PostPrice = postPrice;
  }

  public String getPostAddress() {
    return PostAddress;
  }

  public void setPostAddress(String postAddress) {
    PostAddress = postAddress;
  }

  public String getPostCity() {
    return PostCity;
  }

  public void setPostCity(String postCity) {
    PostCity = postCity;
  }

  public String getPostPincode() {
    return PostPincode;
  }

  public void setPostPincode(String postPincode) {
    PostPincode = postPincode;
  }

  protected ModelPost(Parcel in) {
    postTitle = in.readString();
    postDescription = in.readString();
    postImage = in.readString();
    name = in.readString();
    uid = in.readString();
    PostPrice = in.readString();
    PostAddress = in.readString();
    PostCity = in.readString();
    PostPincode = in.readString();
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
    dest.writeString(PostPrice);
    dest.writeString(PostAddress);
    dest.writeString(PostCity);
    dest.writeString(PostPincode);
  }
}