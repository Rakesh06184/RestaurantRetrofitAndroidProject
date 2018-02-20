
package com.example.rakesh.onlyretrofitsampleproject.dto.restaurant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Restaurant {

    @SerializedName("rest_id")
    @Expose
    public Integer restId;
    @SerializedName("name")
    @Expose
    public String name;

}
