package com.example.testapp.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testapp.R;
import com.example.testapp.model.MovieItem;
import com.example.testapp.model.TvSeriesItem;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.testapp.URLs.IMAGE_BASE;

class TvViewHolder extends RecyclerView.ViewHolder {

    public TvViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bindItem(TvSeriesItem tvSeriesItem) {
        TextView title = itemView.findViewById(R.id.title);
        title.setText(tvSeriesItem.getOriginal_name());
        TextView rating = itemView.findViewById(R.id.rating);
        rating.setText(tvSeriesItem.getVote_average() + "");
        ImageView poster = itemView.findViewById(R.id.poster);
        Picasso.get().load(IMAGE_BASE + tvSeriesItem.getPoster_path()).into(poster);
    }
}
