/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeleya;

import com.endeleya.security.OrangeSMSInterceptor;
import com.endeleya.security.TLSSocketFactory;
import com.endeleye.core.OrangeSMS;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Connection;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author eroot
 */
public class OrangeSMSFactory {

    public static final String BASE_URL = "https://api.orange.com/smsmessaging/v1/";
    public static final String BASE_URL_RENEW = "https://api.orange.com/oauth/v3/";

    private static Retrofit getRetrofitInstance(String token) {

        Builder builder = new Builder();
        builder.connectTimeout(1000, TimeUnit.SECONDS);
        builder.writeTimeout(1000, TimeUnit.SECONDS);
        builder.readTimeout(1000, TimeUnit.SECONDS);
        if (token != null) {
            OrangeSMSInterceptor intercep = new OrangeSMSInterceptor(token);
            builder.addInterceptor(intercep);
        }
        try {
            TLSSocketFactory ssl = new TLSSocketFactory();
            if (ssl.getTrustManager() != null) {
                builder.sslSocketFactory(ssl, ssl.getTrustManager());
            }

        } catch (KeyStoreException ex) {
            Logger.getLogger(OrangeSMSFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(OrangeSMSFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(OrangeSMSFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        OkHttpClient clt = builder.build();
        Retrofit ret = new Retrofit.Builder().baseUrl(BASE_URL).client(clt)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return ret;
    }

    public static OrangeSMS createOrangeSMSService(String token) {
        return (OrangeSMS) getRetrofitInstance(token).create(OrangeSMS.class);
    }

    public static Retrofit getRefreshInstance() {
        try {
            Builder bh = new Builder();
            TLSSocketFactory ssl = new TLSSocketFactory();
            if (ssl.getTrustManager() != null) {
                bh.sslSocketFactory(ssl, ssl.getTrustManager());
            }
            Retrofit ret = new Retrofit.Builder().baseUrl(BASE_URL_RENEW)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(bh.build()).build();
            return ret;
        } catch (KeyStoreException ex) {
            Logger.getLogger(OrangeSMSFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(OrangeSMSFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(OrangeSMSFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
