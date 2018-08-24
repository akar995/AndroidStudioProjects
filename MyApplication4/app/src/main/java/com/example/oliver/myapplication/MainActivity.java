package com.example.oliver.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    TextView textView;
    public static final String url = "https://openweathermap.org/data/2.5/weather?appid=b6907d289e10d714a6e88b30761fae22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.value);

        LoaderManager loaderManager = getSupportLoaderManager();
        loaderManager.initLoader(0, null, this).forceLoad();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Settings:
                Intent intent = new Intent(MainActivity.this, Settings.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    ///////////// Loader
    @NonNull
    @Override
    public Loader<String> onCreateLoader(int i, @Nullable Bundle bundle) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String location = sharedPreferences.getString(getString(R.string.settings_key), "London");

        Uri baseUri = Uri.parse(url);

        Uri.Builder builder = baseUri.buildUpon();

        builder.appendQueryParameter("q", location);

        builder.build();


        return new weacherLoader(getApplicationContext(), builder.toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        LoaderManager loaderManager=getSupportLoaderManager();
        if (loaderManager==null) {
            loaderManager.initLoader(0, null, this).forceLoad();
        }else {
            loaderManager.restartLoader(0,null,this).forceLoad();
        }
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String s) {

        try {
            JSONObject root = new JSONObject(s);
            JSONArray weather = root.getJSONArray("weather");
            JSONObject element = weather.getJSONObject(0);
            textView.setText(element.getString("description"));
            Log.i("hello", "onLoadFinished: "+root.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}

