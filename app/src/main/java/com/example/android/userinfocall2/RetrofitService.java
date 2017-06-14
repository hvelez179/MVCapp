package com.example.android.userinfocall2;


import com.example.android.userinfocall2.entities.User;
import com.example.android.userinfocall2.entities.UserData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("api/?results=20")
    Call<UserData> getRandomUser();
}
