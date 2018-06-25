package com.example.juliarayskaya.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.juliarayskaya.myapplication.recyclerview.FeedAdapter;

import java.util.ArrayList;


public class FeedListActivity extends AppCompatActivity implements
        SharedPreferences.OnSharedPreferenceChangeListener {

    private static final String TAG = "FeedListActivity";
    Button btnShowNews;
    private RecyclerView recyclerView;
    private static FeedListActivity instance;
    public final static String EXCLUDE_FILTER_KEY = "exclude";
    public final static String SEARCH_FILTER_KEY = "search";
    private static boolean PREFERENCE_NEED_UPDATE = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        instance = this;
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new FeedAdapter(generateFeed());
        recyclerView.setAdapter(adapter);

        btnShowNews = findViewById(R.id.btnShowNews);

        btnShowNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FeedListActivity.this, NewsListActivity.class);
                startActivity(intent);

            }

        });
    }
    public static FeedListActivity getInstance() {
        return instance;
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

    private static ArrayList<FeedItem> generateFeed() {
        ArrayList<FeedItem> feedItems = new ArrayList<>();
        feedItems.add(new FeedItem(false, "New York Times", "https://texasperformingarts.org/sites/files/tpa/tpa_news_images/new-york-times-logo.jpg"));
        feedItems.add(new FeedItem(false, "Fox News", "https://pmcdeadline2.files.wordpress.com/2017/04/fox-news-logo.jpg"));
        feedItems.add(new FeedItem(false, "Techcrunch", "https://seeklogo.com/images/T/techcrunch-logo-B444826970-seeklogo.com.png"));
        feedItems.add(new FeedItem(false, "Jug", "https://jug.ru/wp-content/uploads/2018/03/jugrulogo2.png"));
        return feedItems;
    }

    public ArrayList<Long> generateChecked() {
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i < ((FeedAdapter) recyclerView.getAdapter()).feedItems.size(); i++) {
            if (((FeedAdapter) recyclerView.getAdapter()).getItem(i).checkBoxMarked())
                list.add(((FeedAdapter) recyclerView.getAdapter()).getItemId(i));
        }
        return list;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        PREFERENCE_NEED_UPDATE = true;
    }

    public Bundle getPreferredRSSFeed() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String key1 = getString(R.string.exclude_filter_key);
        String value1 = sharedPreferences.getString(key1, getString(R.string.pref_default_exclude_filter));
        Bundle exclude = new Bundle();
        exclude.putString(EXCLUDE_FILTER_KEY, value1);
        Log.i("IMPORTANT", "value:" + value1);
        return exclude;
    }

    public Bundle getPreferredRSSFeed2() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String key2 = getString(R.string.search_words_key);
        String value2 = sharedPreferences.getString(key2, getString(R.string.pref_default_search_words));
        Bundle search = new Bundle();
        search.putString(SEARCH_FILTER_KEY, value2);
        Log.i("IMPORTANT", "value:" + value2);
        return search;
    }
}


