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

import java.util.List;

public class HotelAdapter extends ArrayAdapter<HotelInfo> {


    public HotelAdapter(@NonNull Context context, int resource, @NonNull List<HotelInfo> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listview = convertView;
        ViewHolder holder;
        if (listview == null) {
            listview = LayoutInflater.from(getContext()).inflate(R.layout.restaurant_layout_list_view, parent, false);
            holder = new ViewHolder();
            holder.cityName = listview.findViewById(R.id.resta_title);
            holder.imageView = listview.findViewById(R.id.resta_image);
            holder.location = listview.findViewById(R.id.resta_location);
            holder.phoneNumber = listview.findViewById(R.id.resta_phone);
            listview.setTag(holder);
        } else {
            holder = (ViewHolder) listview.getTag();
        }
        HotelInfo restaurantInfo = getItem(position);
        holder.imageView.setImageResource(restaurantInfo.getmImageSrc());
        holder.location.setText(restaurantInfo.getmLocation());
        holder.phoneNumber.setText(restaurantInfo.getmPhoneNumber());
        holder.cityName.setText(restaurantInfo.getmTitle());
        return listview;
    }

    class ViewHolder {
        TextView cityName;
        TextView phoneNumber;
        TextView location;
        ImageView imageView;

    }

}
