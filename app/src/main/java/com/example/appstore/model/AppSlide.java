package com.example.appstore.model;

import java.util.List;

public class AppSlide {
    private String slideTitle;
    private List<App> appSlide;

    public AppSlide(String slideTitle, List<App> appSlide) {
        this.slideTitle = slideTitle;
        this.appSlide = appSlide;
    }

    public String getSlideTitle() {
        return slideTitle;
    }

    public void setSlideTitle(String slideTitle) {
        this.slideTitle = slideTitle;
    }

    public List<App> getAppSlide() {
        return appSlide;
    }

    public void setAppSlide(List<App> appSlide) {
        this.appSlide = appSlide;
    }
}
