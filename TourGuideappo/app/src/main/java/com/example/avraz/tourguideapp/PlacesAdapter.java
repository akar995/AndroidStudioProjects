package com.example.avraz.tourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.avraz.tourguideapp.Places;

import java.util.ArrayList;

public class PlacesAdapter extends ArrayAdapter<Places> {
    private Context context;
    private int mResource;
    private ArrayList<Places> objects; //changed
    // ADD THIS

    public PlacesAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Places> objects) {
        super(context, resource, objects);
        mResource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView= LayoutInflater.from(getContext()).inflate(mResource,null);
        }

        Places currentItem= getItem(position);

        ImageView placeImage=convertView.findViewById(R.id.place_image);
        TextView placeTitle=convertView.findViewById(R.id.place_title);
        TextView placeParagraph=convertView.findViewById(R.id.places_paragraph);
        TextView placeAddress=convertView.findViewById(R.id.place_address);

        placeImage.setImageResource(currentItem.getImage());
        placeTitle.setText(currentItem.getTitle());
        placeParagraph.setText(currentItem.getParagraph());
        placeAddress.setText(currentItem.getAddress());
        return convertView;
    }
}
