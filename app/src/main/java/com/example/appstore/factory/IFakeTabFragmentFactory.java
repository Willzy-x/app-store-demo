package com.example.appstore.factory;

import android.support.v4.app.Fragment;

import java.util.List;

public interface IFakeTabFragmentFactory {

    List<String> getTabTitle();

    List<Fragment> getTabFragmentList();

}
