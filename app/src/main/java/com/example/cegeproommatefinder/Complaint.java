package com.example.cegeproommatefinder;

import androidx.appcompat.app.AppCompatActivity;

public class Complaint {
    private String message;
    private Integer phonenumber;
    private String email;

    public Complaint() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getPhone() {
        return phonenumber;
    }

    public void setPhone(Long phone) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
