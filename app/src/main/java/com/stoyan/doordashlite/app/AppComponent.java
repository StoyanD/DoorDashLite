package com.stoyan.doordashlite.app;

import com.stoyan.doordashlite.adapters.RestaurantAdapter;
import com.stoyan.doordashlite.fragments.RestaurantListFrag;
import com.stoyan.doordashlite.network.NetworkModule;
import com.stoyan.doordashlite.network.RestaurantsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by stoyan on 1/30/18.
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, RestaurantsModule.class})
public interface AppComponent {

    public void inject(RestaurantListFrag frag);
    public void inject(RestaurantAdapter adapter);

    void inject(RestaurantAdapter.ViewHolder viewHolder);
}
