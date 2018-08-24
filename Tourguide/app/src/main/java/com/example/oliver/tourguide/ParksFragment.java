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

public class ParksFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parks, container, false);
        ListView listView = view.findViewById(R.id.park_fragemnt);
        ArrayList<ParkInfo> parkInfos = new ArrayList<>();
        parkInfos.add(new ParkInfo(getString(R.string.sami), getString(R.string.gulan), R.drawable.sami));
        parkInfos.add(new ParkInfo(getString(R.string.shanadar), getString(R.string.erbil), R.drawable.shanadar));
        parkInfos.add(new ParkInfo(getString(R.string.mnara), getString(R.string.erbil), R.drawable.mnara));
        parkInfos.add(new ParkInfo(getString(R.string.peshmarga), getString(R.string.erbil), R.drawable.peshmarga));

        ParkAdapter adapter = new ParkAdapter(getContext(), parkInfos);
        listView.setAdapter(adapter);
        return view;
    }
}
