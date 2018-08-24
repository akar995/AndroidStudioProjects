package com.example.oliver.tourguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        fragments = new ArrayList<>();
        fragments.add(new IntroFragment());
        fragments.add(new HotelFragment());
        fragments.add(new ParksFragment());
        fragments.add(new RestaurantsFragment());
        String[] titles = {getString(R.string.intro), getString(R.string.hotel), getString(R.string.parks), getString(R.string.resta)};
        FragmentPagerAdapter adapter = new FragmentPageAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);


    }

}
