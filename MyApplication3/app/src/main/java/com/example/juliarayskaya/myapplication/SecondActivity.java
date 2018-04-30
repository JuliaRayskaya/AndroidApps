package com.example.juliarayskaya.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.juliarayskaya.myapplication.recyclerview.AndroidDevelopersAdapter;

import java.util.ArrayList;
import java.util.List;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initRecyclerView();

    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new AndroidDevelopersAdapter(generateDevelopers());
        recyclerView.setAdapter(adapter);
    }

    private static List<AndroidDeveloper> generateDevelopers() {
        List<AndroidDeveloper> developers = new ArrayList<>();
        developers.add(new AndroidDeveloper("Artur Vasilov", "https://i.imgur.com/RMLtWSJ.png", true));
        developers.add(new AndroidDeveloper("Artem Kochkin", "https://i.imgur.com/uEM1uG7.png", false));
        developers.add(new AndroidDeveloper("Vitaly Markus", "https://i.imgur.com/dk8vMhy.png", false));
        developers.add(new AndroidDeveloper("Anton Shulipov", "https://i.imgur.com/coRG6xV.png", false));
        developers.add(new AndroidDeveloper("Anton Kraskovskiy", "https://i.imgur.com/hl2iPjo.png", false));
        developers.add(new AndroidDeveloper("Dmitry Kartsev", "https://i.imgur.com/n9IOoq7.png", false));
        developers.add(new AndroidDeveloper("Evgeniy Gaponov", "https://i.imgur.com/saM3c2r.png", false));
        developers.add(new AndroidDeveloper("Konstantin Tskhovrebov", "https://i.imgur.com/iifMkHB.png", true));
        developers.add(new AndroidDeveloper("Mike", "https://i.imgur.com/jEgCWW2.png", false));
        developers.add(new AndroidDeveloper("Sergey Ryabov", "https://i.imgur.com/vcGFMkp.png", true));
        developers.add(new AndroidDeveloper("Sergey Zavartsev", "https://i.imgur.com/vkkp9Pi.png", false));
        return developers;
    }
}