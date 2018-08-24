package com.example.oliver.movieapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends ArrayAdapter<MovieInfo> {

    public MovieAdapter(@NonNull Context context, @NonNull List<MovieInfo> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MovieViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_list_view, parent, false);
            holder = new MovieViewHolder();
            holder.Image = convertView.findViewById(R.id.image_view);
            holder.nameTextView = convertView.findViewById(R.id.title_text_view);
            convertView.setTag(holder);
        } else {
            holder = (MovieViewHolder) convertView.getTag();
        }
        MovieInfo movieInfos = getItem(position);
        holder.nameTextView.setText(movieInfos.getName());
        Picasso.get().load("https://image.tmdb.org/t/p/w500"+movieInfos.getImageSrc()).into(holder.Image);

        return convertView;
    }

    class MovieViewHolder {
        TextView nameTextView;
        ImageView Image;
    }
}
