package com.example.juliarayskaya.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.juliarayskaya.myapplication.recyclerview.FeedAdapter;

import java.util.ArrayList;
import java.util.List;


public class FeedListActivity extends AppCompatActivity {
    private static final String TAG = "FeedListActivity";
    Button btnShowNews;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        initRecyclerView();

        btnShowNews = findViewById(R.id.btnShowNews);

        btnShowNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FeedListActivity.this, NewsListActivity.class);
                startActivity(intent);
            }

        });
    }

        private void initRecyclerView() {
            recyclerView = findViewById(R.id.recyclerView);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            RecyclerView.Adapter adapter = new FeedAdapter(generateFeed());
            recyclerView.setAdapter(adapter);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.news_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.settings) {
            Intent intent = new Intent(this, NewsSettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static List<FeedItem> generateFeed() {
        List<FeedItem> feedItems = new ArrayList<>();
        feedItems.add(new FeedItem(true, "New York Times", "https://texasperformingarts.org/sites/files/tpa/tpa_news_images/new-york-times-logo.jpg"));
        feedItems.add(new FeedItem(false, "Fox News", "https://pmcdeadline2.files.wordpress.com/2017/04/fox-news-logo.jpg"));
        feedItems.add(new FeedItem(false, "Jug", "https://jug.ru/wp-content/uploads/2018/03/jugrulogo2.png"));
        feedItems.add(new FeedItem(false, "Techcrunch", "https://seeklogo.com/images/T/techcrunch-logo-B444826970-seeklogo.com.png"));
        return feedItems;
    }
}


