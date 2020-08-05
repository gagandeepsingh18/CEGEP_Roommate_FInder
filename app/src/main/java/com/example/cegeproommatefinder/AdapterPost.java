package com.example.cegeproommatefinder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterPost  extends  RecyclerView.Adapter<AdapterPost.PostHolder>{

    Context context;
    List<ModelPost> postList;

    public AdapterPost(Context context, List<ModelPost> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class PostHolder extends RecyclerView.ViewHolder{
        ImageView postImage;
        TextView postTitle, postDesc;
        ImageButton postDetails;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            postTitle = itemView.findViewById(R.id.PostTitle);
            postDesc = itemView.findViewById(R.id.PostDescription);
            postImage = itemView.findViewById(R.id.PostImage );

        }
    }
}


