package com.example.oliver.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Student.test();
    }

    int TeamAScore = 0;
    int TeamBScore = 0;

    public void TeamA3(View view) {
        TeamAScore += 3;
        ((TextView) findViewById(R.id.teamAText)).setText("" + TeamAScore);

    }

    public void TeamA2(View view) {
        TeamAScore += 2;
        ((TextView) findViewById(R.id.teamAText)).setText("" + TeamAScore);

    }

    public void TeamA1(View view) {
        TeamAScore++;
        ((TextView) findViewById(R.id.teamAText)).setText("" + TeamAScore);
    }

    public void TeamB3(View view) {
        TeamBScore += 3;
        ((TextView) findViewById(R.id.teamBText)).setText("" + TeamBScore);

    }

    public void TeamB2(View view) {
        TeamBScore += 2;
        ((TextView) findViewById(R.id.teamBText)).setText("" + TeamBScore);

    }

    public void TeamB1(View view) {
        TeamBScore++;
        ((TextView) findViewById(R.id.teamBText)).setText("" + TeamBScore);
    }

    public void reset(View view) {
        TeamAScore=0;
        TeamBScore=0;
        ((TextView) findViewById(R.id.teamAText)).setText("0");
        ((TextView) findViewById(R.id.teamBText)).setText("0");
    }
}
