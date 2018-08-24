package com.example.oliver.nofancymusicapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity implements Serializable {
    ImageView imageButton;
    ArrayList<MusicInfo> musicInfo;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setTitle("Songs");
        musicInfo = new ArrayList<>();
        MusicTrackInfo musicTrackInfo = new MusicTrackInfo(getApplication());
        musicInfo = musicTrackInfo.musicInfo;
        imageButton = findViewById(R.id.imageButton);
        musicAdapter adapter = new musicAdapter(this, musicInfo);
        ListView list = findViewById(R.id.list);
        list.setAdapter(adapter);
        imageButton.setOnClickListener(goToArtistic());
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



    View.OnClickListener goToArtistic() {
        final Intent art = new Intent(this, Artist.class);

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(art);
            }
        };
    }

}
