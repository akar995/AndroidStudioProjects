package com.example.oliver.miwok;

import android.content.Intent;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.oliver.miwok.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.numbers.setOnClickListener(goToNumbers());
        binding.colors.setOnClickListener(goToColors());
        binding.family.setOnClickListener(goToFamily());
        binding.phrases.setOnClickListener(goToPheases());
    }

    View.OnClickListener goToNumbers(){

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent number= new Intent(getApplicationContext(),NumberActivity.class);
                startActivity(number);

            }
        };
    }
    View.OnClickListener goToColors(){

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent number= new Intent(getApplicationContext(),ColorActivity.class);
                startActivity(number);

            }
        };
    }



    View.OnClickListener goToPheases(){

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent number= new Intent(getApplicationContext(),PheasesActivity.class);
                startActivity(number);

            }
        };
    }
    View.OnClickListener goToFamily(){

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent number= new Intent(getApplicationContext(),FamilyActivity.class);
                startActivity(number);

            }
        };
    }
}
