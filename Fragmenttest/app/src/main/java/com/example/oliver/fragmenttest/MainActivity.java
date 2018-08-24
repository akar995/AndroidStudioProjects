package com.example.oliver.fragmenttest;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ViewPager viewPager;
ArrayList<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.youtube_view_page);
        fragments=new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new TrendingFragment());
        fragments.add(new InboxFragment());
        fragments.add(new LibraryFragment());

        YoutubePageAdapter adapter=new YoutubePageAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
    }
}
