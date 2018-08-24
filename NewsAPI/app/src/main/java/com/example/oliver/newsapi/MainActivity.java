package com.example.oliver.newsapi;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

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

public class MainActivity extends AppCompatActivity {
    ListView listView;
    TextView textView;
    String web = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=bc338c0098854615957af006e3443442";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);
        textView=findViewById(R.id.text);
        HttpURLConnection httpURLConnection = null;
        StringBuilder jsionData = null;
        try {
            URL url=new URL(web);
          new NewAsyncTck().execute(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }
    public String testString;

    class NewAsyncTck extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {
            HttpURLConnection httpURLConnection = null;
            StringBuilder jsionData = new StringBuilder();
            try {
                URL url = new URL(web);
                httpURLConnection = (HttpURLConnection) urls[0].openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.connect();

                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line=bufferedReader.readLine();
                while (line != null) {
                    jsionData.append(line);
                    line=bufferedReader.readLine();

                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return jsionData.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            testString=s;
            JSONObject root = null;
            ArrayList<NewArticle> articleArrayList=null;
            try {

                root = new JSONObject(s);

                JSONArray article = root.getJSONArray("articles");
                articleArrayList = new ArrayList<>();
                String title;
                String author;
                String image;
                String des;
                for (int i = 0; i < article.length(); i++) {
                    JSONObject element = article.getJSONObject(i);
                    title = element.getString("title");
                    author = element.getString("author");
                    image = element.getString("urlToImage");
                    des = element.getString("description");
                    articleArrayList.add(new NewArticle(title, author, image, des));

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            NewArtcleAdapter artcleAdapter = new NewArtcleAdapter(getApplicationContext(), R.layout.list_view_layout, articleArrayList);
            listView.setAdapter(artcleAdapter);

        }
    }
}
