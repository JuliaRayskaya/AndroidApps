package com.example.juliarayskaya.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.juliarayskaya.myapplication.recyclerview.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewsListActivity extends AppCompatActivity {

    private static String TAG = "NewsListActivity";
    private RecyclerView recyclerView;
    private List<NewsItem> newsItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        new FetchItemTask().execute();
        setupAdapter();

    }

    private void setupAdapter(){
        RecyclerView.Adapter adapter = new NewsAdapter(newsItems);
        recyclerView.setAdapter(adapter);
    }

    private class FetchItemTask extends AsyncTask<Void, Void, List<NewsItem>>{

        @Override
        protected List<NewsItem> doInBackground(Void... voids) {
            return new ServerFetcher().newsItems();
        }

        @Override
        protected void onPostExecute(List<NewsItem> parseNewsItems){
            newsItems = parseNewsItems;
            setupAdapter();
        }
    }
}
