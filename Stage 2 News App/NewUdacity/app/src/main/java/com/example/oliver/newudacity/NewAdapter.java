package com.example.oliver.newudacity;

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

public class NewAdapter extends ArrayAdapter<NewsInfo> {
    public NewAdapter(@NonNull Context context, @NonNull List<NewsInfo> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        NewsHolder holder = new NewsHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_layout, parent, false);
            holder.titleNews = convertView.findViewById(R.id.title_tv);
            holder.author = convertView.findViewById(R.id.author_tv);
            holder.image = convertView.findViewById(R.id.image_view);
            holder.section = convertView.findViewById(R.id.section_tv);
            holder.date = convertView.findViewById(R.id.date_tv);
            convertView.setTag(holder);
        } else {
            holder = (NewsHolder) convertView.getTag();
        }
        NewsInfo info = getItem(position);
        holder.section.setText(getContext().getString(R.string.section) + info.getSection());
        holder.author.setText(getContext().getString(R.string.author) + info.getAuthor());
        holder.titleNews.setText(getContext().getString(R.string.Title) + info.getTitleNew());
        holder.image.setTag(info.getWebUrl());
        Picasso.get().load(info.getImageSrc()).into(holder.image);
        holder.date.setText(getContext().getString(R.string.date) + info.getDate());
        return convertView;
    }

    class NewsHolder {
        TextView titleNews;
        TextView author;
        ImageView image;
        TextView section;
        TextView date;
    }
}