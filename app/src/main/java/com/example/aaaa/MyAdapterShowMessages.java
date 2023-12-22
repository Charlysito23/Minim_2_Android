package com.example.aaaa;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aaaa.models.Message;

import java.util.List;

public class MyAdapterShowMessages extends RecyclerView.Adapter<MyAdapterShowMessages.ViewHolder> {
    private List<Message> messageList;
    private static RecyclerClickViewListener listener;

    public MyAdapterShowMessages(List<Message> messageList, RecyclerClickViewListener listener) {
        this.messageList = messageList;
        this.listener = listener;
    }

    public void setMessageList(List<Message> messageList) {
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView cuerpoMensaje;

        public ViewHolder(View view) {
            super(view);
            cuerpoMensaje = view.findViewById(R.id.firstLine);
        }

        public void bind(Message msg) {
            cuerpoMensaje.setText(msg.getCuerpoMensaje());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout_show_messages, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Message msg = messageList.get(position);
        holder.bind(msg);
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}



