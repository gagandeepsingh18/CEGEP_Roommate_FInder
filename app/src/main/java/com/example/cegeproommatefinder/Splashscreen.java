package com.example.cegeproommatefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import static java.lang.Thread.sleep;

public class Splashscreen extends AppCompatActivity {
    private final int DisplayTime = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent intent = new Intent(Splashscreen.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, DisplayTime);
    }



}