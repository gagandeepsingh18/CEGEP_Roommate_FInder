package com.example.cegeproommatefinder;

public class User {

    String name ;
    public User()
    {
        //empty constructor
    }
    public User(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
}
