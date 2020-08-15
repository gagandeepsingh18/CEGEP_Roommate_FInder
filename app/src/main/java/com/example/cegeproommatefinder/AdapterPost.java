package com.example.cegeproommatefinder;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterPost  extends  RecyclerView.Adapter<AdapterPost.PostHolder>{

    Context context;
    List<ModelPost> postList;
    private View.OnClickListener clickListener;

    public AdapterPost(Context context, List<ModelPost> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycleitem, parent, false);

        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
            String postTitle = postList.get(position).getPostTitle();
            String postDesc = postList.get(position).getPostDescription();
            String postImage = postList.get(position).getPostImage();

            holder.postTitle.setText(postTitle);
            holder.postDesc.setText(postDesc);

            try {
                Picasso.get().load(postImage).into(holder.postImage);
            }
            catch (Exception e)
            {
                Log.d("gagan", "onBindViewHolder: "+e);
            }


    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    class PostHolder extends RecyclerView.ViewHolder{
        ImageView postImage;
        TextView postTitle, postDesc;
        ImageButton postDetails;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            postTitle = itemView.findViewById(R.id.PostTitle);
            postDesc = itemView.findViewById(R.id.PostDescription);
            postImage = itemView.findViewById(R.id.PostImage);

            itemView.setTag(this);

            itemView.setOnClickListener(clickListener);

        }



    }

    public void setOnClickListner(View.OnClickListener onClickListner)
    {
        clickListener = onClickListner;
    }

}


