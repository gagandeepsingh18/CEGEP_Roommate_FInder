package com.example.cegeproommatefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        final ArrayList<String> arrayList = new ArrayList<String>();



        try {

         SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS theNewUsers (name VARCHAR, id INTEGER PRIMARY KEY)");
           // sqLiteDatabase.execSQL("INSERT INTO theNewUsers (name) VALUES ('Harwinder')");
            //sqLiteDatabase.execSQL("INSERT INTO theNewUsers (name) VALUES ('Gagan')");
           // sqLiteDatabase.execSQL("INSERT INTO theNewUsers (name) VALUES ('Mani')");
           // sqLiteDatabase.execSQL("INSERT INTO theNewUsers (name) VALUES ('Vishal')");
            //sqLiteDatabase.execSQL("INSERT INTO theNewUsers (name) VALUES ('jag')");
            //sqLiteDatabase.execSQL("INSERT INTO theNewUsers (name) VALUES ('mohit')");
           // sqLiteDatabase.execSQL("INSERT INTO theNewUsers (name) VALUES ('subham')");





            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM theNewUsers", null);
            int nameIndex = c.getColumnIndex("name");

            c.moveToFirst();

            if (c != null) {
                do{ arrayList.add(c.getString(nameIndex));
                }while (c.moveToNext());}
        } catch (Exception e) {
            e.printStackTrace();
        }


        ListView listView = findViewById(R.id.userListView);



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


            }
        });
    }
    }
