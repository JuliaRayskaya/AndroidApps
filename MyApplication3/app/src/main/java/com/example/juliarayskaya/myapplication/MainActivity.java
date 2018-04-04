package com.example.juliarayskaya.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private int btnCounter = 0;
    TextView tvOut;
    Button btnOk;
    Button btnCancel;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // найдем View-элементы
        tvOut = (TextView) findViewById(R.id.tvOut);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);


        // создаем обработчик нажатия
        OnClickListener oclBtnOk = new OnClickListener() {
            @Override
            public void onClick(View v) {

                // Меняем текст в TextView (tvOut)
                btnCounter++;
                String btc = String.valueOf(btnCounter);
                tvOut.setText(btc);
            }
        };
        btnOk.setOnClickListener(oclBtnOk);

        OnClickListener oclBtnCancel = new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

            }
        };

        // присвоим обработчик кнопке Cancel (btnCancel)
        btnCancel.setOnClickListener(oclBtnCancel);
    }

}


