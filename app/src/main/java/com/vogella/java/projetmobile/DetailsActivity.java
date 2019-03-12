package com.vogella.java.projetmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.vogella.java.projetmobile.model.Anime;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        String animeJson = getIntent().getStringExtra("anime");
        Gson gson = new Gson();
        Anime json = gson.fromJson(animeJson, Anime.class);

        TextView viewTitle = (TextView) findViewById(R.id.detailsTitle);
        viewTitle.setText(json.getTitle());

        ImageView viewImage = (ImageView) findViewById(R.id.detailsImage);
        Picasso.with(getBaseContext()).load(json.getImage_url()).into(viewImage);
    }
}
