package com.example.oliver.onlineimagereader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list);

        try {

            JSONObject root=new JSONObject(JSON.json);
            JSONArray article=root.getJSONArray("articles");
            ArrayList<NewArticle> articleArrayList=new ArrayList<>();
            String title;
            String author;
            String image;
            for (int i = 0; i <article.length() ; i++) {
                JSONObject element=article.getJSONObject(i);
                title=element.getString("title");
                author=element.getString("author");
                image=element.getString("urlToImage");
                articleArrayList.add(new NewArticle(title,author,image));
            }
            NewArtcleAdapter artcleAdapter=new NewArtcleAdapter(getApplicationContext(),R.layout.list_view_layout,articleArrayList);
            listView.setAdapter(artcleAdapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}
