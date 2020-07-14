package com.example.appstore.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appstore.R;
import com.example.appstore.adapter.AppSlideAdapter;

public class AppSlideFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.app_slide_frag, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.app_slide_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        AppSlideAdapter appSlideAdapter = new AppSlideAdapter();

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(appSlideAdapter);

        return view;
    }
}
