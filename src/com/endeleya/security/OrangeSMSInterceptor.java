/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeleya.security;

import com.endeleya.OrangeSMSFactory;
import com.endeleya.util.Token;
import com.endeleya.auth.OrangeSMSAuth;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import retrofit2.Call;

/**
 *
 * @author eroot
 */
public class OrangeSMSInterceptor implements Interceptor {
    private String current_access_token;
    public OrangeSMSInterceptor(String current_access_token) {
        this.current_access_token = current_access_token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request req = chain.request();
        Builder b = req.newBuilder();
        this.setHeader(b, current_access_token);
        req = b.build();
        Response resp = chain.proceed(req);
        if (resp.code() == 401) {
            //refresh
            OrangeSMSAuth API = (OrangeSMSAuth) OrangeSMSFactory.getRefreshInstance().create(OrangeSMSAuth.class);
            Call<Token> rToken = API.refreshAccessToken("client_credentials");
            retrofit2.Response<Token> rsp = rToken.execute();
            if (rsp.isSuccessful()) {
                Token t = rsp.body();
                this.current_access_token=t.getAccess_token();
                this.setHeader(b, this.current_access_token);
                System.out.println("Le token recu est = " + t.getAccess_token());
                req = b.build();
                resp.close();
                resp = chain.proceed(req);
            }

        }
        return resp;
    }

    public void setHeader(Builder builder, String token) {
        if (token != null) {
            builder.header("Authorization", String.format("Bearer %s", token));
        }

    }
}
