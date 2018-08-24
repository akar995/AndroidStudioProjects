package com.example.oliver.intenttest2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text=findViewById(R.id.text);
        text.setOnClickListener(test());
    }


    View.OnClickListener test(){
       return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent test=new Intent();
                test.setAction(Intent.ACTION_SEND);
                test.setType("text/plain");
                test.putExtra(Intent.EXTRA_TEXT,"sjanckajsbakbsak");

                    startActivity(test);

            }
        };

    }
}
