package com.example.appstore.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appstore.MainActivity;
import com.example.appstore.R;
import com.example.appstore.adapter.ContentPagerAdapter;

import java.util.List;

public class GameFragment extends Fragment {

    private View view;

    private TabLayout mTabCategory;
    private ViewPager mContentVp;

    private List<String> tabCategoryTitles = MainActivity.FAKE_TAB_FRAGMENT_FACTORY.getTabTitle();
    private List<Fragment> tabCategoryFragments = MainActivity.FAKE_TAB_FRAGMENT_FACTORY.getTabFragmentList();

    private void initCategoryTab() {
        this.mTabCategory.setTabMode(TabLayout.MODE_SCROLLABLE);
        ViewCompat.setElevation(this.mTabCategory, 10);
        this.mTabCategory.setupWithViewPager(this.mContentVp);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.game_frag, container, false);

        assert container != null;

        this.mTabCategory = this.view.findViewById(R.id.tab_category);
        this.mContentVp = this.view.findViewById(R.id.vp_content);

        initCategoryTab();

        ContentPagerAdapter categoryContentAdapter = new ContentPagerAdapter(
                getActivity().getSupportFragmentManager(), this.tabCategoryTitles, this.tabCategoryFragments);
        this.mContentVp.setAdapter(categoryContentAdapter);

        return view;
    }


}
