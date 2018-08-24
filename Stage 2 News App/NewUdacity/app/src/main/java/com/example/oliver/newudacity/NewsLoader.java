package com.example.oliver.newudacity;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class NewsLoader extends AsyncTaskLoader<ArrayList<NewsInfo>> {
    private String url;

    public NewsLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    public ArrayList<NewsInfo> loadInBackground() {
        ArrayList<NewsInfo> news = new ArrayList<>();
        StringBuilder jsonData = new StringBuilder();
        try {
            URL url = new URL(this.url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                jsonData.append(line);
                line = bufferedReader.readLine();
            }
            JSONObject root = new JSONObject(jsonData.toString());
            Log.i("tag", "loadInBackground: result");
            if (root.has("response")) {
                JSONObject response = root.getJSONObject("response");
                if (response.has("results")) {
                    JSONArray newdata = response.getJSONArray("results");
                    String newsTitle = null;
                    String author = null;
                    String section = null;
                    String image = null;
                    String webUrl = null;
                    String date = null;
                    for (int i = 0; i < newdata.length(); i++) {
                        JSONObject element = newdata.getJSONObject(i);
                        if (element.has("webTitle")) {
                            newsTitle = element.getString("webTitle");
                        }
                        if (element.has("webUrl")) {
                            webUrl = element.getString("webUrl");
                        }
                        if (element.has("sectionName")) {
                            section = element.getString("sectionName");
                        }
                        if (element.has("fields")) {
                            JSONObject fields = element.getJSONObject("fields");
                            if (fields.has("byline")) {
                                author = fields.getString("byline");
                            }
                            if (fields.has("thumbnail")) {
                                image = fields.getString("thumbnail");
                            }
                        }
                        if (element.has("webPublicationDate")) {
                            date = element.getString("webPublicationDate");
                        }
                        news.add(new NewsInfo(newsTitle, image, author, section, webUrl, date));
                    }
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return news;
    }
}