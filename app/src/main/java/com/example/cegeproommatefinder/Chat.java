package com.example.cegeproommatefinder;

public class Chat {
    String userId,postUserId,msg;

    public Chat(String userId, String postUserId, String msg) {
        this.userId=userId;
        this.postUserId=postUserId;
        this.msg=msg;
    }

    public Chat() {
    }

    public String getUserId(){
        return userId;
    }
    public String getPostUserId(){
        return postUserId;
    }
    public String getMsg(){
        return msg;
    }
    public void setUserId(String userId){
       this.userId=userId;
    }
    public void setPostUserId(String postUserId){
        this.postUserId=postUserId;
    }
    public void setMsg(String  msg){
        this.msg=msg;
    }
}
