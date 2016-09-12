package com.newer.microblog.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.newer.microblog.R;
import com.newer.microblog.adapter.MainViewPagerAdapter;
import com.newer.microblog.base.BaseActivity;
import com.newer.microblog.utils.GlideWithHeadPic;
import com.newer.microblog.view.HeadPicView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.tl_main_bar)
    Toolbar tlMainBar;
    @Bind(R.id.nv_main_navigation)
    NavigationView nvMainNavigation;
    @Bind(R.id.dl_main_drawer)
    DrawerLayout dlMainDrawer;
    @Bind(R.id.tl_main_tab)
    TabLayout tlMainTab;
    @Bind(R.id.vp_main_content)
    ViewPager vpMainContent;
    /**
     * 抽屉
     */
    private ActionBarDrawerToggle abdtDrawerToggle;

    @Override
    public int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    public void initListener() {
        dlMainDrawer.addDrawerListener(abdtDrawerToggle);
        nvMainNavigation.setNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }

    @Override
    public void initData() {
        //设置ToolBar
        setSupportActionBar(tlMainBar);

        //TODO 设置显示的头像

        abdtDrawerToggle = new ActionBarDrawerToggle(this, dlMainDrawer, R.string.test1, R.string.test2) {
            /*
            当抽屉打开时，会调用该方法，此时可以获得布局
             */
            @Override
            public void onDrawerOpened(View drawerView) {
                setNavigationHead(drawerView);
            }
        };
        abdtDrawerToggle.syncState();

        //设置ViewPager的显示内容
        vpMainContent.setAdapter(new MainViewPagerAdapter(this,getSupportFragmentManager()));
        tlMainTab.setupWithViewPager(vpMainContent);
    }

    /**
     * NavigationView的监听器，点击抽屉用
     */
    NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            dlMainDrawer.closeDrawers();
            return true;
        }
    };

    /**
     * 当打开抽屉时，显示上面的头像
     *
     * @param drawerView 抽屉布局
     */
    private void setNavigationHead(View drawerView) {
        //设置头像
        final HeadPicView hpvNavHeader = (HeadPicView) drawerView.findViewById(R.id.hpv_nav_header);
        GlideWithHeadPic.netGetHeadWithUrl(MainActivity.this, "http://tva1.sinaimg.cn/crop.32.0.210.210.180/6990a92djw8f7748ke2mdj207s05u74f.jpg",
                hpvNavHeader.getLayoutParams().width, hpvNavHeader.getLayoutParams().height,
                new GlideWithHeadPic.HeadCallback() {
                    @Override
                    public void doCallbackData(Bitmap bitmap) {
                        hpvNavHeader.setImageBitmap(bitmap);
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
