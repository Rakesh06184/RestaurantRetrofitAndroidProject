package com.example.rakesh.onlyretrofitsampleproject.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rakesh.onlyretrofitsampleproject.R;
import com.example.rakesh.onlyretrofitsampleproject.dto.restaurant.RestaurantResponse;

import java.util.List;


public class RetrofitImageAdapter extends RecyclerView.Adapter<RetrofitImageAdapter.ViewHolder> {

    private List<RestaurantResponse> mResponse;
    private Context mContext;

    public RetrofitImageAdapter(Context context, List<RestaurantResponse> imageResponses) {
        mResponse = imageResponses;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.restaurant_gallery_row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(holder.mFilmName.getContext(),3);
        holder.mRecyclerView.setLayoutManager(layoutManager);
        holder.mFilmName.setText(mResponse.get(0).gallery.get(position).albumName);

        RestaurantGalleryAdapter retrofitImageAdapter = new RestaurantGalleryAdapter(mContext, mResponse,position);
        holder.mRecyclerView.setAdapter(retrofitImageAdapter);
        retrofitImageAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mResponse.get(0).gallery.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mFilmName;
        private RecyclerView mRecyclerView;

        public ViewHolder(View view) {
            super(view);
            mFilmName = (TextView) view.findViewById(R.id.menu_details);
            mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        }
    }
}
