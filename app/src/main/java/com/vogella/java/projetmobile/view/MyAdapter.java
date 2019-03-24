package com.vogella.java.projetmobile.view;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vogella.java.projetmobile.R;
import com.vogella.java.projetmobile.model.Anime;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Anime> values;
    private final OnItemClickListener listener;
    private final Context context;

    public interface OnItemClickListener {
        void onItemClick(Anime item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView imgIcon;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            imgIcon = (ImageView) v.findViewById(R.id.icon);
        }
    }

    public void add(int position, Anime item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public MyAdapter(List<Anime> myDataset, OnItemClickListener listener, Context context) {
        this.values = myDataset;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Anime currentAnime = values.get(position);
        final String name = currentAnime.getTitle();
        final double score = currentAnime.getScore();
        final int rank = currentAnime.getRank();
        holder.txtHeader.setText(name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onItemClick(currentAnime);
            }
        });
        holder.txtFooter.setText("Rank : "+rank+"    "+"   Score : "+score);

        Picasso.with(context).load(currentAnime.getImage_url()).into(holder.imgIcon);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

}