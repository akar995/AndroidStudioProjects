package com.example.oliver.pingpongscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button teamAPointButton;
    Button teamBPointButton;
    Button teamAFoulsButton;
    Button teamBFoulsButton;
    Button resetButton;
    TextView TeamAScoreText;
    TextView TeamAFoulsText;
    TextView TeamAServeText;
    TextView TeamBScoreText;
    TextView TeamBFoulsText;
    TextView TeamBServeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamAPointButton=findViewById(R.id.teamAPointButton);
        teamBPointButton=findViewById(R.id.teamBPointButton);
        teamAFoulsButton=findViewById(R.id.teamAFoulButton);
        teamBFoulsButton=findViewById(R.id.teamBFoulButtun);
        resetButton=findViewById(R.id.resetButton);
        TeamAScoreText=(TextView)findViewById(R.id.TeamAScoreText);
        TeamAFoulsText=(TextView)findViewById(R.id.TeamAFoulText);
        TeamAServeText=(TextView)findViewById(R.id.TeamAServeText);
        TeamBScoreText=(TextView)findViewById(R.id.TeamBScoreText);
        TeamBServeText=(TextView)findViewById(R.id.TeamBServeText);
        TeamBFoulsText=(TextView)findViewById(R.id.TeamBFoulText);
        teamAPointButton.setOnClickListener(addOnePointToAOnClickListener());
        teamBPointButton.setOnClickListener(addOnePointToBOnClickListener());
        View.OnClickListener onClickListener=foul();
        teamAFoulsButton.setOnClickListener(onClickListener);
        teamBFoulsButton.setOnClickListener(onClickListener);
        resetButton.setOnClickListener(reset());
    }
    int TeamAFoul=0;
    int TeamBFoul=0;
    int TeamAScore=0;
    int TeamBScore=0;
    int TeamAServe=2;
    int TeamBServe=0;
    boolean serve=true;
    void addOnePointToB()
    {
        TeamBScore++;
        TeamBScoreText.setText(""+TeamBScore);
        if(serve)
        {
            TeamAServe--;
            if (TeamAServe==0)
            {
                TeamBServe=2;
                serve=false;
            }
        }
        else
        {
            TeamBServe--;
            if(TeamBServe==0){
                TeamAServe=2;
                serve=true;
            }
        }
        TeamAServeText.setText(TeamAServe+"");
        TeamBServeText.setText(""+TeamBServe);
        if(TeamBScore>10){
            TeamAFoul=0;
            TeamBFoul=0;
            Toast.makeText(MainActivity.this, "Team B Won", Toast.LENGTH_SHORT).show();
            TeamAScore=0;
            TeamBScore=0;
            serve=true;
            TeamAServe=2;
            TeamBServe=0;
            TeamAScoreText.setText(""+TeamAScore);
            TeamAServeText.setText(TeamAServe+"");
            TeamBServeText.setText(""+TeamBServe);
            TeamAScoreText.setText("");
            TeamBScoreText.setText("");
            TeamBFoulsText.setText("");
            TeamAFoulsText.setText("");
        }
    }
    View.OnClickListener addOnePointToBOnClickListener(){
        View.OnClickListener pointOnClick=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOnePointToB();
            }
        };
        return pointOnClick;
    }
    void addOnePointToA(){
        TeamAScore++;
        TeamAScoreText.setText(""+TeamAScore);
        if(serve)
        {
            TeamAServe--;
            if (TeamAServe==0)
            {
                TeamBServe=2;
                serve=false;
            }
        }
        else
        {
            TeamBServe--;
            if(TeamBServe==0){
                TeamAServe=2;
                serve=true;
            }
        }
        TeamAServeText.setText(TeamAServe+"");
        TeamBServeText.setText(""+TeamBServe);
        if(TeamAScore>10){
            Toast.makeText(MainActivity.this, "Team A Won", Toast.LENGTH_SHORT).show();
            TeamAScore=0;
            TeamBScore=0;
            TeamAFoul=0;
            TeamBFoul=0;
            serve=false;
            TeamAServe=0;
            TeamBServe=2;
            TeamAScoreText.setText(""+TeamAScore);
            TeamAServeText.setText(TeamAServe+"");
            TeamBServeText.setText(""+TeamBServe);
            TeamBScoreText.setText("");
            TeamBFoulsText.setText("");
            TeamAFoulsText.setText("");
        }
    }
    View.OnClickListener addOnePointToAOnClickListener(){
        View.OnClickListener pointOnClick=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOnePointToA();

            }

        };
        return pointOnClick;
    }
    View.OnClickListener foul(){
        View.OnClickListener foul=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (teamAFoulsButton.getId()==view.getId())
                {
                    TeamAFoul++;
                    if(TeamAFoul==3)
                    {
                        TeamAFoul=0;
                        Toast.makeText(MainActivity.this, "one point add to Team B", Toast.LENGTH_SHORT).show();
                        addOnePointToB();
                        TeamAFoulsText.setText("");
                    }
                    else{
                        TeamAFoulsText.setText(TeamAFoulsText.getText()+"I ");
                    }
                }
                if (teamBFoulsButton.getId()==view.getId())
                {
                    TeamBFoul++;
                    if(TeamBFoul==3)
                    {
                        TeamBFoul=0;
                        Toast.makeText(MainActivity.this, "one point add to Team B", Toast.LENGTH_SHORT).show();
                        TeamBFoulsText.setText("");
                        addOnePointToA();
                    }
                    else{
                        TeamBFoulsText.setText(TeamBFoulsText.getText()+"I ");
                    }
                }
            }
        };
        return foul;
    }
    View.OnClickListener reset(){
        View.OnClickListener reset=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Game reseted", Toast.LENGTH_SHORT).show();
                TeamAScore=0;
                TeamBScore=0;
                TeamAFoul=0;
                TeamBFoul=0;
                serve=false;
                TeamAServe=0;
                TeamBServe=2;
                TeamAScoreText.setText(""+TeamAScore);
                TeamAServeText.setText(TeamAServe+"");
                TeamBServeText.setText(""+TeamBServe);
                TeamBScoreText.setText("");
                TeamBFoulsText.setText("");
                TeamAFoulsText.setText("");
            }
        };
        return reset;
    }

}