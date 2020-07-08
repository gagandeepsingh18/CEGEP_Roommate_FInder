package com.example.schedulemeet;

public class pojo {

    public String name;
    public String date;
    public String time;
    public String location;
    public String recipient1;
    public String recipient2;
    public String recipient3;

    public pojo(String name, String date, String time, String location, String recipient1, String recipient2, String recipient3) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.recipient1 = recipient1;
        this.recipient2 = recipient2;
        this.recipient3 = recipient3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRecipient1() {
        return recipient1;
    }

    public void setRecipient1(String recipient1) {
        this.recipient1 = recipient1;
    }

    public String getRecipient2() {
        return recipient2;
    }

    public void setRecipient2(String recipient2) {
        this.recipient2 = recipient2;
    }

    public String getRecipient3() {
        return recipient3;
    }

    public void setRecipient3(String recipient3) {
        this.recipient3 = recipient3;
    }
}
