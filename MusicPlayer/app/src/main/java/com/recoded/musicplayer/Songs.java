package com.recoded.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Songs extends AppCompatActivity {
    Button albums;
    Button home;
    Button payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        albums = (Button) findViewById(R.id.albums);
        home = (Button) findViewById(R.id.home);
        payment = (Button) findViewById(R.id.payment);

        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent album = new Intent(Songs.this, Albums.class);
                album.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(album);
                finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Songs.this, MainActivity.class);
                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home);
                finish();
            }
        });
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent payment = new Intent(Songs.this, Payment.class);
                payment.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(payment);
                finish();
            }
        });
    }
}
