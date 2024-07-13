package com.example.a2024b_integrative_client.api;


import com.example.a2024b_integrative_client.model.object.ObjectBoundary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ObjectApi {

    @POST("superapp/objects")
    Call<ObjectBoundary> createObject(@Body ObjectBoundary objectBoundary);

    @GET("/superapp/objects")
    Call<List<ObjectBoundary>> GetAllObjects(@Query("userSuperapp") String superapp,
                                                            @Query("email") String email,
                                                            @Query("size") int size,
                                                            @Query("page") int page);

    @GET("/superapp/objects/search/byType/{type}")
    Call<List<ObjectBoundary>> searchObjectsByType(@Path("type") String type,
                                               @Query("userSuperapp") String superapp,
                                               @Query("userEmail") String email,
                                               @Query("size") int size,
                                               @Query("page") int page);

    @GET("/superapp/objects/search/byAlias/{alias}")
    Call<List<ObjectBoundary>> searchObjectsByExactAlias(@Path("alias") String alias,
                                                   @Query("userSuperapp") String superapp,
                                                   @Query("userEmail") String email,
                                                   @Query("size") int size,
                                                   @Query("page") int page);

    @GET("/superapp/objects/search/byAliasPattern/{pattern}")
    Call<List<ObjectBoundary>> searchObjectsByAliasPattern(@Path("lat") double lat,
                                                           @Path("lng") double lng,
                                                           @Path("distance") double distance,
                                                         @Query("distanceUnits") String distanceUnits,
                                                         @Query("userSuperapp") String superapp,
                                                         @Query("userEmail") String email,
                                                         @Query("size") int size,
                                                         @Query("page") int page);

    @GET("/superapp/objects/search/byLocation/{lat}/{lng}/{distance}")
    Call<List<ObjectBoundary>> getObjectsInRadius(@Path("pattern") String pattern,
                                                           @Query("userSuperapp") String superapp,
                                                           @Query("userEmail") String email,
                                                           @Query("size") int size,
                                                           @Query("page") int page);

    @PUT("/superapp/objects/{superapp}/{internalObjectId}?userSuperapp={userSuperapp}&userEmail={email}")
    void updateObject(@Path("superapp") String superapp,
                      @Path("internalObjectId") String id,
                      @Path("userSuperapp") String userSuperapp,
                      @Path("email") String email,
                      @Body ObjectBoundary objectBoundary);

    @GET("/superapp/objects/{superapp}/{internalObjectId}?userSuperapp={userSuperapp}&userEmail={email}")
    Call<ObjectBoundary> getSpecificObject(@Path("superapp") String superapp,
                                           @Path("internalObjectId") String id,
                                           @Path("userSuperapp") String userSuperapp,
                                           @Path("email") String email);




}


