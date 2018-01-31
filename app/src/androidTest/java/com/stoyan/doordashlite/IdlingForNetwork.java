package com.stoyan.doordashlite;

import android.support.test.espresso.IdlingResource;

import com.stoyan.doordashlite.fragments.RestaurantListFrag;

/**
 * Created by stoyan on 1/30/18.
 */

public class IdlingForNetwork implements IdlingResource {
    private MainActivity activity;
    private ResourceCallback callback;
    private RestaurantListFrag restaurantListFrag;
    public IdlingForNetwork(MainActivity activity) {
        this.activity = activity;
        restaurantListFrag = (RestaurantListFrag) activity.getFragmentManager().findFragmentByTag(RestaurantListFrag.class.getSimpleName());
    }

    @Override
    public String getName() {
        return "IdlingForNetwork";
    }

    @Override
    public boolean isIdleNow() {
        if(callback != null && restaurantListFrag != null && restaurantListFrag.syncFinished ){
            callback.onTransitionToIdle();
            return false;
        }

        return true;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
        this.callback = resourceCallback;
    }
}
