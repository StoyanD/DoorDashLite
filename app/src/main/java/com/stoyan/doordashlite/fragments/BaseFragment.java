package com.stoyan.doordashlite.fragments;

import android.app.Fragment;

/**
 * Created by stoyan on 1/30/18.
 */

public class BaseFragment extends Fragment {
    public boolean syncFinished = false;
    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
