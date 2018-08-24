package com.example.oliver.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class weacherLoader extends AsyncTaskLoader<String>
{
    String urlString;
    public weacherLoader(@NonNull Context context ,String url) {
        super(context);
        urlString=url;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        String JsonData=null;
        try {
            StringBuilder jsonString=new StringBuilder();
            URL url=new URL(urlString);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            InputStream inputStream=httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line=bufferedReader.readLine().toString();
            while (line!=null)
            {
                jsonString.append(line);
                line=bufferedReader.readLine();
            }
            return jsonString.toString();



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return JsonData;
    }
}
