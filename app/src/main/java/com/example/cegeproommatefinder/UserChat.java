package com.example.cegeproommatefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class UserChat extends AppCompatActivity {
Intent intent=getIntent();
 String emaill=intent.getStringExtra("email");

 Button btn=findViewById(R.id.chatButton);
    EditText editText=findViewById(R.id.chatEdit);
   ListView listView=findViewById(R.id.chatList);

    public SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_chat);

        final ArrayList<String> msgList = new ArrayList<String>();
        final ArrayList<String> emaillList = new ArrayList<String>();


        sqLiteDatabase = this.openOrCreateDatabase("DBUSER", MODE_PRIVATE, null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS theChatUsers (msg VARCHAR,email VARCHAR, id INTEGER PRIMARY KEY)");


        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM theChatUsers where email=emaill", null);
        int msgIndex = c.getColumnIndex("msg");
        int emailIndex = c.getColumnIndex("email");

        c.moveToFirst();

        if (c != null) {
            do{ msgList.add(c.getString(msgIndex));
                emaillList.add(c.getString(emailIndex));
            }while (c.moveToNext());}
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=editText.getText().toString();
                sqLiteDatabase.execSQL("INSERT INTO theChatUsers (msg,email) VALUES (s1,emaill)");
                  editText.setText("");

            }
        });


    }
}