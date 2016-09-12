package com.newer.microblog.fragment;

import com.newer.microblog.base.BaseFragment;

import java.util.HashMap;

/**
 * Created by Chalmers on 2016-09-11 23:22.
 * email:qxinhai@yeah.net
 */

/**
 * Fragment的工厂方法类
 */
public class FragmentFactory {

    /** 主页 */
    public static final int FRAGMENT_HOME = 0;
    /** 联系人 */
    public static final int FRAGMENT_CONTACTS = 1;
    /** 热门 */
    public static final int FRAGMENT_TOPICAL = 2;

    private static HashMap<Integer,BaseFragment> mFragments = new HashMap<>();

    /**
     * 根据传入值返回Fragment对象
     * @param type 需要的Fragment类型
     * @return Fragment对象
     */
    public static BaseFragment getInstance(int type){
        BaseFragment fragment = mFragments.get(type);
        //如果在HashMap已经存在，则直接返回
        if(fragment != null){
            return fragment;
        }

        //根据type的值，创建Fragment对象
        switch (type){
            case FRAGMENT_HOME:
                fragment = new HomeFragment();
                break;
            case FRAGMENT_CONTACTS:
                fragment = new ContactsFragment();
                break;
            case FRAGMENT_TOPICAL:
                fragment = new TopicalFragment();
                break;
        }

        //放入HashMap中，下次再加载，就不用重新创建
        mFragments.put(type,fragment);

        return fragment;
    }

}
