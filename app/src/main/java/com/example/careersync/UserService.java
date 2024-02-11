package com.example.careersync;

import com.example.careersync.model.LoginAuth;
import com.example.careersync.model.UserT;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("login")
    Call<UserT> login(@Body LoginAuth loginAuth);
}
