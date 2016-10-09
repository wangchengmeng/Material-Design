package com.example.sunddenfix.mddemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author wangchengmeng
 */
public class TabAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList; //fragment列表
    private List<String>   mTabTitleList;//标题

    public TabAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> tabTitleList) {
        super(fm);
        mFragmentList = fragmentList;
        mTabTitleList = tabTitleList;
    }

    @Override
    public Fragment getItem(int position) {
        if (null != mFragmentList) {
            return mFragmentList.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if (null != mFragmentList) {
            return mFragmentList.size();
        }
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (null != mTabTitleList) {
            return mTabTitleList.get(position);
        }
        return super.getPageTitle(position);
    }
}
