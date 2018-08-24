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

public class MustVisitFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View a = inflater.inflate(R.layout.fragment_must_visit, container, false);
        ListView listView = a.findViewById(R.id.must_visit_list_view);
        ArrayList<Places> places = new ArrayList<>();
        places.add(new Places(R.drawable.erbilcitadel_mustvisit, getString(R.string.erbil_citadel), getString(R.string.erbil_citadel_paragraph), getString(R.string.citadel_address)));
        places.add(new Places(R.drawable.halgurdmountain_mustvisit, getString(R.string.halgurd_title), getString(R.string.halgurd_paragraph), getString(R.string.halgurd_mountain_address)));
        places.add(new Places(R.drawable.mountkorek_mustvisit, getString(R.string.korek_title), getString(R.string.korek_paragraph), getString(R.string.korek_address)));

        PlacesAdapter adapter = new PlacesAdapter(getActivity().getApplicationContext(), R.layout.list_item, places);
        listView.setAdapter(adapter);
        return a;
    }


}
