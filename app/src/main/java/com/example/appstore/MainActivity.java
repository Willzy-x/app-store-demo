package com.example.appstore;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.appstore.adapter.ContentPagerAdapter;
import com.example.appstore.fragment.AppSlideFragment;
import com.example.appstore.fragment.AppTitleFragment;
import com.example.appstore.fragment.GameFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private DrawerLayout mDrawerLayout;
    private TabLayout mTabCategory;
    private ViewPager mContentVp;
    private ContentPagerAdapter categoryContentAdapter;

    private List<String> tabCategoryTitles;
    private List<Fragment> tabCategoryFragments;

    private AppTitleFragment anotherFragment;
    private GameFragment gameFragment;


//    private void initCategoryTab() {
//        this.mTabCategory.setTabMode(TabLayout.MODE_SCROLLABLE);
//        ViewCompat.setElevation(this.mTabCategory, 10);
//        this.mTabCategory.setupWithViewPager(this.mContentVp);
//
//    }
//
//    private void initCategoryTabContents() {
//        this.tabCategoryTitles = new ArrayList<>();
//        this.tabCategoryTitles.add("Recommendation");
//        this.tabCategoryTitles.add("Ranking");
//        this.tabCategoryTitles.add("Paid");
//        this.tabCategoryTitles.add("Arcade");
//        this.tabCategoryTitles.add("Today");
//        this.tabCategoryTitles.add("More");
//
//        this.tabCategoryFragments = new ArrayList<>();
//        for (String s : this.tabCategoryTitles) {
//            this.tabCategoryFragments.add(new AppSlideFragment());
//        }
//
//        this.categoryContentAdapter = new ContentPagerAdapter(
//                getSupportFragmentManager(), this.tabCategoryTitles, this.tabCategoryFragments);
//        this.mContentVp.setAdapter(this.categoryContentAdapter);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Navigation init
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_user);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.nav_user:
                        Toast.makeText(MainActivity.this, "You clicked user", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_order:
                        Toast.makeText(MainActivity.this, "You clicked order", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_info:
                        Toast.makeText(MainActivity.this, "You clicked info", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_setting:
                        Toast.makeText(MainActivity.this, "You clicked setting", Toast.LENGTH_SHORT).show();
                        break;
                }

                mDrawerLayout.closeDrawers();
                return true;
            }
        });

//        this.mTabCategory = findViewById(R.id.tab_category);
//
//        this.mContentVp = findViewById(R.id.vp_content);

//        initCategoryTab();
//        initCategoryTabContents();

        this.anotherFragment = new AppTitleFragment();
        this.gameFragment = new GameFragment();

        replaceFragment(this.gameFragment);

        BottomNavigationView bottomTab = (BottomNavigationView) findViewById(R.id.bottom_tab);
        bottomTab.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_game:
                        replaceFragment(MainActivity.this.gameFragment);
                        break;

                    case R.id.menu_application:
                        replaceFragment(MainActivity.this.anotherFragment);
                        break;

                    default:
                }
                return true;
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.overall_layout, fragment);
        transaction.addToBackStack(null);
//        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            // 打开抽屉导航栏
            case R.id.nav_list:
                Toast.makeText(this, "You clicked Nav", Toast.LENGTH_SHORT).show();
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;

            case R.id.search_item:
                Toast.makeText(this, "You clicked Search", Toast.LENGTH_SHORT).show();
                break;

            default:
        }
        return true;
    }

//    class ContentPagerAdapter extends FragmentPagerAdapter {
//
//        public ContentPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int i) {
//            return tabCategoryFragments.get(i);
//        }
//
//        @Override
//        public int getCount() {
//            return tabCategoryTitles.size();
//        }
//
//        @Nullable
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return tabCategoryTitles.get(position);
//        }
//    }

}