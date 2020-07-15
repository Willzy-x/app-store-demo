package com.example.appstore.factory;

import com.example.appstore.model.App;
import com.example.appstore.model.AppSlide;

import java.util.List;

public interface IFakeAppDataFactory {

    App getSingleFakeAppData();

    App getClonedFakeAppData();

    List<App> getFakeAppDataList();

    List<App> getClonedFakeAppDataList();

    AppSlide getSingleFakeAppSlide();

    AppSlide getClonedSingleFakeAppSlide();

}
