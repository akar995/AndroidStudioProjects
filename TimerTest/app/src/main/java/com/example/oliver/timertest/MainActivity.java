package com.example.oliver.timertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        LinearLayout linearLayout = new LinearLayout(this);
        textView.setText("hello");
        textView.setTextSize(30);
        linearLayout.addView(textView);
        linearLayout.setGravity(2);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

    }
}
