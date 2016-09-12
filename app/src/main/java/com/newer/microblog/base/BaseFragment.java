package com.newer.microblog.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Chalmers on 2016-09-11 18:11.
 * email:qxinhai@yeah.net
 */

/**
 * Fragment的基类
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getLayoutResource(),container,false);

        ButterKnife.bind(this,view);

        return view;
    }

    /** 返回布局id */
    public abstract int getLayoutResource();
}
