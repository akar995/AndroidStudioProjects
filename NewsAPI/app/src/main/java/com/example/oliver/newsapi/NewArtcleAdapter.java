package com.example.oliver.newsapi;

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

import java.util.ArrayList;

public class NewArtcleAdapter extends ArrayAdapter {
    public NewArtcleAdapter(@NonNull Context context, int resource, @NonNull ArrayList<NewArticle> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null)
        {
            convertView=LayoutInflater.from(getContext()).inflate(R.layout.list_view_layout,parent,false);

        }
        NewArticle article=(NewArticle)getItem(position);
        TextView title=convertView.findViewById(R.id.title);
        TextView author=convertView.findViewById(R.id.author);
        ImageView imageView=convertView.findViewById(R.id.image);
        TextView des=convertView.findViewById(R.id.des);
        des.setText(article.getmDes());
        title.setText(article.getMtitle());
        author.setText(article.getMauthor());
        Picasso.get().load(article.getMimageSrc()).into(imageView);


        return convertView;
    }
}
