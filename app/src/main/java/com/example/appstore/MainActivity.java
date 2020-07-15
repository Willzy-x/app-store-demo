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
import com.example.appstore.factory.FakeAppDataFactorySet1;
import com.example.appstore.factory.IFakeAppDataFactory;
import com.example.appstore.factory.IFakeTabFragmentFactory;
import com.example.appstore.factory.IFakeTabFragmentFactoryImpl;
import com.example.appstore.fragment.AppSlideFragment;
import com.example.appstore.fragment.AppTitleFragment;
import com.example.appstore.fragment.GameFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";


    public static IFakeAppDataFactory FAKE_APP_DATA_FACTORY;
    public static IFakeTabFragmentFactory FAKE_TAB_FRAGMENT_FACTORY;

    static {
        FAKE_APP_DATA_FACTORY = new FakeAppDataFactorySet1();
        FAKE_TAB_FRAGMENT_FACTORY = new IFakeTabFragmentFactoryImpl();
    }

    private DrawerLayout mDrawerLayout;

    private AppTitleFragment anotherFragment;
    private GameFragment gameFragment;

    private FragmentManager mFragmentManager;
//    private Fragment preFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        this.anotherFragment = new AppTitleFragment();
        this.gameFragment = new GameFragment();

        this.mFragmentManager = getSupportFragmentManager();

        // Navigation init
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_user);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
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

        // init bottom navigation view
        BottomNavigationView bottomTab = (BottomNavigationView) findViewById(R.id.bottom_tab);
        bottomTab.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = MainActivity.this.mFragmentManager.beginTransaction();
                switch (menuItem.getItemId()) {
                    case R.id.menu_game:
                        transaction.hide(MainActivity.this.anotherFragment);
                        transaction.show(MainActivity.this.gameFragment);
                        break;

                    case R.id.menu_application:
                        transaction.hide(MainActivity.this.gameFragment);
                        if (!MainActivity.this.mFragmentManager.getFragments().contains(MainActivity.this.anotherFragment)) {
                            transaction.add(R.id.overall_layout, MainActivity.this.anotherFragment);
                        }
                        transaction.show(MainActivity.this.anotherFragment);
                        break;

                    default:
                }
                transaction.commit();
                return true;
            }
        });

        replaceFragment(this.gameFragment);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.overall_layout, fragment);
        transaction.addToBackStack(null);
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
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;

            case R.id.search_item:
                Toast.makeText(this, "You clicked Search", Toast.LENGTH_SHORT).show();
                break;

            default:
        }
        return true;
    }

}