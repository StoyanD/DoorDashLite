package com.stoyan.doordashlite.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stoyan.doordashlite.R;

/**
 * Created by stoyan on 1/30/18.
 */

public class RestaurantAdapter extends  RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the view for this view holder
        View thisItemsView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_restaurant_list_item,
                parent, false);
        return new ViewHolder(thisItemsView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ViewHolder(View v) {
            super(v);
//            mTextView = v;
        }

        private void bind(){

        }
    }
}
