package com.example.chat.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chat.R;
import com.example.chat.model.Message;

import java.util.List;


public class AdapterMessage extends RecyclerView.Adapter<AdapterMessage.MessageHolder> {

    List<Message> listMessage;

    public AdapterMessage(List<Message> listMessage)
    {
        this.listMessage = listMessage;
    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MessageHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {
       holder.bind(listMessage.get(position));
    }

    @Override
    public int getItemCount() {
        return listMessage.size();
    }

    class MessageHolder extends RecyclerView.ViewHolder
    {
        private TextView message;

        MessageHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.message);
        }

        void bind(Message msg) {
            message.setText(msg.getText());
        }
    }
}
