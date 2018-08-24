package com.example.oliver.nofancymusicapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
public class Artist extends AppCompatActivity {
    ArrayList<MusicInfo> musicInfo;
    ImageView trackImage;
    GridView list;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
        musicInfo = new ArrayList<>();
        MusicTrackInfo musicTrackInfo = new MusicTrackInfo(getApplication());
        musicInfo = musicTrackInfo.findArtists();
        ArtistAdapter adapter = new ArtistAdapter(this, musicInfo);
        list = findViewById(R.id.art_grid_view);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView artName = view.findViewById(R.id.art_text_view_layout);
                Intent intent = new Intent(getApplicationContext(), ArtTrackActivity.class);
                intent.putExtra("artName", artName.getText().toString());
                startActivity(intent);
            }
        });

        trackImage = findViewById(R.id.track_image_view);
        trackImage.setOnClickListener(goToTrack());
    }
    View.OnClickListener goToTrack() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent track = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(track);
            }
        };
    }
}
