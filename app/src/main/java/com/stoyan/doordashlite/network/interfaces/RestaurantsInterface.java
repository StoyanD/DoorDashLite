package com.stoyan.doordashlite.network.interfaces;

import com.stoyan.doordashlite.network.api.RestaurantApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by stoyan on 1/30/18.
 */

public interface RestaurantsInterface {

    @GET("restaurant/?lat={lat}&lng={lng}")
    Call<List<RestaurantApi>> getRestaurants(@Path("lat") String latitude,
                                             @Path("lng") String longitude);
}
