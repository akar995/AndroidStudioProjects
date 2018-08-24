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

public class CitySidesFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_city_sides, container, false);
        ListView listView = v.findViewById(R.id.city_sides_list_view);
        ArrayList<Places> places = new ArrayList<>();
        places.add(new Places(R.drawable.amedi_cityside, getString(R.string.amedi_title), getString(R.string.amedi_paragraph), getString(R.string.amedi_address)));
        places.add(new Places(R.drawable.duhokdamm_cityside, getString(R.string.duhokdam_title), getString(R.string.duhokdam_cityside), getString(R.string.duhokdam_address)));
        places.add(new Places(R.drawable.galisherana_cityside, getString(R.string.galisherana_title), getString(R.string.galisherana_paragraph), getString(R.string.galisherana_address)));
        PlacesAdapter adapter = new PlacesAdapter(getActivity().getApplicationContext(), R.layout.list_item, places);
        listView.setAdapter(adapter);
        return v;
    }


}
