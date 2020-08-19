package com.example.cegeproommatefinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterChat extends RecyclerView.Adapter<AdapterChat.ChatViewHolder> {
    private Context context;
    private List<Chat> list;
public AdapterChat(Context context,List<Chat> list)
{
    this.context=context;
    this.list=list;
}

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View rootView= LayoutInflater.from(context).inflate(R.layout.userchat_item,parent,false);
        return new ChatViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
    Chat chat=list.get(position);
holder.
        textView2.setText("");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ChatViewHolder extends RecyclerView.ViewHolder{
        TextView textView1,textView2;
        public ChatViewHolder(View itemView)
        {
            super(itemView);
            textView1=itemView.findViewById(R.id.chatSender);
            textView2=itemView.findViewById(R.id.chatReciever);
        }
    }

}
