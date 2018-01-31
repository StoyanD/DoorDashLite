package com.stoyan.doordashlite.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.stoyan.doordashlite.app.DoorDashApplication;
import com.stoyan.doordashlite.databinding.ViewRestaurantListItemBinding;
import com.stoyan.doordashlite.network.api.RestaurantApi;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by stoyan on 1/30/18.
 */

public class RestaurantAdapter extends  RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {
    List<RestaurantApi> restaurantApiList;

    public RestaurantAdapter(List<RestaurantApi> restaurantApiList) {
        this.restaurantApiList = restaurantApiList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        // Inflate the view for this view holder
//        View thisItemsView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_restaurant_list_item,
//                parent, false);
//        return new ViewHolder(thisItemsView);

        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        ViewRestaurantListItemBinding itemBinding =
                ViewRestaurantListItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(restaurantApiList.get(position));
    }

    @Override
    public int getItemCount() {
        return restaurantApiList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Inject
        public Context context;
        private ViewRestaurantListItemBinding mViewBinding;
        public ViewHolder(ViewRestaurantListItemBinding viewBinding) {
            super(viewBinding.getRoot());
            mViewBinding = viewBinding;
            DoorDashApplication.appComponent.inject(this);
        }

        private void bind(RestaurantApi api){
            mViewBinding.setRestaurant(api);
            Picasso.with(context).load(api.coverImgUrl).into(mViewBinding.listCoverImage);
        }
    }
}
