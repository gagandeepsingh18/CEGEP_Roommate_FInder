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
    String sender,reciever;
public AdapterChat(Context context, List<Chat> list, String userId, String postUserId)
{
    this.context=context;
    this.list=list;
    sender=userId;
    reciever=postUserId;
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
    if (sender==chat.getUserId()&&reciever==chat.postUserId){
        holder.textView1.setText(chat.getMsg());

    }
        if (reciever==chat.getUserId()&&sender==chat.postUserId){
            holder.textView2.setText(chat.getMsg());

        }

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
