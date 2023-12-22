package com.example.aaaa.api;

import java.util.List;
import com.example.aaaa.models.Item;
import com.example.aaaa.models.Message;
import com.example.aaaa.models.Usuario;
import com.example.aaaa.models.LoginModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APITrappy {
        @POST("player/login")
        Call<Void> login(@Body LoginModel login);
        /*
        @POST("player/register")
        Call<Usuario> register(@Body RegisterModel registerModel);
        @POST("/dsaApp/jugador/Login")
        Call<Void> logIn(@Body LoginModel logIn);
         */
        @POST("player")
        Call<Void> comprar(@Body Item item);
        @POST("player/register")
        Call<Void> register(@Body Usuario register);
        @POST("trappy/buyItem/{idItem}/{idPlayer}")
        Call<Void> buy(@Body String idItem, String idPlayer);

        @GET("items/shop")
        Call<Item> getItems(@Body Item item);

        @GET("/player/messages")
        Call<List<Message>> getMessages();
}

