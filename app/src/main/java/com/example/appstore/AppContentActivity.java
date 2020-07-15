package com.example.appstore;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.appstore.fragment.AppContentFragment;
import com.example.appstore.model.App;

public class AppContentActivity extends AppCompatActivity {

    public static void actionStart(Context context, App app) {
        Intent intent = new Intent(context, AppContentActivity.class);
        intent.putExtra("app_data", app);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_content);

        App app = (App) getIntent().getSerializableExtra("app_data");

        AppContentFragment appContentFragment = (AppContentFragment)
                getSupportFragmentManager().findFragmentById(R.id.app_content_fragment);
        assert appContentFragment != null;
        if (app != null) {
            appContentFragment.refresh(app);
        }
    }
}