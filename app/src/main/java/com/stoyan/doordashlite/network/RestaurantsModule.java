package com.stoyan.doordashlite.network;

import com.stoyan.doordashlite.network.interfaces.RestaurantsInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by stoyan on 1/30/18.
 */
@Module
public class RestaurantsModule {

    @Provides
    @Singleton
    public RestaurantsInterface provideRestaurantsInterface(Retrofit retrofit){
        return retrofit.create(RestaurantsInterface.class);
    }
}
