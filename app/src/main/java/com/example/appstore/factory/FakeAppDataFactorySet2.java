package com.example.appstore.factory;

import com.example.appstore.R;
import com.example.appstore.model.App;
import com.example.appstore.model.AppSlide;
import com.example.appstore.util.DeepCopy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FakeAppDataFactorySet2 implements IFakeAppDataFactory {

    private App appData;
    private List<App> appDataList;
    private AppSlide appSlide;
    
    @Override
    public App getSingleFakeAppData() {
        if (this.appData == null) {
            this.appData = new App("帆船", R.drawable.sailboat, 3524);
        }
        return this.appData;
    }

    @Override
    public App getClonedFakeAppData() {
        try {
            return this.getSingleFakeAppData().clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return this.getSingleFakeAppData();
        }
    }

    @Override
    public List<App> getFakeAppDataList() {
        if (this.appDataList == null) {
            this.appDataList = new ArrayList<>();

            this.appDataList.add(new App(
                    "帆船", R.drawable.sailboat, 1231
            ));

            this.appDataList.add(new App(
                    "F1赛车", R.drawable.f1, 131
            ));

            this.appDataList.add(new App(
                    "私家车", R.drawable.car,788
            ));

            this.appDataList.add(new App(
                    "双层巴士", R.drawable.doublebus, 787
            ));

            this.appDataList.add(new App(
                    "货车", R.drawable.truck,6747
            ));

            this.appDataList.add(new App(
                    "加油站", R.drawable.oilstation, 1333
            ));

            this.appDataList.add(new App(
                    "摩托车", R.drawable.motor,647
            ));

            this.appDataList.add(new App(
                    "自行车", R.drawable.bicycle, 984
            ));

            this.appDataList.add(new App(
                    "电车", R.drawable.trolley,2421
            ));
        }

        return this.appDataList;
    }

    @Override
    public List<App> getClonedFakeAppDataList() {
        List<App> res = null;
        try {
            res = DeepCopy.deepCopy(this.getFakeAppDataList());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public AppSlide getSingleFakeAppSlide() {
        if (this.appSlide == null) {
            this.appSlide = new AppSlide("Nice", this.getFakeAppDataList());
        }
        return this.appSlide;
    }

    @Override
    public AppSlide getClonedSingleFakeAppSlide() {
        try {
            return this.getSingleFakeAppSlide().clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return this.getSingleFakeAppSlide();
        }
    }
}
