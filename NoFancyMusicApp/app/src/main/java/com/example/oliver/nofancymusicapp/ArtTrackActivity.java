package com.example.oliver.nofancymusicapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
public class ArtTrackActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_track_activity);
        Intent intent = getIntent();
        String artName = intent.getStringExtra("artName");
        setTitle(artName);
        MusicTrackInfo musicTrackInfo = new MusicTrackInfo(getApplication());
        ArrayList<MusicInfo> artTacks = musicTrackInfo.findSongsForArtists(artName);
        musicAdapter adapter = new musicAdapter(this, artTacks);
        ListView list = findViewById(R.id.artList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(playMusic());
    }
    AdapterView.OnItemClickListener playMusic() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String trackName = ((TextView) view.findViewById(R.id.track_name_textview)).getText().toString();

                Intent play = new Intent(getApplicationContext(), CurrentPlaying.class);
                play.putExtra("trackName", trackName);

                startActivity(play);

            }
        };
    }
}
