
package com.example.rakesh.onlyretrofitsampleproject.dto.restaurant;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gallery {

    @SerializedName("album_name")
    @Expose
    public String albumName;
    @SerializedName("photos")
    @Expose
    public List<Photo> photos = null;

}
