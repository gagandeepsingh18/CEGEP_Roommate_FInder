package com.example.cegeproommatefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {
    public SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        final ArrayList<String> arrayList = new ArrayList<String>();
        final ArrayList<String> emailList = new ArrayList<String>();



        try {

         sqLiteDatabase = this.openOrCreateDatabase("DBUSER", MODE_PRIVATE, null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS theNewUsers (name VARCHAR,email VARCHAR, id INTEGER PRIMARY KEY)");
           sqLiteDatabase.execSQL("INSERT INTO theNewUsers (name) VALUES ('Harwinder','harry@gmail.com')");
            //sqLiteDatabase.execSQL("INSERT INTO theNewUsers (name) VALUES ('Gagan')");
           // sqLiteDatabase.execSQL("INSERT INTO theNewUsers (name) VALUES ('Mani')");
           // sqLiteDatabase.execSQL("INSERT INTO theNewUsers (name) VALUES ('Vishal')");
            //sqLiteDatabase.execSQL("INSERT INTO theNewUsers (name) VALUES ('jag')");
            //sqLiteDatabase.execSQL("INSERT INTO theNewUsers (name) VALUES ('mohit')");
           // sqLiteDatabase.execSQL("INSERT INTO theNewUsers (name) VALUES ('subham')");





            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM theNewUsers", null);
            int nameIndex = c.getColumnIndex("name");
            int emailIndex = c.getColumnIndex("email");

            c.moveToFirst();

            if (c != null) {
                do{ arrayList.add(c.getString(nameIndex));
                    emailList.add(c.getString(emailIndex));
                }while (c.moveToNext());}
        } catch (Exception e) {
            e.printStackTrace();
        }


        final ListView listView = findViewById(R.id.userListView);



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 String name=listView.getItemAtPosition(i).toString();
                 int indexOf =arrayList.indexOf(name);
                 String email=emailList.get(indexOf);
                Intent intent =new Intent(UserList.this,UserChat.class);
                startActivity(intent);
                finish();

            }
        });
    }
    }
