package com.stoyan.doordashlite.network.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by stoyan on 1/30/18.
 */

public class RestaurantApi {

    public int id;
    public String name;
    public String description;
    @SerializedName("cover_img_url")
    public String coverImgUrl;
    public String status;
    @SerializedName("delivery_fee")
    public String deliveryFee;

}
