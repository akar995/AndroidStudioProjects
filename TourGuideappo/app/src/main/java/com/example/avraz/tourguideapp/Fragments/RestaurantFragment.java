package com.example.avraz.tourguideapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.avraz.tourguideapp.Places;
import com.example.avraz.tourguideapp.PlacesAdapter;
import com.example.avraz.tourguideapp.R;

import java.util.ArrayList;

public class RestaurantFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View a = inflater.inflate(R.layout.fragment_restaurant, container, false);
        ListView listView = a.findViewById(R.id.restaurant_list_view);
        ArrayList<Places> places = new ArrayList<>();
        places.add(new Places(R.drawable.abcc_restaurant, getString(R.string.abc_title), getString(R.string.abc_paragraph), getString(R.string.abc_address)));
        places.add(new Places(R.drawable.dawaa_restaurant, getString(R.string.dawa_title), getString(R.string.dawa_paragraph), getString(R.string.dawa_address)));
        PlacesAdapter adapter = new PlacesAdapter(getActivity().getApplicationContext(), R.layout.list_item, places);
        listView.setAdapter(adapter);
        return a;
    }


}
