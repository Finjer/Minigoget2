package com.example.dennis.minigoget.API;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import com.example.dennis.minigoget.model.user;
import com.example.dennis.minigoget.model.gogetLogin;
import com.example.dennis.minigoget.model.retrofitModel;

/**
 * Created by park on 2016-02-25.
 */
public interface GitHubService {

    @GET("/users/{username}") Call<retrofitModel> getUser(@Path("username") String username);
    @FormUrlEncoded @GET("/api/v1/sessions") Call<gogetLogin> loginGet(@Field("email") String email,@Field("password")String password);
    @FormUrlEncoded @POST("/api/v1/sessions") Call<gogetLogin> loginPost(@Field("email") String email,@Field("password")String password);


    @POST("v1/sessions")
    Call<gogetLogin> loginGoget(@Body user user);
}
