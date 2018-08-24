package com.example.oliver.nofancymusicapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
public class ArtistAdapter extends ArrayAdapter<MusicInfo> {
    public ArtistAdapter(Context context, ArrayList<MusicInfo> art) {
        super(context, 0, art);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;

        ArtViewHolder holder;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.artist_layout_grid_view, parent, false);
            holder=new ArtViewHolder();
            holder.artText = listView.findViewById(R.id.art_text_view_layout);
             holder.imageView = listView.findViewById(R.id.art_image_view);
            listView.setTag(holder);
        }
        else {
            holder=(ArtViewHolder)listView.getTag();
        }
        MusicInfo currentArt = getItem(position);

        holder.artText.setText(currentArt.getmArtisticName());
        holder.imageView.setImageResource(currentArt.getmIconImage());
        return listView;
    }
    class ArtViewHolder{
        TextView artText ;
                ImageView imageView;
    }
}
