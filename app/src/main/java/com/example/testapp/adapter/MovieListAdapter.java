package com.example.testapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testapp.R;
import com.example.testapp.model.MovieItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieListAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    List<MovieItem> movieItems;
//    FavoriteDao favoriteDao;

    public MovieListAdapter(List<MovieItem> movieItems/*FavoriteDao favoriteDao*/) {
        this.movieItems = movieItems;
//        this.favoriteDao = favoriteDao;
    }
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item,
                parent, false);
        return new  MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieItem movie = movieItems.get(position);
        holder.bindItem(movie);
        holder.itemView.findViewById(R.id.add_to_my_list).setOnClickListener((view) -> {
            // TODO: 25/1/19 insert to favorite
//            favoriteDao.insertAll(new FavoriteItem());
        });
    }

    @Override
    public int getItemCount() {
        return movieItems.size();
    }
}
