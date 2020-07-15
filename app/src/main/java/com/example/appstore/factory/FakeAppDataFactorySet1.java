package com.example.appstore.factory;

import com.example.appstore.R;
import com.example.appstore.model.App;
import com.example.appstore.model.AppSlide;
import com.example.appstore.util.DeepCopy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FakeAppDataFactorySet1 implements IFakeAppDataFactory {

    private App appData;
    private List<App> appDataList;
    private AppSlide appSlide;
    
    @Override
    public App getSingleFakeAppData() {
        if (this.appData == null) {
            this.appData = new App("Sword", R.drawable.sword, 12312);
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
                    "Sword", R.drawable.sword, 112
            ));
            this.appDataList.add(new App(
                    "Armor", R.drawable.armor, 321
            ));
            this.appDataList.add(new App(
                    "AK-47", R.drawable.ak, 4352
            ));
            this.appDataList.add(new App(
                    "Backpack", R.drawable.backpack, 131
            ));
            this.appDataList.add(new App(
                    "Pistol", R.drawable.pistol, 123
            ));
            this.appDataList.add(new App(
                    "Shield", R.drawable.shield, 1352
            ));
            this.appDataList.add(new App(
                    "Rocket", R.drawable.rocket, 900
            ));
            this.appDataList.add(new App(
                    "Axe", R.drawable.axe, 1231
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
            this.appSlide = new AppSlide("Cool", this.getFakeAppDataList());
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
