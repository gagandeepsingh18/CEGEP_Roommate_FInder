package com.example.cegeproommatefinder;

    import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{


    private ArrayList<Post> arrayList;
    private Context context;
    private View.OnClickListener clickListener;

    public RecyclerAdapter (ArrayList<Post> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).asBitmap().load(arrayList.get(position).getImage()).into(holder.imgv);
        holder.txt.setText(arrayList.get(position).getPostTitle());
    }

    public void setOnClickListner(View.OnClickListener onClickListner)
    {
        clickListener = onClickListner;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
          ImageView imgv;
          TextView txt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgv = itemView.findViewById(R.id.PostImage);
            txt = itemView.findViewById(R.id.PostTitle);

            itemView.setTag(this);
            itemView.setOnClickListener(clickListener);

        }
    }
}
