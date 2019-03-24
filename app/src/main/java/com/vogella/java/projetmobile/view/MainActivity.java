package com.vogella.java.projetmobile.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.vogella.java.projetmobile.R;
import com.vogella.java.projetmobile.controller.MainController;
import com.vogella.java.projetmobile.model.Anime;

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
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(input, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Anime item) {
                details(item);
            }
        }, getBaseContext());
        recyclerView.setAdapter(mAdapter);
    }

    public void details(Anime anime){
        Gson gson = new Gson();
        String json = gson.toJson(anime);
        Intent detailsIntent = new Intent(this , DetailsActivity.class);
        detailsIntent.putExtra("anime" , json);
        startActivity(detailsIntent);
    }
}
