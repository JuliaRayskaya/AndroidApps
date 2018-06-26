package com.example.juliarayskaya.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    private static final String TAG = "WelcomeActivity";
    TextView welcomeTitle;
    TextView welcomeText;
    TextView welcomeText2;
    ImageView welcomeImage;
    ImageView checkImage;
    Button btnShowFeed;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // найдем View-элементы
        welcomeText = findViewById(R.id.welcomeText);
        welcomeImage = findViewById(R.id.welcomeImage);
        checkImage = findViewById(R.id.check);
        welcomeText2 = findViewById(R.id.welcomeText2);
        btnShowFeed = findViewById(R.id.btnShowFeed);


        btnShowFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, FeedListActivity.class);
                startActivity(intent);
            }

        });
    }
}
