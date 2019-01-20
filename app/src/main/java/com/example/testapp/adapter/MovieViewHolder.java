package com.example.testapp.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testapp.R;
import com.example.testapp.model.MovieItem;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.testapp.URLs.IMAGE_BASE;

class MovieViewHolder extends RecyclerView.ViewHolder {

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bindItem(MovieItem movie) {
        TextView title = itemView.findViewById(R.id.title);
        title.setText(movie.getOriginal_title());
        TextView rating = itemView.findViewById(R.id.rating);
        rating.setText(movie.getVote_average() + "");
        ImageView poster = itemView.findViewById(R.id.poster);
        Picasso.get().load(IMAGE_BASE + movie.getPoster_path()).into(poster);
    }
}
