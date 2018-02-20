package com.example.rakesh.onlyretrofitsampleproject.ui;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rakesh.onlyretrofitsampleproject.R;

public class MainActivity extends AppCompatActivity {

    private Button mDownloadNetworkImageClickBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDownloadNetworkImageClickBtn = (Button)findViewById(R.id.button);


        mDownloadNetworkImageClickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDownloadNetworkImageClickBtn.setVisibility(View.GONE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,new RetrofitImageDownloadFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }
}
