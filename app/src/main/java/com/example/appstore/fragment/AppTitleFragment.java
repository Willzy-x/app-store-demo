package com.example.appstore.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appstore.R;
import com.example.appstore.adapter.AppAdapter;

public class AppTitleFragment extends Fragment {

    private static final String TAG = "AppTitleFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.app_item_frag, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.app_title_recycle_view);
        TextView slideIntroView = (TextView) view.findViewById(R.id.slide_intro) ;

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        AppAdapter appAdapter = new AppAdapter();
        slideIntroView.setText(R.string.words1);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(appAdapter);
        return view;
    }



}
