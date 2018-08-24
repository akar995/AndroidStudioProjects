package com.example.oliver.awayintentwardagry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView nahh=findViewById(R.id.nahh);
        nahh.setText(getIntent().getStringExtra(Intent.EXTRA_TEXT));
    }
}
