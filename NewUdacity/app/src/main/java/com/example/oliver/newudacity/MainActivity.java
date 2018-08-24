package com.example.oliver.newudacity;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Root> {
    public static final String urlString = "https://content.guardianapis.com/search?api-key=f54b026a-aeb7-499c-bb97-048ac687ae86&show-fields=thumbnail,byline";
    private static final String TAG = "MainActivity";
    ListView listView;
    TextView networkTextView;
    ProgressBar progressBar;
    MainActivity mainActivity;
    LoaderManager loader;

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
    public android.support.v4.content.Loader<Root> onCreateLoader(int id, @Nullable Bundle args) {
        return new NewsLoader(getApplicationContext(), urlString);
    }

    @Override
    public void onLoadFinished(@NonNull android.support.v4.content.Loader<Root> loader, Root data) {
        if (data == null) {
            networkTextView.setVisibility(View.VISIBLE);
            networkTextView.setText(R.string.no_data);
            progressBar.setVisibility(View.GONE);
        } else {
            NewAdapter adapter = new NewAdapter(getApplicationContext(), data.getResults());
            progressBar.setVisibility(View.GONE);
            listView.setAdapter(adapter);
        }
    }

    @Override
    public void onLoaderReset(@NonNull android.support.v4.content.Loader<Root> loader) {
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