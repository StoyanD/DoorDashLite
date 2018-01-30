package com.stoyan.doordashlite.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stoyan.doordashlite.adapters.RestaurantAdapter;
import com.stoyan.doordashlite.databinding.FragmentRestaurantListBinding;

/**
 * Created by stoyan on 1/30/18.
 */

public class RestaurantListFrag extends RxBaseFragment {

    FragmentRestaurantListBinding binding;

    public static RestaurantListFrag newInstance() {
        return new RestaurantListFrag();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rv = binding.restaurantRv;
        rv.setHasFixedSize(true);
        LinearLayoutManager manager  = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(manager);
        initAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentRestaurantListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    private void initAdapter() {
        if (binding.restaurantRv.getAdapter() == null) {
            binding.restaurantRv.setAdapter(new RestaurantAdapter());
        }
    }

}
