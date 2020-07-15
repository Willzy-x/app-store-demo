package com.example.appstore.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appstore.MainActivity;
import com.example.appstore.R;
import com.example.appstore.model.AppSlide;

import java.util.ArrayList;
import java.util.List;

public class AppSlideAdapter extends RecyclerView.Adapter<AppSlideAdapter.ViewHolder> {

    private List<AppSlide> appSlideList;

    public AppSlideAdapter() {
        this.appSlideList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            this.appSlideList.add(MainActivity.FAKE_APP_DATA_FACTORY.getClonedSingleFakeAppSlide());
        }
    }

    public void setAppSlideList(List<AppSlide> appSlideList) {
        this.appSlideList = appSlideList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View appSlideView;
        RecyclerView appSlides;
        TextView slideTitle;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.appSlideView = itemView;
            this.appSlides = itemView.findViewById(R.id.app_title_recycle_view);
            this.slideTitle = itemView.findViewById(R.id.slide_intro);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.app_item_frag, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        AppSlide appSlide = appSlideList.get(i);
        viewHolder.slideTitle.setText(appSlide.getSlideTitle());
        LinearLayoutManager layoutManager = new LinearLayoutManager(viewHolder.appSlideView.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        viewHolder.appSlides.setAdapter(new AppAdapter(appSlide.getAppSlide()));
        viewHolder.appSlides.setLayoutManager(layoutManager);
    }

    @Override
    public int getItemCount() {
        return this.appSlideList.size();
    }
}
