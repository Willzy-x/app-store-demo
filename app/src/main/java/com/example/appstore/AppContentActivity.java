package com.example.appstore;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.appstore.fragment.AppContentFragment;

public class AppContentActivity extends AppCompatActivity {

    public static void actionStart(Context context,
                                   int appImage, String appTitle, int appSize) {
        Intent intent = new Intent(context, AppContentActivity.class);
        intent.putExtra("app_image", appImage);
        intent.putExtra("app_title", appTitle);
        intent.putExtra("app_size", appSize);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_content);

        int appImage = getIntent().getIntExtra("app_image", R.drawable.ak);
        String appTitle = getIntent().getStringExtra("app_title");
        int appSize = getIntent().getIntExtra("app_size",100);

        AppContentFragment appContentFragment = (AppContentFragment)
                getSupportFragmentManager().findFragmentById(R.id.app_content_fragment);
        assert appContentFragment != null;
        appContentFragment.refresh(appImage, appTitle, appSize);
    }
}