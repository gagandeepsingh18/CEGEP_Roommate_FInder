package com.example.cegeproommatefinder;

    import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
    import android.widget.RelativeLayout;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.annotation.NonNull;
    import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
    import com.example.cegeproommatefinder.gagan.ModelPost;

    import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{


    private ArrayList<ModelPost> arrayList;
    private Context context;
    private OnPostListner constructOnPostListner;


    public RecyclerAdapter (ArrayList<ModelPost> arrayList, Context context, OnPostListner onPostListner) {
        this.arrayList = arrayList;
        this.context = context;
        this.constructOnPostListner = onPostListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem,parent,false);

        final ViewHolder viewHolder = new ViewHolder(view, constructOnPostListner);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).asBitmap().load(arrayList.get(position).getPostImage()).into(holder.imgv);
        holder.txt.setText(arrayList.get(position).getPostTitle());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();

            }
        });

    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void setOnClickListner(View.OnClickListener onClickListener) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
          ImageView imgv;
          TextView txt;
          RelativeLayout relativeLayout;
          OnPostListner onPostListner;


        public ViewHolder(@NonNull View itemView, OnPostListner onPostListner) {
            super(itemView);

            imgv = itemView.findViewById(R.id.PostImage);
            txt = itemView.findViewById(R.id.PostTitle);
            this.onPostListner = onPostListner;

            relativeLayout = itemView.findViewById(R.id.PostRelativeLayout);

            itemView.setTag(this);
            itemView.setOnClickListener(this::onClick);


        }

        @Override
        public void onClick(View v) {
            onPostListner.onPostClick(getAdapterPosition());
        }
    }

    public interface OnPostListner {
        void onPostClick(int position);
    }
}
