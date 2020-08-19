package com.example.cegeproommatefinder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserList extends AppCompatActivity {

  private FirebaseDatabase firebaseDatabase;
   private DatabaseReference databaseReference;
   private ChildEventListener childEventListener;
  private RecyclerView recyclerView;
  private AdapterUser adapterUser;

private List<User> uList;

    Intent intent=getIntent();
    String name=intent.getStringExtra("postUser");
    String userId=intent.getStringExtra("userId");
    String postUserId=intent.getStringExtra("postUserId");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

firebaseDatabase=FirebaseDatabase.getInstance();
databaseReference=firebaseDatabase.getReference("UserList");
        User user=new User(name);
        databaseReference.child(postUserId).setValue(user);

uList=new ArrayList<>();

recyclerView=findViewById(R.id.recyclerViewUserList);
recyclerView.setLayoutManager(new LinearLayoutManager(this));
adapterUser=new AdapterUser(this,uList);
recyclerView.setAdapter(adapterUser);

        childEventListener=new ChildEventListener() {
    @Override
    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

User user =snapshot.getValue(User.class);
uList.add(user);
adapterUser.notifyDataSetChanged();
    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
};
databaseReference.addChildEventListener(childEventListener);
    }


    }
