package com.example.appstore.factory;

import com.example.appstore.R;
import com.example.appstore.model.App;

import java.util.ArrayList;
import java.util.List;

public class FakeAppDataFactory {
    public static List<App> getFakeAppData_1() {
        List<App> res = new ArrayList<>();
        res.add(new App(
                "Sword", R.drawable.sword, 112
        ));
        res.add(new App(
                "Armor", R.drawable.armor, 321
        ));
        res.add(new App(
                "AK-47", R.drawable.ak, 4352
        ));
        res.add(new App(
                "Backpack", R.drawable.backpack, 131
        ));
        res.add(new App(
                "Pistol", R.drawable.pistol, 123
        ));
        res.add(new App(
                "Shield", R.drawable.shield, 1352
        ));
        res.add(new App(
                "Rocket", R.drawable.rocket, 900
        ));
        res.add(new App(
                "Axe", R.drawable.axe, 1231
        ));

        return res;
    }

    public static List<App> getFakeAppData_2() {
        List<App> res = new ArrayList<>();

        res.add(new App(
                "帆船", R.drawable.sailboat, 1231
        ));

        res.add(new App(
                "F1赛车", R.drawable.f1, 131
        ));

        res.add(new App(
                "私家车", R.drawable.car,788
        ));

        res.add(new App(
                "双层巴士", R.drawable.doublebus, 787
        ));

        res.add(new App(
                "货车", R.drawable.truck,6747
        ));

        res.add(new App(
                "加油站", R.drawable.oilstation, 1333
        ));

        res.add(new App(
                "摩托车", R.drawable.motor,647
        ));

        res.add(new App(
                "自行车", R.drawable.bicycle, 984
        ));

        res.add(new App(
                "电车", R.drawable.trolley,2421
        ));

        return res;
    }
}
