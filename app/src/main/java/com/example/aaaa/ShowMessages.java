package com.example.aaaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aaaa.api.APITrappy;
import com.example.aaaa.models.Item;
import com.example.aaaa.models.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowMessages extends AppCompatActivity implements RecyclerClickViewListener {
    private APITrappy apiTrappy;

    private RecyclerView recyclerViewShowMessage;
    private MyAdapterShowMessages adapterMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String cuerpomensaje;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_messages);

        MyAdapter adapter = new MyAdapter();
        recyclerViewShowMessage.setAdapter(adapter);

        apiTrappy = com.example.aaaa.RetrofitClient.getInstance().getMyApi();
        //Recogemos los datos que nos mandan desde la función getMessage() del backend (una lista de mensajes)
        apiTrappy.getMessages().enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                if (response.isSuccessful()) {
                    List<Message> messageList = response.body();
                    adapterMsg.setMessageList(messageList);
                } else {
                    Toast.makeText(ShowMessages.this, "Failed to get messages", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                Toast.makeText(ShowMessages.this, "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

