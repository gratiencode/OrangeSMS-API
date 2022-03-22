/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeleya.auth;

import com.endeleya.util.Token;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 *
 * @author eroot
 */
public interface OrangeSMSAuth {
    @FormUrlEncoded
    @POST("token")
    @Headers("Authorization:Basic TFJPZG5DSGEzU0RUTHk2VGJFVHJNazdqeXl6c2V1WDA6UVl3cUs4UnZpbUNpN0E2eA==")
    public Call<Token> refreshAccessToken(@Field("grant_type") String client_credentials);
    
}
