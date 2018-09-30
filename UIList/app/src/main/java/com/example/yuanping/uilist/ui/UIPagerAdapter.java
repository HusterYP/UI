package com.example.yuanping.uilist.ui;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @created by PingYuan at 9/29/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class UIPagerAdapter extends FragmentPagerAdapter {
    private List<String> titles;
    private List<Fragment> mFragments;

    public UIPagerAdapter(List<String> titles, List<Fragment> fragments, FragmentManager
            fragmentManager) {
        super(fragmentManager);
        this.titles = titles;
        this.mFragments = fragments;
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }
}
