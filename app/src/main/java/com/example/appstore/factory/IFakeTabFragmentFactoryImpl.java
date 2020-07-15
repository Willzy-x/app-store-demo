package com.example.appstore.factory;

import android.support.v4.app.Fragment;

import com.example.appstore.fragment.AppSlideFragment;

import java.util.ArrayList;
import java.util.List;

public class IFakeTabFragmentFactoryImpl implements IFakeTabFragmentFactory {
    private List<String> tabTitleList;
    private List<Fragment> tabFragmentList;

    @Override
    public List<String> getTabTitle() {
        if (this.tabTitleList == null) {
            this.tabTitleList = new ArrayList<>();
            this.tabTitleList.add("Recommendation");
            this.tabTitleList.add("Ranking");
            this.tabTitleList.add("Paid");
            this.tabTitleList.add("Arcade");
            this.tabTitleList.add("Today");
            this.tabTitleList.add("More");
        }
        return this.tabTitleList;
    }

    @Override
    public List<Fragment> getTabFragmentList() {
        if (this.tabFragmentList == null) {
            this.tabFragmentList = new ArrayList<>();
            for (String s : this.tabTitleList) {
                this.tabFragmentList.add(new AppSlideFragment());
            }
        }
        return this.tabFragmentList;
    }
}
