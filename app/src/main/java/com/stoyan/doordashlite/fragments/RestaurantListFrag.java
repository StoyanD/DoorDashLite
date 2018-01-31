package com.stoyan.doordashlite.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class RestaurantListFrag extends RxBaseFragment {
    @Inject
    RestaurantsInterface api;

    FragmentRestaurantListBinding binding;

    public static RestaurantListFrag newInstance() {
        return new RestaurantListFrag();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//List<RestaurantApi>
        DoorDashApplication.appComponent.inject(this);
//        subscriptions.add(api.getRestaurants("37.422740", "-122.139956").subscribe());
//        Subscription sub = api.getRestaurants("37.422740", "-122.139956")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<List<RestaurantApi>>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(List<RestaurantApi> restaurantApis) {
//
//                    }
//                });
//        subscriptions.add(sub);
        api.getRestaurants("37.422740", "-122.139956").enqueue(new Callback<List<RestaurantApi>>() {
            @Override
            public void onResponse(Call<List<RestaurantApi>> call, Response<List<RestaurantApi>> response) {
                initAdapter(response.body());
            }

            @Override
            public void onFailure(Call<List<RestaurantApi>> call, Throwable t) {

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
            binding.restaurantRv.setAdapter(new RestaurantAdapter(restaurantApiList));
        }
    }

}
