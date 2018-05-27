package com.example.juliarayskaya.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private static String TAG = "MyApp";
    private RecyclerView recyclerView;
    private List<NewsItem> newsItems = new ArrayList<>();


    /*private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

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