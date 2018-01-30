package com.stoyan.doordashlite.fragments;

import android.app.Fragment;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by stoyan on 1/30/18.
 */

public class RxBaseFragment extends Fragment {

    protected CompositeSubscription subscriptions;

    @Override
    public void onResume() {
        super.onResume();
        subscriptions = new CompositeSubscription();
    }

    @Override
    public void onPause() {
        super.onPause();
        subscriptions.clear();
    }
}
