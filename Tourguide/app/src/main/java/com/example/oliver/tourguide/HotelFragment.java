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

public class HotelFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotel, container, false);
        ListView listView = view.findViewById(R.id.hotel_fragemnt);
        ArrayList<HotelInfo> hotelInfos = new ArrayList<>();
        hotelInfos.add(new HotelInfo(getString(R.string.sheraton), getString(R.string.sheraton_phone), getString(R.string.abu_shahab_location), R.drawable.sheraton));
        hotelInfos.add(new HotelInfo(getString(R.string.divan), getString(R.string.divan_phone), getString(R.string.abu_shahab_location), R.drawable.divan));
        hotelInfos.add(new HotelInfo(getString(R.string.mariana), getString(R.string.mariana_phone), getString(R.string.abu_shahab_location), R.drawable.mariana));
        hotelInfos.add(new HotelInfo(getString(R.string.roche), getString(R.string.roche_phone), getString(R.string.roche), R.drawable.roche));
        HotelAdapter adapter = new HotelAdapter(getContext(), 0, hotelInfos);
        listView.setAdapter(adapter);
        return view;
    }

}
