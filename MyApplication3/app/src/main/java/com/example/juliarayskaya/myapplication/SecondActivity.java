package com.example.juliarayskaya.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.security.Key;

import static com.example.juliarayskaya.myapplication.R.id.btnShowNews;

public class SecondActivity extends AppCompatActivity {
    Button btnReturn;
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second);

            btnReturn = (Button) findViewById(R.id.btnReturn);
            View.OnClickListener oclBtnReturn = new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                    startActivity(intent);

                }
            };

            // присвоим обработчик кнопке Return (btnReturn)
            btnReturn.setOnClickListener(oclBtnReturn);
        }
    }
