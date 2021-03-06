package com.example.cegeproommatefinder.gagan;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cegeproommatefinder.R;
import com.example.cegeproommatefinder.UserChat;
import com.example.cegeproommatefinder.UserList;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.List;


public class DisplayPostFragment extends Fragment {
    TextView postTitle, postDescription, postUser, postPrice, postAddress, postCity,postPincode;
      ImageView postImage;
      String uid, email,currentUser;

    ModelPost modelPost;


    public DisplayPostFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        postImage = view.findViewById(R.id.PostDetailsImage);
        postTitle = view.findViewById(R.id.PostDetailsTitle);
        postDescription = view.findViewById(R.id.PostDetailsDescription);
        postUser = view.findViewById(R.id.PostDetailsUserName);
        postPrice = view.findViewById(R.id.PostDetailsPrice);
        postAddress= view.findViewById(R.id.PostDetailsAddress);
        postCity= view.findViewById(R.id.PostDetailsCity);
        postPincode= view.findViewById(R.id.PostDetailsPincode);

        modelPost= getArguments().getParcelable("Post selected");

        Picasso.get().load(modelPost.getPostImage()).into(postImage);
        postTitle.setText(modelPost.getPostTitle());
        postDescription.setText(modelPost.getPostDescription());
        postPrice.setText("Price: $"+modelPost.getPostPrice());
        postAddress.setText("Address:             "+modelPost.getPostAddress());
        postCity.setText("City: "+modelPost.getPostCity());
        postPincode.setText("Pincode:             "+modelPost.getPostPincode());
        postUser.setText("Chat with Authour: "+modelPost.getName());
        uid = modelPost.getUid();
        FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();
        FirebaseUser firebaseUser= firebaseAuth.getCurrentUser();
        if (firebaseUser != null){
            email = firebaseUser.getEmail();
            currentUser = firebaseUser.getUid();

        }

        postUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), UserChat.class);
                intent.putExtra("userId",currentUser);
                intent.putExtra("postUserId",uid);
                intent.putExtra("postUser",modelPost.getName());
                startActivity(intent);
                


            }
        });


    }





    }