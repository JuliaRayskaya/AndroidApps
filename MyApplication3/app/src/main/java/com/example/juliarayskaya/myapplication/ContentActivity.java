package com.example.juliarayskaya.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class ContentActivity extends AppCompatActivity {
    private static final String TAG = "ContentActivity";
    TextView contentTitle;
    TextView contentText;
    ImageView contentImage;
    ScrollView myScroll;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        // найдем View-элементы
        contentTitle = findViewById(R.id.contentTitle);
        contentText = findViewById(R.id.contentText);
        contentImage = findViewById(R.id.contentImage);
        myScroll = (ScrollView) findViewById(R.id.scrollView);

        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        Bitmap bitmap = intent.getParcelableExtra("image");

        contentImage.setImageBitmap(bitmap);
        contentTitle.setText(title);
        contentText.setText(content);
    }
}
