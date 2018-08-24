package com.example.oliver.movieapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MyAsyncTaskLoader extends AsyncTaskLoader<ArrayList<MovieInfo>> {
    String urlString;
    public MyAsyncTaskLoader(@NonNull Context context) {
        super(context);
      //  urlString=urlStr;
    }

    @Nullable
    @Override
    public ArrayList<MovieInfo> loadInBackground() {
        JSONObject root;
        ArrayList<MovieInfo> test = new ArrayList<>();

        HttpURLConnection httpURLConnection=null;
        StringBuilder jsonData=new StringBuilder();
        try {
            URL url=new URL(urlString);
            httpURLConnection=(HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.connect();
            InputStream inputStream =httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line=bufferedReader.readLine();
            while (line!=null){
                jsonData.append(line);
                line=bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            root = new JSONObject(jsonData.toString());
            JSONArray movies = root.getJSONArray("results");
            String Name;
            String IamgeUrl;
            int id;
            for (int i = 0; i < movies.length(); i++) {
                JSONObject element = movies.getJSONObject(i);
                Name = element.getString("title");
                IamgeUrl = element.getString("poster_path");
                id = element.getInt("id");
                test.add(new MovieInfo(Name, IamgeUrl, id));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return test;
    }
}