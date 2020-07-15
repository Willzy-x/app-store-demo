package com.example.appstore.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.io.Serializable;

public class App implements Cloneable, Parcelable {
    private String appTitle;
    private int imageId;
    private int appSize;

    public App(String appTitle, int imageId, int appSize) {
        this.appTitle = appTitle;
        this.imageId = imageId;
        this.appSize = appSize;
    }

    public App(Parcel in) {
        this.appTitle = in.readString();
        this.imageId = in.readInt();
        this.appSize = in.readInt();
    }

    public static final Creator<App> CREATOR = new Creator<App>() {
        @Override
        public App createFromParcel(Parcel in) {
            return new App(in);
        }

        @Override
        public App[] newArray(int size) {
            return new App[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appTitle);
        parcel.writeInt(this.imageId);
        parcel.writeInt(this.appSize);
    }
}
