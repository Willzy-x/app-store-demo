package com.example.appstore.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appstore.R;
import com.example.appstore.model.App;

import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.ViewHolder>  {

    private List<App> appList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        // 动态载入视图
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        // 点击App视图，跳转
        holder.appView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                App app = appList.get(position);
                Toast.makeText(view.getContext(), "you clicked view " + app.getAppTitle(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        // 设置点击效果
        holder.appView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        view.setBackgroundColor(0x11000000);
                        return false;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        view.setBackgroundColor(0xffffffff);
                        break;
                }
                return view.onTouchEvent(motionEvent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        App app = appList.get(i);
        viewHolder.appImage.setImageResource(app.getImageId());
        viewHolder.appTitle.setText(app.getAppTitle());
        viewHolder.appSize.setText((double) app.getAppSize() / 100.0 + " MB");
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        View appView;
        ImageView appImage;
        TextView appTitle;
        TextView appSize;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.appView = itemView;
            this.appImage = itemView.findViewById(R.id.app_image);
            this.appTitle = itemView.findViewById(R.id.app_title);
            this.appSize = itemView.findViewById(R.id.app_size);
        }
    }

    public AppAdapter(List<App> appList) {
        this.appList = appList;
    }


}
