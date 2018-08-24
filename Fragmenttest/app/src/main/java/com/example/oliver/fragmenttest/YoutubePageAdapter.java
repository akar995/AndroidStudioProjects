package com.example.oliver.fragmenttest;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


public class YoutubePageAdapter extends FragmentPagerAdapter
{
    ArrayList<Fragment> fragments;

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).g
    }

    public YoutubePageAdapter(FragmentManager fm , ArrayList<Fragment> fragments) {
        super(fm);
//        fragments.add(new HomeFragment());
//        fragments.add(new TrendingFragment());
//        fragments.add(new InboxFragment());
//        fragments.add(new LibraryFragment());
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int i) {
//        switch(i){
//            case 0:return new HomeFragment();
//            case 1:return new TrendingFragment();
//            case 2:return new InboxFragment();
//            case 3:return new LibraryFragment();
//
//        }
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
