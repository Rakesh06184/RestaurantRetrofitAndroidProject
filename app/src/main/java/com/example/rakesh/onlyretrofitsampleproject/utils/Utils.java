package com.example.rakesh.onlyretrofitsampleproject.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class Utils {

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
