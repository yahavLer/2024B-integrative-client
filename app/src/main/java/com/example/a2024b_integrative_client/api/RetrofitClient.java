package com.example.a2024b_integrative_client.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static MiniAppCommandApi miniAppCommandApi = null;
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "http://192.168.1.174:8085/";
//    private static final String BASE_URL = "http://192.168.1.154:8085/";
//        private static final String BASE_URL = "http://192.168.204.1:8085/";
    private RetrofitClient() {}// Private constructor to prevent instantiation from outside


    public static synchronized Retrofit getInstance() {
        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

    // יצירת אובייקט של MiniAppCommandApi
    public static synchronized MiniAppCommandApi getMiniAppCommandApi() {
        if (miniAppCommandApi == null) {
            miniAppCommandApi = getInstance().create(MiniAppCommandApi.class);
        }
        return miniAppCommandApi;
    }
}