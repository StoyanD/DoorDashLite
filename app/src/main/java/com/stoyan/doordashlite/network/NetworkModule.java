package com.stoyan.doordashlite.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by stoyan on 1/30/18.
 */
@Module
public class NetworkModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit(Converter.Factory converter) {
        return new Retrofit.Builder()
                .baseUrl(NetworkConstants.DOORDASH_BASE_URL)
                .addConverterFactory(converter)
                .build();
    }
}
