package com.example.rakesh.onlyretrofitsampleproject.retrofit;


import com.example.rakesh.onlyretrofitsampleproject.dto.restaurant.RestaurantResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitTestInterface {

    // end url for restaurant later change
  //  @GET("/4/gallery")

    //end url for rakesh later change
    @GET("/profile")
    Call<RestaurantResponse> getImageResponse();
}
