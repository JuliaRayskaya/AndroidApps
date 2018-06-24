package com.example.juliarayskaya.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.juliarayskaya.myapplication.recyclerview.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewsListActivity extends AppCompatActivity {

    private static String TAG = "NewsListActivity";
    private RecyclerView recyclerView;
    private List<NewsItem> newsItems = new ArrayList<>();


    /*private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;*/

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

    private void setupAdapter(){
        RecyclerView.Adapter adapter = new NewsAdapter(newsItems);
        recyclerView.setAdapter(adapter);
    }



/*
    private List<NewsItem> generateDevelopers() {
        List<NewsItem> newsItems = new ArrayList<>();
        mDBHelper = new DatabaseHelper(this);
        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
        Cursor cursor = mDb.rawQuery("SELECT * FROM news1", null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    newsItems.add(new NewsItem(cursor.getString(1), cursor.getString(2), cursor.getString(3)));
                }
                while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return newsItems;
    }
*/



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
