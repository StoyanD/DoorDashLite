package com.stoyan.doordashlite.network.interfaces;

import com.stoyan.doordashlite.network.api.RestaurantApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by stoyan on 1/30/18.
 */

public interface RestaurantsInterface {

    @GET("restaurant/")
    Call<List<RestaurantApi>> getRestaurants(@Query("lat") String latitude,
                                             @Query("lng") String longitude);
}
