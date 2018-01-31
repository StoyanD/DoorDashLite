package com.stoyan.doordashlite.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stoyan.doordashlite.adapters.RestaurantAdapter;
import com.stoyan.doordashlite.app.DoorDashApplication;
import com.stoyan.doordashlite.databinding.FragmentRestaurantListBinding;
import com.stoyan.doordashlite.network.api.RestaurantApi;
import com.stoyan.doordashlite.network.interfaces.RestaurantsInterface;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by stoyan on 1/30/18.
 */

public class RestaurantListFrag extends BaseFragment {
    private static final String TAG = RestaurantListFrag.class.getSimpleName();
    @Inject
    RestaurantsInterface api;

    FragmentRestaurantListBinding binding;
    public RestaurantAdapter adapter;

    public static RestaurantListFrag newInstance() {
        return new RestaurantListFrag();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//List<RestaurantApi>
        DoorDashApplication.appComponent.inject(this);
        api.getRestaurants("37.422740", "-122.139956").enqueue(new Callback<List<RestaurantApi>>() {
            @Override
            public void onResponse(Call<List<RestaurantApi>> call, Response<List<RestaurantApi>> response) {
                initAdapter(response.body());

            }

            @Override
            public void onFailure(Call<List<RestaurantApi>> call, Throwable t) {
                Log.e(TAG, t.getMessage());
                syncFinished = true;
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rv = binding.restaurantRv;
        rv.setHasFixedSize(true);
        LinearLayoutManager manager  = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(manager);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentRestaurantListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    private void initAdapter(List<RestaurantApi> restaurantApiList) {
        if (binding.restaurantRv.getAdapter() == null) {
            adapter = new RestaurantAdapter(restaurantApiList);
            binding.restaurantRv.setAdapter(adapter);
        }
        syncFinished = true;
    }

    public FragmentRestaurantListBinding getViewBinding(){
        return binding;
    }


    public boolean isSyncFinished() {
        return syncFinished;
    }

}
