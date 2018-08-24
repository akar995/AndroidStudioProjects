package com.example.oliver.audiof;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    AudioManager audioManager;
    Context context;
    AudioManager.OnAudioFocusChangeListener afChangeListener;

     MediaPlayer  mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer= MediaPlayer.create(this,R.raw.hunter_2011);
        context=getApplicationContext();
        audioManager=(AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        Button button=findViewById(R.id.play);
        afChangeListener =new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int i) {
                if(i==AudioManager.AUDIOFOCUS_LOSS){
                    mediaPlayer.stop();
                }else  if (i==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT)
                {
                    mediaPlayer.pause();
                }
                else  if (i==AudioManager.AUDIOFOCUS_GAIN)
                {
                    mediaPlayer.start();
                }

            }
        };
        View.OnClickListener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result =audioManager.requestAudioFocus(afChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN);
                if(result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mediaPlayer.start();
                }
            }
        });
    }
}
