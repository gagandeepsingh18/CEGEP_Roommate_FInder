package com.example.cegeproommatefinder;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class DisplayPostFragment extends Fragment {
    ImageView postDetailsImage;
    TextView postDetailsTitle, postDetailsDescription;
    Post post;


    public DisplayPostFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_display_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        postDetailsImage = view.findViewById(R.id.PostDetailsImage);
        postDetailsTitle = view.findViewById(R.id.PostDetailsTitle);
        postDetailsDescription = view.findViewById(R.id.PostDetailsDescription);


        postDetailsDescription.setMovementMethod(new ScrollingMovementMethod());

        post = getArguments().getParcelable("Post");

        generateView();

    }

    public void generateView()
    {
        Picasso.get().load(post.getImage()).into(postDetailsImage);
        postDetailsTitle.setText("Post Title :"+post.getPostTitle());
        postDetailsDescription.setText("Post Title :"+post.getDescription());
    }
}