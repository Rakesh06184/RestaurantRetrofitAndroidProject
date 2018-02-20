package com.example.rakesh.onlyretrofitsampleproject.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rakesh.onlyretrofitsampleproject.R;

public class GalleryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        TextView itemDetails = (TextView) findViewById(R.id.menu_details);
        TextView description = (TextView) findViewById(R.id.film_name);

        String menuDetails;
        String url;
        String title;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            menuDetails = extras.getString("menuDetails");
            url = extras.getString("url");
            title = extras.getString("title");

            itemDetails.setText(menuDetails);
            description.setText(title);

            Glide.with(GalleryActivity.this).load(url)
                    .thumbnail(0.5f).centerCrop()
                    .crossFade()
                    .into(imageView);
        }
    }
}
