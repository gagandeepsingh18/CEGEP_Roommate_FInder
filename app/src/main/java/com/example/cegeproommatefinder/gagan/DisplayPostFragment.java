package com.example.cegeproommatefinder.gagan;

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

import com.example.cegeproommatefinder.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class DisplayPostFragment extends Fragment {
    TextView postTitle, postDescription;
      ImageView postImage;

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

        modelPost= getArguments().getParcelable("Post selected");

        Picasso.get().load(modelPost.getPostImage()).into(postImage);
        postTitle.setText(modelPost.getPostTitle());
        postDescription.setText(modelPost.getPostDescription());

    }

    }