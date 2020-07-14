package com.example.appstore.fragment;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appstore.R;

public class AppContentFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.app_content_frag, container, false);
        return this.view;
    }

    public void refresh(int appImage, String appTitle, int appSize) {
        ImageView appImageView = this.view.findViewById(R.id.app_image);
        TextView appTitleView = this.view.findViewById(R.id.app_title);
        TextView appSizeView = this.view.findViewById(R.id.app_size);

        appImageView.setImageResource(appImage);
        appTitleView.setText(appTitle);
        appSizeView.setText(String.valueOf((double) appSize / 100.0) + " MB");
    }
}
