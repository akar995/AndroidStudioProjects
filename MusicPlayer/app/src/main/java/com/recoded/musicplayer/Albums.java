package com.recoded.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Albums extends AppCompatActivity {
    Button home;
    Button songs;
    Button payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        home = (Button) findViewById(R.id.home);
        songs = (Button) findViewById(R.id.songs);
        payment = (Button) findViewById(R.id.payment);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Albums.this, MainActivity.class);
                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home);
                finish();
            }
        });
        songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent song = new Intent(Albums.this, Songs.class);
                song.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(song);
                finish();
            }
        });
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent payment = new Intent(Albums.this, Payment.class);
                payment.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(payment);
                finish();
            }
        });
    }
}
