package com.example.rakesh.onlyretrofitsampleproject.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rakesh.onlyretrofitsampleproject.R;
import com.example.rakesh.onlyretrofitsampleproject.adapter.RetrofitImageAdapter;
import com.example.rakesh.onlyretrofitsampleproject.dto.restaurant.RestaurantResponse;
import com.example.rakesh.onlyretrofitsampleproject.retrofit.RetrofitTestInterface;
import com.example.rakesh.onlyretrofitsampleproject.retrofit.ServiceGenerator;
import com.example.rakesh.onlyretrofitsampleproject.utils.Utils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;


public class RetrofitImageDownloadFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ArrayList<RestaurantResponse> mList;
    private static final String LIST_KEY = "list";

    public RetrofitImageDownloadFragment() {
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_retrofit_gson_image_download, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState == null) {

            if (Utils.isNetworkAvailable(getContext())) {
                downloadImage();
            } else {
                Toast.makeText(getActivity(), getString(R.string.network_message), Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void downloadImage() {
        mList = new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        ServiceGenerator serviceGenerator = new ServiceGenerator();

        //base url for restaurant later use
        //  serviceGenerator.apiClientBaseUrl(getResources().getString(R.string.base_restaurant_end_point));

        //base url for rakesh later change
        serviceGenerator.apiClientBaseUrl(getResources().getString(R.string.base_url_rakesh_end_point));
        RetrofitTestInterface retrofitTestInterface = serviceGenerator.createService(RetrofitTestInterface.class);
        Call<RestaurantResponse> imageResponseCall = retrofitTestInterface.getImageResponse();
        imageResponseCall.enqueue(new Callback<RestaurantResponse>() {

            @Override
            public void onResponse(retrofit2.Response<RestaurantResponse> response) {
                getImageResponse(response.body());
            }

            @Override
            public void onFailure(Throwable t) {

                Log.e("raka", "Retrofit error response     " + t.getMessage());
            }
        });
    }

    private void getImageResponse(RestaurantResponse response) {
        mList.add(response);
        RetrofitImageAdapter retrofitImageAdapter = new RetrofitImageAdapter(getActivity(), mList);
        mRecyclerView.setAdapter(retrofitImageAdapter);
        retrofitImageAdapter.notifyDataSetChanged();
    }
}

