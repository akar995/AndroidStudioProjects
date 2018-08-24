package com.example.oliver.tourguide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurants, container, false);
        ListView restaFragment = view.findViewById(R.id.resta_fragemnt);
        ArrayList<RestaurantInfo> restaurantInfos;
        restaurantInfos = new ArrayList<>();
        restaurantInfos.add(new RestaurantInfo(getString(R.string.abu_shahab), getString(R.string.abu_shahab_phone), getString(R.string.abu_shahab_location), R.drawable.abu_shahab));
        restaurantInfos.add(new RestaurantInfo(getString(R.string.ice_land), getString(R.string.ice_land_phone), getString(R.string.ice_land_location), R.drawable.ice_land));
        restaurantInfos.add(new RestaurantInfo(getString(R.string.bees), getString(R.string.bees_phone), getString(R.string.bees_location), R.drawable.bees));
        restaurantInfos.add(new RestaurantInfo(getString(R.string.today),getString(R.string.today_phone), getString(R.string.erbil), R.drawable.today));
        RestaurantAdapter fadapter = new RestaurantAdapter(getContext(), restaurantInfos);
        restaFragment.setAdapter(fadapter);
        return view;
    }
}
