package com.example.oliver.jsonexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
TextView textView;
TextView cityName,windSpeed,humidity,temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text);
        cityName=findViewById(R.id.city_name_text_view);
        windSpeed=findViewById(R.id.wind_speed_text_view);
        humidity=findViewById(R.id.humidity_text_view);
        temp=findViewById(R.id.temp_text_view);

        try {
            JSONObject root=new JSONObject(JSON.json);
//            JSONObject weather=root.getJSONObject("main");

            cityName.setText(root.getString("name")+"");
            JSONObject main=root.getJSONObject("main");
            temp.setText(main.getDouble("temp")+"˚");
            humidity.setText(main.getInt("humidity")+"");
            JSONObject wind=root.getJSONObject("wind");
            windSpeed.setText(wind.getDouble("speed")+"");


        } catch (JSONException e) {
            e.printStackTrace();
        }



    }
}
