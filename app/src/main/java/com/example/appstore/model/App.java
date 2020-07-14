package com.example.appstore.model;

public class App {
    private String appTitle;
    private int imageId;
    private int appSize;

    public App(String appTitle, int imageId, int appSize) {
        this.appTitle = appTitle;
        this.imageId = imageId;
        this.appSize = appSize;
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
