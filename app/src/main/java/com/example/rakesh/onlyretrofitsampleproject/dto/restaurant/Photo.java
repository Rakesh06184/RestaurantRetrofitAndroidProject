
package com.example.rakesh.onlyretrofitsampleproject.dto.restaurant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("desc")
    @Expose
    public String desc;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("thumb_url")
    @Expose
    public String thumbUrl;

}
