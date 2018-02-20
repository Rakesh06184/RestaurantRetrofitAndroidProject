
package com.example.rakesh.onlyretrofitsampleproject.dto.restaurant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestaurantResponse {

    @SerializedName("error")
    @Expose
    public Boolean error;
    @SerializedName("restaurant")
    @Expose
    public Restaurant restaurant;
    @SerializedName("gallery")
    @Expose
    public List<Gallery> gallery = null;

}
