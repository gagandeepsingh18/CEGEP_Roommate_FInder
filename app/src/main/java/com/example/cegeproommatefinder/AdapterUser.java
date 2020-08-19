package com.example.cegeproommatefinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.UserViewHolder> {
private Context context;
private List<User> list;
public AdapterUser(Context context,List<User> list)
{
    this.context=context;
    this.list=list;
}
    @NonNull
    @Override
    public AdapterUser.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView= LayoutInflater.from(context).inflate(R.layout.user_list_item,parent,false);

        return new UserViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterUser.UserViewHolder holder, int position) {
User user=list.get(position);
holder.textView.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
    TextView textView;
    public UserViewHolder(View itemView){
        super(itemView);
        textView=itemView.findViewById(R.id.textView17);
    }
}

}
