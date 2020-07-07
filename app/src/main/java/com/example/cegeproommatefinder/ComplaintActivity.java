package com.example.cegeproommatefinder;

import android.os.Bundle;
import android.*;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ComplaintActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);


        // Enables Always-on
        //setAmbientEnabled();
    }
}