package com.example.rakesh.onlyretrofitsampleproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rakesh.onlyretrofitsampleproject.R;
import com.example.rakesh.onlyretrofitsampleproject.dto.restaurant.RestaurantResponse;
import com.example.rakesh.onlyretrofitsampleproject.ui.GalleryActivity;

import java.util.List;

/**
 * Created by rakesh on 3/3/17.
 */

public class RestaurantGalleryAdapter extends RecyclerView.Adapter<RestaurantGalleryAdapter.ViewHolder> {


    private List<RestaurantResponse> mResponse;
    private Context mContext;
    private int mPosition;

    public RestaurantGalleryAdapter(Context context, List<RestaurantResponse> imageResponses, int position) {
        mResponse = imageResponses;
        mContext = context;
        mPosition = position;
    }

    @Override
    public RestaurantGalleryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.restaurant_test_row_layout, parent, false);
        return new RestaurantGalleryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RestaurantGalleryAdapter.ViewHolder holder, final int position) {
        holder.mFilmName.setText(mResponse.get(0).gallery.get(mPosition).photos.get(position).title);
        Glide.with(mContext).load(mResponse.get(0).gallery.get(mPosition).photos.get(position).url)
                .thumbnail(0.5f).centerCrop()
                .crossFade()
                .into(holder.mImageView);

        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("raka", "position " + position + "pos" + mPosition);
                Intent intent = new Intent(mContext, GalleryActivity.class);
                intent.putExtra("menuDetails", mResponse.get(0).gallery.get(mPosition).albumName);
                intent.putExtra("url", mResponse.get(0).gallery.get(mPosition).photos.get(position).url);
                intent.putExtra("title", mResponse.get(0).gallery.get(mPosition).photos.get(position).title);
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mResponse.get(0).gallery.get(mPosition).photos.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mFilmName;
        private ImageView mImageView;


        public ViewHolder(View view) {
            super(view);
            mFilmName = (TextView) view.findViewById(R.id.film_name);
            mImageView = (ImageView) view.findViewById(R.id.image_view);
        }
    }
}
