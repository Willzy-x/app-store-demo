package com.example.appstore.model;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class App implements Cloneable, Serializable {
    private String appTitle;
    private int imageId;
    private int appSize;

    public App(String appTitle, int imageId, int appSize) {
        this.appTitle = appTitle;
        this.imageId = imageId;
        this.appSize = appSize;
    }

    @NonNull
    @Override
    public App clone() throws CloneNotSupportedException {
            return (App) super.clone();
    }

    public String getAppTitle() {
        return appTitle;
    }

    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getAppSize() {
        return appSize;
    }

    public void setAppSize(int appSize) {
        this.appSize = appSize;
    }
}
