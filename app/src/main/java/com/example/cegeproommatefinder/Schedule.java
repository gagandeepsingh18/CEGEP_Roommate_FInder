package com.example.cegeproommatefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import static java.util.Calendar.getInstance;

public class Schedule extends AppCompatActivity {

EditText Name,Date,Time,Location,Email1,Email2,Email3;

    DatabaseReference myRef;
    pojo pj;
    String em1,em2,em3;
    String nm,dt,tm,loca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);

Name=findViewById(R.id.name);
        Date=findViewById(R.id.pickdate);
        Time=findViewById(R.id.picktime);
        Location=findViewById(R.id.location);

        Email1=findViewById(R.id.email1);

        Email2=findViewById(R.id.email2);
            Email3=findViewById(R.id.email3);
          myRef=   FirebaseDatabase.getInstance().getReference("Meetings");

        }

    @SuppressLint("LongLogTag")
    public void sendEmail(View view) {

         nm=Name.getText().toString().trim();
         dt=Date.getText().toString().trim();
         tm=Time.getText().toString().trim();
         loca=Location.getText().toString().trim();
        em1=Email1.getText().toString().trim();
         em2=Email2.getText().toString().trim();
         em3=Email3.getText().toString().trim();
        pj=new pojo(nm,dt,tm,loca,em1,em2,em3);
        myRef.child(nm).setValue(pj);

sendmail();

    }

    public  void sendmail()
    {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto",em1, null));
        intent.putExtra(android.content.Intent.EXTRA_EMAIL,
                new String[] { em2,em3 });
        intent.putExtra(Intent.EXTRA_SUBJECT, "Regarding Meeting");
        intent.putExtra(Intent.EXTRA_TEXT, "Your Meeting has been successfully scheduled and Information is as following :::: "+"\n Meeting Name= "+nm+"\n Date= "+dt+"\n Time= "+tm+"\n Location= "+loca);

        startActivity(Intent.createChooser(intent, ""));

    }
}
