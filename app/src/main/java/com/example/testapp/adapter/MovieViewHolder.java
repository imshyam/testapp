package com.example.testapp.adapter;

import android.view.View;
import android.widget.ImageButton;
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

    public void bindItem(MovieItem movie, boolean isFavoriteList) {
        TextView title = itemView.findViewById(R.id.title);
        if(movie.getOriginal_title() != null)
            title.setText(movie.getOriginal_title());
        else
            title.setText(movie.getOriginal_name());
        TextView rating = itemView.findViewById(R.id.rating);
        rating.setText(movie.getVote_average() + "");
        ImageView poster = itemView.findViewById(R.id.poster);
        Picasso.get().load(IMAGE_BASE + movie.getPoster_path()).into(poster);
        if (isFavoriteList) {
            ImageButton imageButton = itemView.findViewById(R.id.add_to_my_list);
            imageButton.setImageResource(R.drawable.ic_remove_white_24dp);
        }
    }
}
