package com.example.cegeproommatefinder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class UserChat extends AppCompatActivity {

 Button btn;
    EditText editText;


    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ChildEventListener childEventListener;
    private RecyclerView recyclerView;
    private AdapterChat adapterChat;

    private List<Chat> cList;

    Intent intent=getIntent();
    String name;
    String userId;
    String postUserId;
    String msg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_chat);
        btn=findViewById(R.id.chatButton);
         editText=findViewById(R.id.chatEdit);


        Intent intent=getIntent();
         name=intent.getStringExtra("postUser");
       userId=intent.getStringExtra("userId");
        postUserId=intent.getStringExtra("postUserId");

cList=new ArrayList<>();

recyclerView=findViewById(R.id.recyclerViewChatList);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Message");
      recyclerView.setLayoutManager( new LinearLayoutManager(this));
    adapterChat=new AdapterChat( this,cList);




        childEventListener=new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
Chat chat=snapshot.getValue(Chat.class);
cList.add(chat);
adapterChat.notifyDataSetChanged();

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        databaseReference.removeEventListener(childEventListener);
    }


    public void OnClickChat(View view) {
        msg=editText.getText().toString();
        Chat chat=new Chat(userId,postUserId,msg);
        String key=databaseReference.push().getKey();
        databaseReference.child(key).setValue(chat);
    }
}
