package com.vogella.java.projetmobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.vogella.java.projetmobile.model.Anime;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);

        controller = new MainController(this);
        controller.onStart();
    }

    public void showList(List<Anime> input){
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }

    public void details(View view){
        // cf. randomMe() dans le MainActivity de MyFirstApp
        // cf. aussi main_activity.xml et second_activity.xml
        Intent detailsIntent = new Intent(this , DetailsActivity.class);

    }
}
