package com.example.smartfit2.api;

import com.example.smartfit2.model.User;
import com.example.smartfit2.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("/signup")
    Call<UserResponse> signupUser(@Body User user);

    @POST("/login")
    Call<UserResponse> loginUser(@Body LoginRequest loginRequest);

    class LoginRequest {
        private String email;
        private String password;

        public LoginRequest(String email, String password) {
            this.email = email;
            this.password = password;
        }
    }
}
