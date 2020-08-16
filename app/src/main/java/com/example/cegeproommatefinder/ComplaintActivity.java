package com.example.cegeproommatefinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ComplaintActivity extends AppCompatActivity implements View.OnClickListener{

EditText txtMessage, txtPhone, txtEmail;
Button buttonSubmit;
    DatabaseReference reff;
    Complaint complaint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);

        txtMessage=(EditText)findViewById(R.id.txtMessage);
        txtEmail=(EditText)findViewById(R.id.txtEmail);
        txtPhone=(EditText)findViewById(R.id.txtPhone);
        buttonSubmit=(Button)findViewById(R.id.buttonSubmit);
        reff= FirebaseDatabase.getInstance().getReference().child("complaint");

        complaint= new Complaint();

        Intent AskMeIntent=getIntent();

            Button button = findViewById(R.id.buttonSubmit);
            button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        {
            Toast.makeText(this,"Your Complaint Submitted!!!",Toast.LENGTH_SHORT).show();

            Long phonenumber=Long.parseLong(txtMessage.getText().toString().trim());
            complaint.setEmail(txtEmail.getText().toString().trim());
            complaint.setMessage(txtMessage.getText().toString().trim());
            complaint.setPhone(phonenumber);
            reff.push().setValue(complaint);


            }
    }
}