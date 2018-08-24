package com.example.avraz.tourguideapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.avraz.tourguideapp.Fragments.CitySidesFragment;
import com.example.avraz.tourguideapp.Fragments.HotelsFragment;
import com.example.avraz.tourguideapp.Fragments.MustVisitFragment;
import com.example.avraz.tourguideapp.Fragments.RestaurantFragment;

public class PlacesPagerAdapter extends FragmentPagerAdapter {
    Context con;
    public PlacesPagerAdapter(FragmentManager fm , Context context) {
        super(fm);con=context;
    }

    @Override
    public int getCount() {
        return 4;
    }


    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new MustVisitFragment();

            case 1:
                return new RestaurantFragment();

            case 2:
               return new HotelsFragment();

            case 3:
               return   new CitySidesFragment();

        }

        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
              //  return.getString(R.string.returnOne);
               // return R.string.returnOne+"";
                return con.getResources().getString(R.string.returnOne);
            case 1:
//                return.getString(R.string.returnTwo);
                return con.getResources().getString(R.string.returnTwo);
            case 2:
               // return.getString(R.string.returnThree);
                return con.getResources().getString(R.string.returnThree);
            case 3:
//                return.getString(R.string.returnFour);
                return con.getResources().getString(R.string.returnFour);
        }
//        return.getString(R.string.returnNull);
        return "";
    }
}
