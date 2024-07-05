package com.example.a2024b_integrative_client.api;


import com.example.a2024b_integrative_client.model.miniappCommand.MiniAppCommandBoundary;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MiniAppCommandApi {
    @POST("/superapp/miniapp/{miniAppName}")
    Call<Object> invokeCommand(
            @Path("miniAppName") String miniAppName,
            @Query("async") boolean asyncFlag,
            @Body MiniAppCommandBoundary miniAppCommandBoundary
    );
}