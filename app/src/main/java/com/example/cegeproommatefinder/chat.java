package com.example.cegeproommatefinder;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class chat extends Activity
{
    Button btn1;
    EditText editText;
    ListView listView;
    ArrayList<String> arrayList=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    DatabaseReference root =FirebaseDatabase.getInstance().getReference().getRoot();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        btn1=(Button)findViewById(R.id.btn1);
        listView=(ListView)findViewById(R.id.listviewchat);
        editText=(EditText)findViewById(R.id.editTextTextPersonName);
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
      btn1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Map<String,Object> map=new HashMap<String, Object>();
              map.put(editText.getText().toString(),"");
              root.updateChildren(map);
          }
      });
    }
}
