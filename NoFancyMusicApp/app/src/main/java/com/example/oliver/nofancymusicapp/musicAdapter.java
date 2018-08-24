package com.example.oliver.nofancymusicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class musicAdapter extends ArrayAdapter<MusicInfo> {
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;

        MusicViewHolder holder;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.music_tracks_layout, parent, false);
            holder = new MusicViewHolder();

            holder.trackName = listView.findViewById(R.id.track_name_textview);
            holder.artisticName = listView.findViewById(R.id.artistic_name_textview);
            holder.iconImage = listView.findViewById(R.id.image_view);
            listView.setTag(holder);
        } else {
            holder = (MusicViewHolder) listView.getTag();
        }
        MusicInfo currentMusic = getItem(position);

        holder.trackName.setText(currentMusic.getmTrackName());

        holder.artisticName.setText(currentMusic.getmArtisticName());

        holder.iconImage.setImageResource(currentMusic.getmIconImage());

        return listView;
    }

    public musicAdapter(Context context, ArrayList<MusicInfo> music) {
        super(context, 0, music);
    }
}

class MusicViewHolder {
    TextView trackName;
    TextView artisticName;
    ImageView iconImage;

}