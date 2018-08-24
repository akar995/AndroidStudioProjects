package com.example.avraz.tourguideapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.avraz.tourguideapp.Places;
import com.example.avraz.tourguideapp.PlacesAdapter;
import com.example.avraz.tourguideapp.R;

import java.util.ArrayList;

public class HotelsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View a = inflater.inflate(R.layout.fragment_hotels, container, false);
        ListView listView = a.findViewById(R.id.hotel_root_view);
        ArrayList<Places> places = new ArrayList<>();
        places.add(new Places(R.drawable.divan_hotel, getString(R.string.divan_title), getString(R.string.divan_paragraph) , getString(R.string.divan_address)));
        places.add(new Places(R.drawable.grandmelleniumm_hotel, getString(R.string.grandmellenium_title), getString(R.string.grandmellenium_paragraph), getString(R.string.grandmellenium_address)));
        places.add(new Places(R.drawable.rixos_hotel, getString(R.string.rixos_title), getString(R.string.rixos_paragraph), getString(R.string.rixos_address)));
        PlacesAdapter adapter = new PlacesAdapter(getActivity().getApplicationContext(), R.layout.list_item, places);
        listView.setAdapter(adapter);
        return a;
        // Inflate the layout for this fragment

    }


}
