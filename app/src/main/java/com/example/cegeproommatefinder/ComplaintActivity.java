package com.example.cegeproommatefinder;

import android.os.Bundle;
import android.*;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ComplaintActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);

            Button button = findViewById(R.id.SubmitButton);
            button.setOnClickListener(this);
        // Enables Always-on
        //setAmbientEnabled();
    }

    @Override
    public void onClick(View v) {
        {
            Toast.makeText(this,"Your Complaint Submitted!!!",Toast.LENGTH_SHORT).show();
            }
    }
}