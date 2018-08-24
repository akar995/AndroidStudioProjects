package com.example.android.bfffriendshiptest;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout firstActivity = (LinearLayout) findViewById(R.id.first_activity);
        RelativeLayout secondActivity = (RelativeLayout) findViewById(R.id.second_activity);
        LinearLayout thirdActivity = (LinearLayout) findViewById(R.id.third_activity);

        firstActivity.setVisibility(View.VISIBLE);
        secondActivity.setVisibility(View.INVISIBLE);
        thirdActivity.setVisibility(View.INVISIBLE);

        showingLayout();
//        ProgressBar progressBar = findViewById(R.id.circular_progress_result); used for circular which shows the result
//        progressBar.setProgress(20);


        ArrayList<String> d=new ArrayList<>();

    }

    void showingLayout(){
        final LinearLayout[] questions =new LinearLayout[5];
        questions[0]=findViewById(R.id.first_section);
        questions[1]=findViewById(R.id.second_section);
        questions[2]=findViewById(R.id.third_section);
        questions[3]=findViewById(R.id.fourth_section);
        questions[4]=findViewById(R.id.fifth_section);

        CountDownTimer test=new CountDownTimer(15000,1000) {
            @Override
            public void onTick(long l) {
                questions[0].setVisibility(View.VISIBLE);
                questions[1].setVisibility(View.GONE);
                questions[2].setVisibility(View.GONE);
                questions[3].setVisibility(View.GONE);
                questions[4].setVisibility(View.GONE);
                for (int i=0 ;i< questions.length ;i++)
                {
                    if(i>0 ){
                        questions[i-1].setVisibility(View.GONE);
                        questions[i].setVisibility(View.VISIBLE);

                    }
                }

            }

            @Override
            public void onFinish() {

            }
        };
    }
}
