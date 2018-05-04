package com.example.juliarayskaya.myapplication;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;


public class SecondActivity extends AppCompatActivity {

    ArrayList<User> userList;
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    private static final String TAG = "MyActivity";
    ListView listView;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);




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

        userList = new ArrayList<>();
        Cursor cursor = mDb.rawQuery("SELECT  * FROM news1", null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    user = new User(cursor.getString(1), cursor.getString(2), cursor.getString(3));
                    userList.add(user);
                }
                while (cursor.moveToNext());
                    ThreeColumn_ListAdapter adapter = new ThreeColumn_ListAdapter(this, R.layout.list_adapter_view,userList);
                    listView = findViewById(R.id.listView);
                    listView.setAdapter(adapter);

            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
    }
}