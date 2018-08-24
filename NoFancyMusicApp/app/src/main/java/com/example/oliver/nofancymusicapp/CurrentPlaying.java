package com.example.oliver.nofancymusicapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
public class CurrentPlaying extends AppCompatActivity {
    ImageView trackImage;
    ImageView goToArt;
    ImageView goToTracks;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_playing);
        Intent intent = getIntent();
        String trackName = intent.getStringExtra("trackName");
        trackImage = findViewById(R.id.music_image);
        setTitle(trackName);
        MusicTrackInfo musicTrackInfo = new MusicTrackInfo(getApplicationContext());
        ArrayList<MusicInfo> currentMusic = musicTrackInfo.findCurrentMusic(trackName);
        trackImage.setImageResource(currentMusic.get(0).getmIconImage());
        goToTracks = findViewById(R.id.track_image_view);
        goToArt = findViewById(R.id.art);
        goToTracks.setOnClickListener(goToTrack());
        goToArt.setOnClickListener(goToArtistc());
    }

     View.OnClickListener goToArtistc() {
        return  new View.OnClickListener() {

            public void onClick(View view) {
                Intent art=new Intent(getApplicationContext(),Artist.class);
                startActivity(art);

            }
        };
    }

     View.OnClickListener goToTrack() {
        return  new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tracks =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(tracks);
            }
        };
    }

}
