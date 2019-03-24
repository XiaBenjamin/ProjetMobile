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

        TextView viewScore = (TextView) findViewById(R.id.detailsScore);
        viewScore.setText(""+json.getScore());

        TextView viewRank = (TextView) findViewById(R.id.detailsRank);
        viewRank.setText("#"+json.getRank());

        TextView viewMembers = (TextView) findViewById(R.id.detailsMembers);
        viewMembers.setText("by "+json.getMembers()+" members");

        TextView viewEpisodes = (TextView) findViewById(R.id.detailsEpisodes);
        viewEpisodes.setText(""+json.getEpisodes());

        TextView viewType = (TextView) findViewById(R.id.detailsType);
        viewType.setText(json.getType());

        TextView viewStart = (TextView) findViewById(R.id.detailsStart);
        viewStart.setText("from "+json.getStart_date());

        TextView viewEnd = (TextView) findViewById(R.id.detailsEnd);
        if(json.getEnd_date() != null && !json.getEnd_date().isEmpty()){
            viewEnd.setText(" to "+json.getEnd_date());
        } else {
            viewEnd.setText(" to ?");
        }

        TextView viewStatus = (TextView) findViewById(R.id.detailsStatus);
        if(json.getEnd_date() != null && !json.getEnd_date().isEmpty()){
            viewStatus.setText("Finished Airing");
        } else {
            viewStatus.setText("Currently Airing");
        }

        ImageView viewIcon = (ImageView) findViewById(R.id.iconType);
        if(json.getType().equals("Movie")){
            viewIcon.setImageResource(R.drawable.ic_movie_name);
        } else if(json.getType().equals("OVA")) {
            viewIcon.setImageResource(R.drawable.ic_cd_name);
        } else if (json.getType().equals("TV")) {
            viewIcon.setImageResource(R.drawable.ic_tv_name);
        }


    }
}
