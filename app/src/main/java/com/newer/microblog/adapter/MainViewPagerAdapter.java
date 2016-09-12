package com.newer.microblog.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.newer.microblog.R;
import com.newer.microblog.fragment.FragmentFactory;

/**
 * Created by Chalmers on 2016-09-11 23:28.
 * email:qxinhai@yeah.net
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter {

    String[] mTitles;

    public MainViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mTitles = context.getResources().getStringArray(R.array.main_fragments_name);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.getInstance(position);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
