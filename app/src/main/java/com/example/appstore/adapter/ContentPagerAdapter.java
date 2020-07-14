package com.example.appstore.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ContentPagerAdapter extends FragmentPagerAdapter {

    private List<String> titleList = null;
    private List<Fragment> fragmentList = null;

    public ContentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public ContentPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    public ContentPagerAdapter(FragmentManager fm,
                               List<String> titleList, List<Fragment> fragmentList) {
        super(fm);
        this.titleList = titleList;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int i) {
        return this.fragmentList.get(i);
    }


    @Override
    public int getCount() {
        return this.fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (this.titleList == null)
            return super.getPageTitle(position);
        else
            return this.titleList.get(position);
    }


}
