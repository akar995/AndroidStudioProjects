package com.recoded.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Payment extends AppCompatActivity {
    Button albums;
    Button songs;
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        albums = (Button) findViewById(R.id.albums);
        home = (Button) findViewById(R.id.home);
        songs = (Button) findViewById(R.id.songs);

        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent album = new Intent(Payment.this, Albums.class);
                album.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(album);
                finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Payment.this, MainActivity.class);
                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home);
                finish();
            }
        });
        songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent payment = new Intent(Payment.this, Songs.class);
                payment.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(payment);
                finish();
            }
        });
    }
}
