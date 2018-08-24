package com.example.oliver.movieapi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<MovieInfo>> {


    GridView gridView;
    ArrayList<MovieInfo> test;
    MovieAdapter adapter;
    public int pageNumbber = 1;
    private static final String TAG = "MainActivity";
    String stringUrl = "https://api.themoviedb.org/3/movie/popular?api_key=37a926f2732802481bd9a716cd8e145b&language=en-US&page=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test = new ArrayList<>();


//            try {
//                URL url = new URL(stringUrl+pageNumbber);
//                new MyASyincTask().execute(url);
//                pageNumbber++;
//
//            } catch (MalformedURLException e) {
//                Log.i("akar", "akar");
//                e.printStackTrace();
//            }


        gridView = findViewById(R.id.grid);
        LoaderManager loaderManager=getSupportLoaderManager();
        loaderManager.initLoader(0,null,this).forceLoad();
//        gridView.setOnScrollListener(new AbsListView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(AbsListView absListView, int i) {
//
//            }
//
//            @Override
//            public void onScroll(AbsListView absListView, int firstItem, int vItem, int totalItem) {
//                if (totalItem<=(firstItem+10)) {
//                    try {
////                        URL url = new URL(stringUrl+pageNumbber);
////                        new MyASyincTask().execute(url);
////                        pageNumbber++;
////
////                    } catch (MalformedURLException e) {
////                        Log.i("akar", "akar");
////                        e.printStackTrace();
////                    }
//
//                }
//            }
//        });

    }

    @NonNull
    @Override
    public Loader<ArrayList<MovieInfo>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new MyAsyncTaskLoader(getApplicationContext());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<MovieInfo>> loader, ArrayList<MovieInfo> movieInfos) {
        MovieAdapter adapter = new MovieAdapter(getApplicationContext(), movieInfos);
        gridView.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<MovieInfo>> loader) {

    }


//
//    class MyASyincTask extends AsyncTask<URL,Void,String> {
//        @Override
//        protected String doInBackground(URL... urls) {
//
//            return null;
//        }
//
//
//        public ArrayList<MovieInfo> getMovieInfos() {
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
////            JSONObject root;
////
////            try {
////                root= new JSONObject(s);
////                JSONArray movies=root.getJSONArray("results");
////                String Name;
////                String IamgeUrl;
////                int id;
////                for (int i = 0; i <movies.length() ; i++) {
////                    JSONObject element=movies.getJSONObject(i);
////                    Name=element.getString("title");
////                    IamgeUrl=element.getString("poster_path");
////                    id=element.getInt("id");
////                    test.add(new MovieInfo(Name,IamgeUrl,id));
////                    adapter.notifyDataSetChanged();
////                   // movieInfos.add(new MovieInfo(Name,IamgeUrl,id));
////
////                }
//////                gridView=findViewById(R.id.grid);
//////                MovieAdapter adapter=new MovieAdapter(getApplicationContext(),movieInfos);
//////                gridView.setAdapter(adapter);
////
////
////            } catch (JSONException e) {
////                e.printStackTrace();
////            }
//
//
//
//        }
//
//
//    }

}
