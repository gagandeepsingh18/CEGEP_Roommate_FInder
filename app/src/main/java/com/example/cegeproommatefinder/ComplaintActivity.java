package com.example.cegeproommatefinder;

import android.content.Intent;
import android.os.Bundle;
import android.*;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ComplaintActivity extends AppCompatActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);


        Intent AskMeIntent=getIntent();

            Button button = findViewById(R.id.SubmitButton);
            button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        {
            Toast.makeText(this,"Your Complaint Submitted!!!",Toast.LENGTH_SHORT).show();
            }
    }
}