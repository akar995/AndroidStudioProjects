package com.example.oliver.newudacity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<NewsInfo>> {
    public static final String urlString = "https://content.guardianapis.com/search?api-key=f54b026a-aeb7-499c-bb97-048ac687ae86&show-fields=thumbnail,byline";
    private static final String TAG = "MainActivity";
    ListView listView;
    TextView networkTextView;
    ProgressBar progressBar;
    MainActivity mainActivity;
    LoaderManager loader;

    @Override
    protected void onStart() {
        super.onStart();
        LoaderManager loaderManager = getSupportLoaderManager();
        Loader loader = loaderManager.getLoader(0);
        if (loader == null) {
            loaderManager.initLoader(0, null, this).forceLoad();
        } else {
            loaderManager.restartLoader(0, null, this).forceLoad();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Intent intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);
        networkTextView = findViewById(R.id.network_tv);
        progressBar = findViewById(R.id.progress_p);
        loader = getSupportLoaderManager();
        if (isNetworkConnected()) {
            progressBar.setVisibility(View.VISIBLE);
            networkTextView.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
            loader.initLoader(0, null, this).forceLoad();
        } else {
            listView.setVisibility(View.GONE);
            networkTextView.setVisibility(View.VISIBLE);
            networkTextView.setText(R.string.text_view_network);
        }
        mainActivity = this;
        networkTextView.setOnClickListener(reset());
        listView.setOnItemClickListener(goToBrowser());
    }

    public AdapterView.OnItemClickListener goToBrowser() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView link = view.findViewById(R.id.image_view);
                String url = link.getTag().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                try {
                    startActivity(intent);
                } catch (Exception e) {
                }
            }
        };
    }

    public View.OnClickListener reset() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNetworkConnected()) {
                    progressBar.setVisibility(View.VISIBLE);
                    networkTextView.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    loader.initLoader(0, null, MainActivity.this).forceLoad();
                } else {
                    listView.setVisibility(View.GONE);
                    networkTextView.setVisibility(View.VISIBLE);
                    networkTextView.setText(R.string.text_view_network);
                }
            }
        };
    }

    @Override
    public android.support.v4.content.Loader<ArrayList<NewsInfo>> onCreateLoader(int id, @Nullable Bundle args) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String location = sharedPreferences.getString(getString(R.string.sorting_type), "newest");
        Uri baseUri = Uri.parse(urlString);
        Uri.Builder builder = baseUri.buildUpon();
        builder.appendQueryParameter("order-by", location);
        builder.build();
        return new NewsLoader(getApplicationContext(), builder.toString());
    }

    @Override
    public void onLoadFinished(@NonNull android.support.v4.content.Loader<ArrayList<NewsInfo>> loader, ArrayList<NewsInfo> data) {
        if (data.size() == 0) {
            networkTextView.setVisibility(View.VISIBLE);
            networkTextView.setText(R.string.no_data);
            progressBar.setVisibility(View.GONE);
        } else {
            listView.removeAllViewsInLayout();
            NewAdapter adapter = new NewAdapter(getApplicationContext(), data);
            progressBar.setVisibility(View.GONE);
            listView.setAdapter(adapter);
            listView.deferNotifyDataSetChanged();
        }
    }

    @Override
    public void onLoaderReset(@NonNull android.support.v4.content.Loader<ArrayList<NewsInfo>> loader) {
    }

    public boolean isNetworkConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
}