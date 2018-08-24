package com.example.oliver.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ParkAdapter extends ArrayAdapter<ParkInfo> {

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listview = convertView;
        ViewHolder holder;
        if (listview == null) {
            listview = LayoutInflater.from(getContext()).inflate(R.layout.park_list_view, parent, false);
            holder = new ViewHolder();
            holder.title = listview.findViewById(R.id.park_title);
            holder.location = listview.findViewById(R.id.park_location);
            holder.imageView = listview.findViewById(R.id.park_image);
            listview.setTag(holder);
        } else {
            holder = (ViewHolder) listview.getTag();
        }
        ParkInfo restaurantInfo = getItem(position);
        holder.imageView.setImageResource(restaurantInfo.getmImageSrc());
        holder.location.setText(restaurantInfo.getmLocation());

        holder.title.setText(restaurantInfo.getmTitle());
        return listview;
    }

    class ViewHolder {
        TextView title;

        TextView location;
        ImageView imageView;
    }

    public ParkAdapter(@NonNull Context context, @NonNull ArrayList<ParkInfo> objects) {
        super(context, 0, objects);
    }
}
