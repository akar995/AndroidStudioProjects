package com.recoded.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button albums;
    Button songs;
    Button payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        albums = (Button) findViewById(R.id.albums);
        songs = (Button) findViewById(R.id.songs);
        payment = (Button) findViewById(R.id.payment);

        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent album = new Intent(MainActivity.this, Albums.class);
                album.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(album);
                finish();
            }
        });
        songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent song = new Intent(MainActivity.this, Songs.class);
                song.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(song);
                finish();
            }
        });
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent payment = new Intent(MainActivity.this, Payment.class);
                payment.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(payment);
                finish();
            }
        });
    }
}
